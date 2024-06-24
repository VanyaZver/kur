package ivan.zver.kur.repository;

import ivan.zver.kur.model.Product;
import ivan.zver.kur.model.ProductWithCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
    @Query("SELECT new baranow.polikek.kursach.model.ProductWithCount(p.idProduct, p.productName, COUNT(pu.idPurchase)) " +
            "FROM product p " +
            "JOIN p.purchases pu " +
            "GROUP BY p.idProduct, p.productName " +
            "ORDER BY COUNT(pu.idPurchase) DESC")
    List<ProductWithCount> findTop5Products();
}
