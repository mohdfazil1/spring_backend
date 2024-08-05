package com.example.ecom.Service;
import com.example.ecom.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void Sendmail(Registration registration){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setTo(registration.getEmail());
        simpleMailMessage.setSubject("Welcome To Spring Boot Test Application");
        String text = "Hello " + registration.getName() + ",\n\n" +
                "Email: " + registration.getEmail() + "\n\n" +
                "Thanks for registering with us.";
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }
}
