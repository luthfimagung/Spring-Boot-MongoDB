package com.management.account.controller;

import java.text.SimpleDateFormat;
// import java.util.Arrays;
import java.util.Date;
// import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

// import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.management.account.dao.impl.MongoDao;
import com.management.account.model.Account;
import com.management.account.model.MessageModel;
import com.management.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@Primary
@RequestMapping("/api")
public class AccountController {
    Date date = new Date();
    @Autowired
    MongoDao mongo;

    MessageModel msg = new MessageModel();

    @Autowired
    public AccountRepository accountRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public MessageModel getAllAccount() throws JsonProcessingException {
        msg = mongo.getAllAccount();
        return msg;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createAccount(@RequestParam(value = "_id_") Long _id_, @RequestParam(value = "name") String name, 
            @RequestParam(value = "score") double score, @RequestParam(value = "email") String email) {
        String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(date);
        // response.setStatus(HttpServletResponse.SC_CREATED);
        return mongo.saveAccount(_id_, name, score, email, thedate);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public MessageModel save(@RequestParam(value = "_id_") Long _id_, @RequestParam(value = "name") String name,
            @RequestParam(value = "score") double score, @RequestParam(value = "email") String email) {
        String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(date);
        // response.setStatus(HttpServletResponse.SC_CREATED);
        Account account = new Account(_id_, name, score, email, thedate);
        msg = mongo.saveData(account);
        return msg;
    }

    @RequestMapping(value = "/deleteId/{_id_}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteByEmpId(@PathVariable("_id_") Long _id_) {
        if (accountRepository.existsById(_id_)) {
            accountRepository.deleteById(_id_);
            return "Account with Id '" + _id_ + "' was deleted.";
        } else
            return "Account with Id '" + _id_ + "' was not found.";
    }

    @RequestMapping(value = "/deleteName/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteByName(@PathVariable("name") String name){
        if (accountRepository.existsByName(name)){
            accountRepository.deleteByName(name);
            return "Account '" + name + "' deleted.";
        } else
            return "Account '" + name + "' was not found.";
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAllAccount() {
        accountRepository.deleteAll();
        return "All Accounts Deleted.";
    }

    @RequestMapping(value = "/findId/{_id_}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Account> findById(@PathVariable("_id_") Long _id_) {
        return accountRepository.findById(_id_);
    }

    @RequestMapping(value = "/findName/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Account> findByName(@PathVariable("name") String name){
        return accountRepository.findByName(name);
    }
}
