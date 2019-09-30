package com.employee.main;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.employee.config.EmployeeConfig;
import com.employee.service.EmpService;

public class Main {

	public static void main(String[] args) throws IOException {
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmpService e = new EmpService();
		e.getInput();
		

	}

}

