package com.example.ecom.Repository;
import java.util.List;
import com.example.ecom.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.userid = :userid")
    List<Transaction> getalltransactionbyid(@Param("userid") int userid);
}
