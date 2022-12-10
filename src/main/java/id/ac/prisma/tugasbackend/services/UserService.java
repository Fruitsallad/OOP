package id.ac.prisma.tugasbackend.services;

import id.ac.prisma.tugasbackend.data.model.TbMerchant;
import id.ac.prisma.tugasbackend.data.repo.TbMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    static
    TbMerchantRepository tbMerchantRepository;

    public static Map createUser(
            String name,
            String email,
            String address
    ){
        TbMerchant tbMerchant = new TbMerchant();
        tbMerchant.setName(name);
        tbMerchant.setEmail(email);
        tbMerchant.setAddress(address);
        tbMerchant = tbMerchantRepository.save(tbMerchant);

        Map response = new HashMap();
        response.put("data", tbMerchant);
        return response;
    }
    void createUser2(){

    }




}
