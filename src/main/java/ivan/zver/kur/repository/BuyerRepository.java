package ivan.zver.kur.repository;

import ivan.zver.kur.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> , PagingAndSortingRepository<Buyer, Long> {

}
