package id.co.funtourntravel.transaction.model.DTO;

import jakarta.persistence.Column;

import java.sql.Timestamp;

public class InputTransaction {

    private int userId;

    private int tourId;

    private int paymentId;

    private String noBayar;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getNoBayar() {
        return noBayar;
    }

    public void setNoBayar(String noBayar) {
        this.noBayar = noBayar;
    }
}
