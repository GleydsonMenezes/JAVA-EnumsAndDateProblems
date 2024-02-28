package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Department;
import entities.HourContract;
import entities.Post;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter the exercise number: \n"
				+ "1 - Worker Contract\n"
				+ "2 - Post/Comment \n"
				+ "0 - Exit");
		
		int n = sc.nextInt();
		
		switch(n) {
		
			case 1:
				System.out.print("Enter department's name: ");
				String departmentName = sc.nextLine();
				System.out.println("Enter Worker Data: ");
				System.out.print("Worker name: ");
				String workerName = sc.nextLine();
				System.out.print("Worker Level: ");
				String workerLevel = sc.nextLine();
				System.out.print("Base Salary: ");
				double baseSalary = sc.nextDouble();
				Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
				System.out.print("How many Contracts to this worker?");
				n = sc.nextInt();
				
				for (int i = 1; i<=n; i++) {
					System.out.println("Enter Contract #"+ i + " data:");
					System.out.print("Date (DD/MM/YYYY): ");
					Date contractDate = sdf.parse(sc.next());
					System.out.print("Value per hour: ");
					double valuePerHour = sc.nextDouble();
					System.out.print("Duration (hours): ");
					int hours = sc.nextInt();
					HourContract contract = new HourContract(contractDate, valuePerHour, hours);
					worker.addContract(contract);
				}
				
				System.out.println();
				System.out.println("Enter month and year to calculate income (MM/YYYY): ");
				String monthAndYear = sc.next();
				int month = Integer.parseInt(monthAndYear.substring(0, 2));
				int year = Integer.parseInt(monthAndYear.substring(3));
				System.out.println("Name: " + worker.getName());
				System.out.println("Department: "+ worker.getDepartment().getName());
				System.out.println("Income for "+ monthAndYear + ": "+ String.format("%.2f", worker.income(year, month)));
				break;
				
			case 2:
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				Comment c1 = new Comment("Have a nice trip!");
				Comment c2 = new Comment("Wow That's Awesome!");
				Post p1 = new Post(
						sdf1.parse("21/06/2018 13:05:44"), 
						"Traveling to New Zealand", 
						"I'm Going to visit this wonderful country!", 
						12);
				
				p1.addComent(c1);
				p1.addComent(c2);
				
				System.out.println(p1);
				
				break;
		}
		
		
		
		sc.close();
	}

}
