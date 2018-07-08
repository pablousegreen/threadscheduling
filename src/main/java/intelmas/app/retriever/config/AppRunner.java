package intelmas.app.retriever.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import intelmas.app.retriever.model.Employee;
import intelmas.app.retriever.model.User;
import intelmas.app.retriever.service.GitHubLookupService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
        
        this.runLists();
        
        this.getDates();
    }
    
    public void runLists(){
    	// Initial data
    	ArrayList<Employee> list = new ArrayList<Employee>();
    	list.add(new Employee(500, "Shifoo", 150000));
    	list.add(new Employee(504, "Oogway", 120000));
    	list.add(new Employee(503, "Tigress", 100000));
    	list.add(new Employee(730, "Mantis", 45000));
    	 
    	System.out.println("Initial List :");
    	list.forEach(employee-> {
    		if(employee ==null) return;
    		logger.info("4000_Name: "+ employee.getName());
    		logger.info("4001_Id: "+employee.getId());
    		logger.info("4002_Salary: "+employee.getSalary());
    		
    	});
    			
    	 
    	//sortByName already defined in above snippet
    	Collections.sort(list, sortByName);
    	System.out.println("\nStandard Sorted by Name :");
    	list.stream().forEach(employee->{
    		if(employee ==null) return;
    		logger.info("4003_Name: "+ employee.getName());
    		logger.info("4004_Id: "+employee.getId());
    		logger.info("4005_Salary: "+employee.getSalary());
    	});
    	 
    	//lambdaSortByName already defined in above snippet
    	list.sort(lambdaSortByName);
    	System.out.println("\nLambda Sorted by Name :");
    	list.stream().forEach(employee->{
    		if(employee ==null) return;
    		logger.info("4006_Name: "+ employee.getName());
    		logger.info("4007_Id: "+employee.getId());
    		logger.info("4008_Salary: "+employee.getSalary());
    	});
//    	list.forEach(System.out::println);
    	 
    	Comparator<Employee> lambdaSortById = (Employee e1, Employee e2) -> e1.getId() - e2.getId();
    	list.sort(lambdaSortById);
    	 
    	System.out.println("\nSorted by Id :");
    	//list.forEach(System.out::println);
    	list.stream().forEach(employee->{
    		if(employee ==null) return;
    		logger.info("4009_Name: "+ employee.getName());
    		logger.info("4010_Id: "+employee.getId());
    		logger.info("4011_Salary: "+employee.getSalary());
    	});
    }
    
    Comparator<Employee> sortByName = new Comparator<Employee>() {
    	@Override
    	public int compare(Employee e1, Employee e2) {
    		return e1.getName().compareTo(e2.getName());
    	}
    };
    
    Comparator<Employee> lambdaSortByName =  
    		(Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
    		
    
    public void getDates(){
    	// Current Date
    	LocalDate today = LocalDate.now();
    	System.out.println("Current Date = " + today);
    	 
    	LocalDate todayNewYork = LocalDate.now(ZoneId.of("America/New_York"));
    	System.out.println("Current Date in America = " + todayNewYork);
    	 
    	// Current Time
    	LocalTime time = LocalTime.now();
    	System.out.println("Current Time = " + time);
    	 
    	LocalTime timeNewYork = LocalTime.now(ZoneId.of("America/New_York"));
    	System.out.println("Current Time in America = " + timeNewYork);
    	 
    	// Current Date
    	LocalDateTime now = LocalDateTime.now();
    	System.out.println("Current DateTime = " + now);
    	 
    	System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss")));
    }


}
