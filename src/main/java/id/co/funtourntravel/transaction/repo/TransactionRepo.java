package id.co.funtourntravel.transaction.repo;

import id.co.funtourntravel.transaction.model.Transaction;
import id.co.funtourntravel.transaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    public Transaction findTransactionById(Integer i);
    public List findTransactionByUserId(int user);

}

