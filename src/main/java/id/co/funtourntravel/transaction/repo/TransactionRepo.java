package id.co.funtourntravel.transaction.repo;

import id.co.funtourntravel.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}
