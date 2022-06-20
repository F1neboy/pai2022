package pl.edu.pbs.carrent.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.edu.pbs.carrent.CarRentApplication;
import pl.edu.pbs.carrent.config.WebMvcConfig;
import pl.edu.pbs.carrent.config.WebSecurityConfig;
import pl.edu.pbs.carrent.model.*;
import pl.edu.pbs.carrent.payload.request.LoginRequest;
import pl.edu.pbs.carrent.repository.UserRepository;
import pl.edu.pbs.carrent.security.services.UserDetailsImpl;
import pl.edu.pbs.carrent.security.services.UserDetailsServiceImpl;
import pl.edu.pbs.carrent.service.Impl.ReservationServiceImpl;
import pl.edu.pbs.carrent.service.ReservationService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


//@WebMvcTest(ReservationControllerImpl.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = {ReservationControllerImpl.class,
//        WebMvcConfig.class
//})
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarRentApplication.class)
class ReservationControllerImplTest {
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ReservationServiceImpl reservationService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilter(springSecurityFilterChain).build();
    }

    @Test
    void addReservation() throws Exception {
        Salon s1 = new Salon(1L, "Bydgoszcz", "Fordonska 123");
        Salon s2 = new Salon(2L, "Warszawa", "Bydgoska 13");
        Car c1 = new Car(1L, "Passat", "2012, czerwony", "Volkswagen", null, s1, true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        User u4 = new User("Ewa", "Kot", "ewakot3@gmail.com", "789104940", "Grunwaldzka 19/3 Bydgoszcz", Date.valueOf(LocalDate.parse("24-12-1980", formatter)), "ewakot55", "mirnai321)");
        User u13 = new User("Karolina", "Bednarek", "karolina.b@interia.pl", "123295105","Krzywa 13 Warszawa", Date.valueOf(LocalDate.parse("10-10-1990", formatter)), "karolina12", "ksan13m;1");


        Employee e1 = new Employee(1L, u13, s1);
//        Employee e2 = employeeRepository.save(new Employee(0l, u14, s2));

        Reservation reservation = new Reservation();
        reservation.setCarReservation(c1);
        reservation.setSalonStart(s1);
        reservation.setSalonEnd(s2);
        reservation.setStartDate(Date.valueOf(LocalDate.now()));
        reservation.setExpectedEndDate(Date.valueOf(LocalDate.now().plusDays(3)));
        reservation.setEmployeeStart(e1);
        reservation.setUserReservation(u4);
        reservation.setState(ReservationState.APPOINTED);
        Optional<Reservation> optionalReservation = Optional.of(reservation);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(u4.getUsername());
        loginRequest.setPassword(u4.getPassword());

        MockHttpServletRequestBuilder mockLoginRequest = MockMvcRequestBuilders.post("/api/auth/signin")
                .content(this.mapper.writeValueAsString(loginRequest))
                .accept("application/json;charset=UTF-8");

        ResultActions result
                = mockMvc.perform(mockLoginRequest)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        String token = jsonParser.parseMap(resultString).get("accessToken").toString();

        Mockito.when(reservationService.addReservation(reservation)).thenReturn(optionalReservation);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/reservation")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(reservation));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
                //.andExpect(jsonPath("$.name", is("John Doe")));
    }
}