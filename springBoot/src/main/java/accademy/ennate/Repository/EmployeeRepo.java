package accademy.ennate.Repository;

import accademy.ennate.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

    Optional<Employee> findByEmail(String email);


}
