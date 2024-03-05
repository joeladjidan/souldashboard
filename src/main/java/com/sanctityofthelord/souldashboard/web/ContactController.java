package com.sanctityofthelord.souldashboard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/form")
    public String formcontact() {
        log.info("Ouverture du formulaire de contact");
        return "contact/index";
    }

}
