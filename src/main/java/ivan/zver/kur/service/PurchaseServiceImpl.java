package ivan.zver.kur.service;

import ivan.zver.kur.exceptions.ExceptionHandler;
import ivan.zver.kur.model.Buyer;
import ivan.zver.kur.model.Employee;
import ivan.zver.kur.model.Purchase;
import ivan.zver.kur.model.Product;
import ivan.zver.kur.repository.BuyerRepository;
import ivan.zver.kur.repository.EmployeeRepository;
import ivan.zver.kur.repository.PurchaseRepository;
import ivan.zver.kur.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PurchaseServiceImpl implements PurchaseService {

    private final ExceptionHandler exceptionHandler;
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void addPurchase(Purchase purchase) {
        Product product = purchase.getProduct();
        Buyer buyer = purchase.getBuyer();
        Employee employee = purchase.getEmployee();

        if (product != null && product.getIdProduct() != null) {
            product = productRepository.findById(product.getIdProduct()).orElse(null);
        }
        if (buyer != null && buyer.getIdBuyer() != null) {
            buyer = buyerRepository.findById(buyer.getIdBuyer()).orElse(null);
        }
        if (employee != null && employee.getIdEmployee() != null) {
            employee = employeeRepository.findById(employee.getIdEmployee()).orElse(null);
        }

        purchase.setProduct(product);
        purchase.setBuyer(buyer);
        purchase.setEmployee(employee);

        purchaseRepository.save(purchase);

    }


    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Optional<Purchase> putPurchaseById(Long id, Purchase updatedPurchase) {
        Optional<Purchase> existingPurchase = purchaseRepository.findById(id);
        if(existingPurchase.isPresent()){

            Purchase purchaseToUpdate = existingPurchase.get();
            if(updatedPurchase.getProduct() != null && updatedPurchase.getProduct().getIdProduct() != null) {
                Product product = productRepository.findById(updatedPurchase.getProduct().getIdProduct()).orElse(null);
                purchaseToUpdate.setProduct(product);
            }

            if(updatedPurchase.getCountProductInPurchase() != null) {
                purchaseToUpdate.setCountProductInPurchase(updatedPurchase.getCountProductInPurchase());
            }

            if(updatedPurchase.getBuyer() != null && updatedPurchase.getBuyer().getIdBuyer() != null) {
                Buyer buyer = buyerRepository.findById(updatedPurchase.getBuyer().getIdBuyer()).orElse(null);
                purchaseToUpdate.setBuyer(buyer);
            }

            if(updatedPurchase.getEmployee() != null && updatedPurchase.getEmployee().getIdEmployee() != null) {
                Employee employee = employeeRepository.findById(updatedPurchase.getEmployee().getIdEmployee()).orElse(null);
                purchaseToUpdate.setEmployee(employee);
            }
            purchaseRepository.save(purchaseToUpdate);
        }
        return existingPurchase;
    }



    @Override
    public void deletePurchaseById(Long id) {
        purchaseRepository.deleteById(id);

    }
}
