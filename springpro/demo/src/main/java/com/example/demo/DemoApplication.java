package com.example.demo;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketBookingService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner
{
@Autowired
private  TicketBookingService ticketBookingService;
@Autowired
private  DataSource dataSource;
	public static void main(String[] args) {
/*		ConfigurableApplicationContext applicationContext=*/
		SpringApplication.run(DemoApplication.class, args);
		// TicketBookingService ticketBookingService= applicationContext.getBean("ticketBookingService",TicketBookingService.class);
		
		
	}
  
	public void run(String... args) throws Exception {
		
		 Ticket ticket=new Ticket();
			ticket.setBookingDate(new Date());
			ticket.setDestStation("mumbai");
			ticket.setSourceStation("hyderabad");
			ticket.setPassengerName("rajesh");
			ticket.setEmail("rishirajesh89@gmail.com");
			 ticketBookingService.createTicket(ticket);
			 System.out.println("Data source::"+dataSource);
	}

}
