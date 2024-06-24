package ivan.zver.kur.repository;

import ivan.zver.kur.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> , PagingAndSortingRepository<Employee, Long> {
}
