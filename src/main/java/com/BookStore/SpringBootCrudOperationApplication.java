package com.BookStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.reactive.server.AbstractReactiveWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.BookStore.controller.BooksController;
@SpringBootApplication


public class SpringBootCrudOperationApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootCrudOperationApplication.class, args);
}

}
	


