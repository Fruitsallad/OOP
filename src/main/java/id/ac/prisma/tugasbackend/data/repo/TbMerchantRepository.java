package id.ac.prisma.tugasbackend.data.repo;

import id.ac.prisma.tugasbackend.data.model.TbMerchant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TbMerchantRepository extends CrudRepository<TbMerchant, Integer>{
}
