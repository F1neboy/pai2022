package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Contact;

public interface ContactController {

    void sendMessage(Contact contact);
}
