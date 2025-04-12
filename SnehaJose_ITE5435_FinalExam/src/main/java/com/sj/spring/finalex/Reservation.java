package com.sj.spring.finalex;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reservation {

    @Id
    private String id;
    private String ticketClass;
    private int passengers;
    private String time;
    private String date;

    private Customer customer;
    private Payment payment;

    public Reservation() {
    }

    public Reservation(String id, String ticketClass, int passengers, String time, String date, Customer customer, Payment payment) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.passengers = passengers;
        this.time = time;
        this.date = date;
        this.customer = customer;
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", ticketClass='" + ticketClass + '\'' +
                ", passengers=" + passengers +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
