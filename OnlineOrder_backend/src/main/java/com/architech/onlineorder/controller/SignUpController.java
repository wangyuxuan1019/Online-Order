package com.architech.onlineorder.controller;

import com.architech.onlineorder.entity.Customer;
import com.architech.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


//每个controller负责一部分API
@Controller
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED) //也可以写在signUp里面
    public void signUp(@RequestBody Customer customer) {
        System.out.println("customer name:");
        customerService.signUp(customer);
    }
}
