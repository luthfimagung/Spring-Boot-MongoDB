package com.management.account.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.management.account.config.Config;
import com.management.account.model.Account;
import com.management.account.model.MessageModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoDaoImpl implements MongoDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDaoImpl.class);
	Date date = new Date();

	String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);

    static ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    static MongoOperations mongo = (MongoOperations) ctx.getBean("mongoTemplate");

	@Override
	public String saveAccount(Long _id_, String name, double score, String email, String date) {
        Account account = new Account(_id_, name, score, email, date);
        mongo.save(account);
		return "Account '" + name + "' saved.";
	}

	@Override
	public MessageModel getAllAccount() {
        MessageModel message = new MessageModel();
        try {
            List<Account> listdata = mongo.findAll(Account.class);
            message.setData(listdata);
            message.setMessage("true");
            message.setStatus("200");
        } catch (Exception e){
            message.setData("null");
            message.setMessage("false");
            message.setStatus("404");
        }
		LOGGER.info("has been executed - " + thedate);
		return message;
	}

	@Override
	public MessageModel findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));        
        MessageModel message = new MessageModel();
        try {
            List<Account> listdata = mongo.find(query, Account.class);
            message.setData(listdata);
            message.setMessage("true");
            message.setStatus("200");

        } catch (Exception e) {
            message.setData("null");
            message.setMessage("false");
            message.setStatus("404");
        }
		LOGGER.info("has been executed - " + thedate);
		return message;
	}

	@Override
	public MessageModel findById(Long _id_) {
		Query query = new Query(Criteria.where("_id_").is(_id_));
		MessageModel message = new MessageModel();
		try {
			List<Account> listdata = mongo.find(query, Account.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");

		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - " + thedate);
		return message;
	}

	@Override
	public MessageModel deleteById(Long _id_) {
		Query query = new Query(Criteria.where("_id_").is(_id_));
		MessageModel message = new MessageModel();
		try {
			List<Account> listdata = mongo.find(query, Account.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");

		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - " + thedate);
		return message;
	}

	@Override
	public MessageModel deleteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageModel saveData(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageModel deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
