package accademy.ennate.Controller;

import accademy.ennate.entity.Employee;
import accademy.ennate.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "employees")
@Api(description = "Employee related endpoints")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(path = "ping")
    public String ping(){
        return "pong";
    }
    @GetMapping(path = "",produces = "application/json")
    @ApiOperation(value = "Finds all employee",
            notes = "Returns all employees from Db in a list)",
            response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code =200,message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Employee> findAll(){
     return service.findAll();
    }
    @GetMapping(path = "{id}",produces = "application/json")
    @ApiOperation(value = "Finds by id",
            notes = "Return a single employee)",
            response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code =200,message = "OK"),
            @ApiResponse(code = 404, message = "No Employee found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Employee findOne(@ApiParam(value = "id of the employee", required = true) @PathVariable("id") String empId){
        return service.findOne(empId);
    }
    @PostMapping(path="",consumes = "application/json",produces = "application/json")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }
    @PutMapping(path = "{id}",consumes = "application/json",produces = "application/json")
    public Employee update(@PathVariable("id") String empId, @RequestBody Employee employee){
        return service.update(empId,employee);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") String empId){
        service.delete(empId);
    }

    @GetMapping(path = "byEmail",produces = "application/json")
    public Employee findByEmail(@RequestBody String email){

        return service.findByEmail(email);

    }
}
