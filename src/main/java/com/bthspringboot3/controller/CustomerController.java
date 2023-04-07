package com.bthspringboot3.controller;

import com.bthspringboot3.model.Customer;
import com.bthspringboot3.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> listCustomers() {
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}