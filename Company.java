package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Company {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		System.out.print("How many employess will be registered? ");
		int n = in.nextInt();
		
		List <Employee> list = new ArrayList<>();
		
		for(int i = 0;i < n;i++) {
			System.out.printf("Employee #%d:%n",i+1);
			
			System.out.print("Id: ");
			int id = in.nextInt();
			
			in.nextLine();
			
			System.out.print("Name: ");
			String name = in.nextLine();
			
			System.out.print("Salary: ");
			double salary = in.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		System.out.println();
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int id = in.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not Exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentual = in.nextDouble();
			emp.increaseSalary(percentual);
		}
		
		System.out.println();
		
		System.out.println("List of Employees:");
		for(Employee y : list) {
			System.out.println(y);
		}
		
		in.close();

	}

}
