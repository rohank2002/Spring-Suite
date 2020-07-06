package accademy.ennate.Controller;

import accademy.ennate.Repository.EmployeeRepo;
import accademy.ennate.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest")
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeeRepo employeeRepo;



    @Before
    public void setup(){
        Employee emp = new Employee();
        emp.setId("rk20");
        emp.setFisrstName("rohan");
        emp.setLastName("kamat");
        emp.setEmail("rohan.kamat@ymail.com");
        employeeRepo.save(emp);


    }
    @After
    public void cleanup(){
        employeeRepo.deleteAll();
    }


    @Test
    public void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email",Matchers.is("rohan.kamat@ymail.com")));
    }

    @Test
    public void findOne() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/rk20"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("rohan.kamat@ymail.com")));
    }

    @Test
    public void findOneNotFound() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/rk2220"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    public void create() throws Exception {
        Employee emp = new Employee();
        emp.setId("sidd");
        emp.setFisrstName("siddharth");
        emp.setLastName("kamat");
        emp.setEmail("siddharth.kamat@ymail.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsBytes(emp))
                    )
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("siddharth.kamat@ymail.com")));
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status()
                .isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)));

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByEmail() {
    }
}