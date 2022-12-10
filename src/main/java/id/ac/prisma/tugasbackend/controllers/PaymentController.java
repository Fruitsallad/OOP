package id.ac.prisma.tugasbackend.controllers;


import id.ac.prisma.tugasbackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/integration"})
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/submit-trx", method = RequestMethod.POST, produces = "application/json")
    public Map submitTrx(@RequestBody Map bodyRequest){
        Map response = new HashMap<>();
        String amount = bodyRequest.get("amount").toString();
        String transactionDate = bodyRequest.get("transaction_date").toString();
        String paymentMethod = bodyRequest.get("payment_method").toString();
        String merchantName = bodyRequest.get("merchant_name").toString();

        response = paymentService.submitTrx(amount, transactionDate, paymentMethod, merchantName);
        return response;

    }




}
