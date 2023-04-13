package id.co.funtourntravel.transaction.model;

import java.sql.Timestamp;

public class Tour {

    private int id;
    private Timestamp tourDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTourDate() {
        return tourDate;
    }

    public void setTourDate(Timestamp tourDate) {
        this.tourDate = tourDate;
    }
}
