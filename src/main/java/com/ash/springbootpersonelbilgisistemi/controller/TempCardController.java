package com.ash.springbootpersonelbilgisistemi.controller;

import com.ash.springbootpersonelbilgisistemi.repository.projection.ITempCard;
import com.ash.springbootpersonelbilgisistemi.service.ITempCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")//pre-path
public class TempCardController {
    @Autowired
    private ITempCardService tempCardService;

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @GetMapping("/latecomers")
    public ResponseEntity<?> getLatecomers(@RequestParam("prmTarih") String prmTarih){
        return ResponseEntity.ok(tempCardService.getLatecomersByDay(prmTarih));
    }

    @PostMapping("/sendmails")
    public ResponseEntity<?> sendMails(@RequestBody() Map<String,Object> body){
        if(body.get("prmTarih1")!=null && body.get("ids")!=null){
            List<ITempCard> liste= tempCardService.getLatecomersByDay(body.get("prmTarih1").toString());

            List<Long> idList = (List<Long>) body.get("ids");

            List<Long> matchedPins = new ArrayList<>();

            /*!!
            List<ITempCard> mailList = liste.stream().filter(item->
                    idList.contains(item.getPin())
            ).collect(Collectors.toList());

            System.out.println(mailList); //!! empty
            */

            for(ITempCard tempCard : liste) {

                String toEmail= tempCard.getMail();
                String subject = "Latecomer Notification";
                String text = ("Don't come late ya " + tempCard.getName());

                sendSimpleMessage(toEmail, subject, text);
            }
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllComers(){
        return new ResponseEntity<>(tempCardService.getAllCards(), HttpStatus.OK);
    }
}

