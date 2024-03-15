package com.send.email.controller;

import com.send.email.model.MailStructure;
import com.send.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService service;

    @PostMapping("/send/{mail}")
    public String sendEmail(@PathVariable String mail, @RequestBody MailStructure mailStructure){
        service.sendEmail(mail,mailStructure);
        return  "Sending email successful!";
    }


}
