package com.gl.donate_receive;

import com.gl.donate_receive.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class DonateReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonateReceiveApplication.class, args);
	}

}
