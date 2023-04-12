package id.co.funtourntravel.transaction.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Transaction {

    private int id;
    private User userId;
    private Tour tourId;
    private String status;
    private Payment paymentId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp tourDate;

    
}
