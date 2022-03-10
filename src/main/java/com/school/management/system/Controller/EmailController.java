package com.school.management.system.Controller;

import com.school.management.system.Service.EmailService;
import com.school.management.system.Model.DTO.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/send")
    public ResponseEntity<EmailDto> sendEmail(@RequestBody EmailDto emailDto) {
        return service.sending(emailDto);
    }
}
