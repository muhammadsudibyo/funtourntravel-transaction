package id.co.funtourntravel.transaction.service;

import id.co.funtourntravel.transaction.model.Tour;
import id.co.funtourntravel.transaction.model.Transaction;
import id.co.funtourntravel.transaction.model.User;
import id.co.funtourntravel.transaction.repo.TransactionRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;



@Service
public class TransactionService {

    public TransactionRepo transactionRepo;

    public void insert(Transaction transaction){
        transactionRepo.save(transaction);

    }

    @Transactional
    public String update(Transaction transaction){
        Transaction tempTrx = transactionRepo.findTransactionById(transaction.getId());
        if (tempTrx!= null){
            transaction.setId(tempTrx.getId());
            transactionRepo.save(transaction);
            return "User telah berhasil ditambahkan";
        } else{
            return "User tidak ditemukan";
        }
    }

    public  void delete(Transaction transaction){

        transactionRepo.delete(transaction);
    }

    public  Transaction getTransactionById (Transaction transaction){
        return transactionRepo.findTransactionById(transaction.getId());

    }

    public List getAllTransaction(){
        return transactionRepo.findAll();
    }


    /**
     * get all transaction by user Id
     */
    public List findTransactionByUserId(String userId){
        User user = new User();
        user.setUserId(userId);
        return transactionRepo.findTransactionByUserId(user.getId());
    }

    @Transactional
     public String executePayment(int userId, int tourId, int paymentId, String noBayar){
            try{
                Tour tour = new Tour();
                //get Tour detail
                Transaction trx = this.prepareTransaction(userId,tour, paymentId, noBayar);
                //hit ke payment lempar transaction
                this.insert(trx);
                return "OK";
            } catch (Exception e) {
                return "failed";
            }

    }

    public Transaction prepareTransaction(int userId, Tour tour, int paymentId, String noBayar){
        Transaction trx = new Transaction();
        trx.setUserId(userId);
        trx.setTourId(tour.getId());
        trx.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        trx.setStatus("created");
        trx.setPaymentId(paymentId);
        trx.setTourDate(tour.getTourDate());
        trx.setNoBayar(noBayar);
        return  trx;
    }

    public  List AllTransactionByUser(String userName){
        User user = new User();

        return transactionRepo.findTransactionByUserId(user.getId());
    }
}
