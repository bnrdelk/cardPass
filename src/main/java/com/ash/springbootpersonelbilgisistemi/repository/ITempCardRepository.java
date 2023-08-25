package com.ash.springbootpersonelbilgisistemi.repository;
import com.ash.springbootpersonelbilgisistemi.model.TempCard;
import com.ash.springbootpersonelbilgisistemi.repository.projection.ITempCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITempCardRepository extends JpaRepository<TempCard, Long> {
    @Query(value = "select p.pin as pin,\n" +
            "       p.name as name,\n" +
            "       p.mail as mail,\n" +
            "       min(h.zaman) as zaman,\n" +
            "       to_char(min(h.zaman), 'dd.MM.yyyy HH24mi') as tarih\n" +
            "  from trn_personel p\n" +
            "  left join trn_cihaz_hareket h\n" +
            "    on p.pin = h.pin\n" +
            "   and to_char(h.zaman, 'dd.MM.yyyy') =  :prmTarih \n" +
            " where p.aktive = 1\n" +
            " group by p.pin, p.name, p.mail\n" +
            " having coalesce(min(h.zaman), to_date( :prmTarih || '0931', 'dd.MM.yyyyHH24mi')) \n" +
            " > to_date(      :prmTarih       || '0930', 'dd.MM.yyyyHH24mi')\n",nativeQuery = true)

    List<ITempCard> getLatecomersByDay(@Param("prmTarih") String prmTarih);
}
