package com.management.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
    
    @Id
    private long _id_;
    private String name;
    private double score;
    private String email;
    private String date;

    public Account() {
        super();
    }

    public Account(long _id_, String name, double score, String email, String date) {
        super();
        this._id_ = _id_;
        this.name = name;
        this.score = score;
        this.email = email;
        this.date = date;
    }

    public long getId() {
        return _id_;
    }

    public void setId(long _id_) {
        this._id_ = _id_;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "Account [_id_=" + _id_ + ", name=" + name + ", score=" + score + ", email=" + email + ", date=" + date
                + "]";
    }
}
