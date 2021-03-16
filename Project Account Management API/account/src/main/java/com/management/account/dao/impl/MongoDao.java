package com.management.account.dao.impl;

import com.management.account.model.Account;
import com.management.account.model.MessageModel;

public interface MongoDao {
    String saveAccount(Long _id_, String name, double score, String email, String date);
    MessageModel getAllAccount();
    MessageModel findByName(String name);
    MessageModel findById(Long _id_);
    MessageModel deleteById(Long _id_);
    MessageModel deleteByName(String name);
    MessageModel saveData(Account account);
    MessageModel deleteAll();
}
