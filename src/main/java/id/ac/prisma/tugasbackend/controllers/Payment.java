package id.ac.prisma.tugasbackend.controllers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/integration"})
public class Payment {

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
