package jeff.dbtest.dbservicecustomer;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbServiceCustomerApplication {

	public static void main(String[] args) {
		startH2Server();
		SpringApplication.run(DbServiceCustomerApplication.class, args);
	}
	
	
	private static void startH2Server() {
		try {
			Server h2Server = Server.createWebServer("-trace","-ifNotExists").start();
			if(h2Server.isRunning(true)) {
				System.out.println("h2 server started!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
