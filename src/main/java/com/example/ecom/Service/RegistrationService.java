package com.example.ecom.Service;

import com.example.ecom.Model.Registration;
import com.example.ecom.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repository;
    @Autowired
    EmailService service;
    @Autowired
    MessageService message;

    public void addusers(Registration registration) {
        repository.save(registration);
        service.Sendmail(registration);
        message.sendSms(registration);
    }

   public List<Registration> getallusers(){
        return repository.findAll();
   }
}
