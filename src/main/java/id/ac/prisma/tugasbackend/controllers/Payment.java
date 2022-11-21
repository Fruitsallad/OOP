package id.ac.prisma.tugasbackend.controllers;


import id.ac.prisma.tugasbackend.data.model.TBMerchant;
import id.ac.prisma.tugasbackend.data.repo.TBMerchantRepository;
import id.ac.prisma.tugasbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/integration"})
public class Payment {

    @Autowired
    TBMerchantRepository tbMerchantRepository;

    @Autowired
    UserService UserService;

    @RequestMapping(value = "/merchant/by-id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Map getUserById(@PathVariable("id") Integer id) {
        Map response = new HashMap();
        TBMerchant tbMerchant = tbMerchantRepository.findById(id).orElse(null);
        response.put("data", tbMerchant);
        return response;
    }

    @RequestMapping(value = "/merchant/create-merchant", method = RequestMethod.POST, produces = "application/json")
    public Map createUser(@RequestBody Map bodyRequest) {
        // call function createUser
        Map createUserResponse = UserService.createUser(
                bodyRequest.get("name").toString(),
                bodyRequest.get("email").toString(),
                bodyRequest.get("address").toString()
        );
        Map response = new HashMap();
        response.put("message", "success");
        response.put("data", createUserResponse.get("data"));
        return response;
    }
    @RequestMapping(value = "/merchant/get-all-merchants", method = RequestMethod.GET, produces = "application/json")
    public Iterable<TBMerchant> getAllUsers() {
        Iterable<TBMerchant> allUser = tbMerchantRepository.findAll();
        return allUser;
    }

    @RequestMapping(value = "/submit-trx", method = RequestMethod.POST, produces = "application/json")
    public Map payment(@RequestBody Map bodyRequest) {
        String amount = (String) bodyRequest.get("amount");
        String transaction_date = (String) bodyRequest.get("transaction_date");
        String payment_method = (String) bodyRequest.get("payment_method");
        String merchant_name = (String) bodyRequest.get("merchant_name");


        Map response = new HashMap();
        response.put("status", "success");
        response.put("message", "pembayaran sedang berlangsung");
        return response;
    }
}

