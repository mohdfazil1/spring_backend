package com.example.ecom.Controller;
import com.example.ecom.Model.Registration;
import com.example.ecom.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegisterController {


    @Autowired
    RegistrationService service;

    @PostMapping("/adduser")
    public ResponseEntity<?> Addusers(@RequestBody Registration registration){
        try {
            service.addusers(registration);
            return  new ResponseEntity<>("Users Added Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getallregistration")
    public ResponseEntity<List<Registration>> Getallusers(){
        List<Registration> getdata=service.getallusers();
        return  new ResponseEntity<>(getdata,HttpStatus.OK);

    }
}
