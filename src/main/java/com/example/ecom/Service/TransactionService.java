package com.example.ecom.Service;
import com.example.ecom.Model.Transaction;
import com.example.ecom.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getalltransaction(){
        return transactionRepository.findAll();
    }

    public  List<Transaction> getalltransactionbyId(int id){
        return transactionRepository.getalltransactionbyid(id);
    }

    public Transaction addtransctiondata(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
