package com.example.ecom.Controller;

import com.example.ecom.Model.Transaction;
import com.example.ecom.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getalltransactionS")
    public List<Transaction> GetallTransaction() {
        return transactionService.getalltransaction();
    }


    @GetMapping("/gettransactionbyid/{id}")
    public List<Transaction> Getalltransactionbyid(@PathVariable int id) {
        return transactionService.getalltransactionbyId(id);
    }


    @PostMapping("/addtransction")
    public ResponseEntity<?> Addtransction(@RequestBody Transaction transaction) {
        transactionService.addtransctiondata(transaction);
        return new ResponseEntity<>("Subscription Created Successfully", HttpStatus.OK);
    }
}
