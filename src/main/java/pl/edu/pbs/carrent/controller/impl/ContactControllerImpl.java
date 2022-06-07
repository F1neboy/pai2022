package pl.edu.pbs.carrent.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pbs.carrent.controller.ContactController;
import pl.edu.pbs.carrent.model.Contact;
import pl.edu.pbs.carrent.service.MailService;

public class ContactControllerImpl implements ContactController {

    private MailService mailService;

    @Override
    @PostMapping("/contact")
    public void sendMessage(@RequestBody Contact contact) {
        mailService.sendMessage(contact.getFrom(), contact.getName(), contact.getSubject(), contact.getContent());
    }
}
