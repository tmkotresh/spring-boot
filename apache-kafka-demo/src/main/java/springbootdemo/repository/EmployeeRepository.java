package springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springbootdemo.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	List<EmployeeEntity> findById();
	
	@Query(
		      value = "select count(1) from tbl_employee as emp where upper(emp.name)  = upper(?1) and emp.delete_flag='N' ",
		      nativeQuery = true)
		  long countByName(String name);

}
