package com.example.ecom.Service;
import com.example.ecom.Model.Registration;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number}")
    private String twilioPhoneNumber;

    public void sendSms(Registration registration) {
        try {
            Twilio.init(accountSid, authToken);

            String recipientNumber = "+91"+registration.getNumber();

            String messagebody="Hi "+registration.getName()+",\n\n"+"This is a Test Spring Boot Application"+"\n\n"+"Email Id :"+registration.getEmail()+"\n\n"+"Thank you for Register with us.";

            System.out.println(recipientNumber);

            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(recipientNumber),
                            new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                            messagebody)
                    .create();

            System.out.println("Message sent with SID: " + message.getSid());
        } catch (ApiException e) {
            System.err.println("Failed to send SMS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

