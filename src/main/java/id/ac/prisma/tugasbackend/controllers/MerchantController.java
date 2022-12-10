package id.ac.prisma.tugasbackend.controllers;


import id.ac.prisma.tugasbackend.data.model.TbMerchant;
import id.ac.prisma.tugasbackend.data.repo.TbMerchantRepository;
import id.ac.prisma.tugasbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/merchant"})
public class MerchantController {

    @Autowired
    TbMerchantRepository tbMerchantRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/by-id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Map getUserById(@PathVariable("id") Integer id) {
        Map response = new HashMap();
        TbMerchant tbMerchant = tbMerchantRepository.findById(id).orElse(null);
        response.put("data", tbMerchant);
        return response;
    }

    @RequestMapping(value = "/create-merchant", method = RequestMethod.POST, produces = "application/json")
    public Map createUser(@RequestBody Map bodyRequest) {
        // call function createUser
        Map createUserResponse = userService.createUser(
                bodyRequest.get("name").toString(),
                bodyRequest.get("email").toString(),
                bodyRequest.get("address").toString()
        );
        Map response = new HashMap();
        response.put("message", "success");
        response.put("data", createUserResponse.get("data"));
        return response;
    }
    @RequestMapping(value = "/get-all-merchants", method = RequestMethod.GET, produces = "application/json")
    public Iterable<TbMerchant> getAllUsers() {
        Iterable<TbMerchant> allUser = tbMerchantRepository.findAll();
        return allUser;
    }


}

