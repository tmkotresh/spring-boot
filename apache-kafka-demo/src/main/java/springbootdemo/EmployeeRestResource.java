package springbootdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootdemo.dto.EmployeeDto;
import springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestResource {
	private static final String PATH_VARIABLE_ID = "id";

	@Autowired
	private EmployeeService empService;

	// @NotEmpty can be used from javax.validation

	@GetMapping("/{id}/")
	public ResponseEntity<EmployeeDto> findById(@PathVariable(PATH_VARIABLE_ID) Long id) {
		return new ResponseEntity<EmployeeDto>(empService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Long> save(@RequestBody EmployeeDto req, HttpServletRequest request) {
		return new ResponseEntity<>(empService.save(req), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(PATH_VARIABLE_ID) Long id, HttpServletRequest request) {
		empService.markForDelete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(PATH_VARIABLE_ID) Long id, @RequestBody EmployeeDto req) {
		return new ResponseEntity<>("SUCCESSFULLY_UPDATED", HttpStatus.OK);
	}

}
