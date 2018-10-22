package intelmas.app.retriever.scheduler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
@PropertySource(value = { "classpath:application.properties" })
@EnableScheduling
public class RetrieverScheduler {
	
	private static final Logger LOG = LoggerFactory.getLogger(RetrieverScheduler.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
//	@Value("${retriever.fullscanperiod}")
//	private int fullscanperiod;
	
	@Scheduled(fixedRate = 300000)
	public void reportCurrentTime() {
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}
	

	/**
	 * Scheduler for synchronizing the directory structure to remove structures
	 */
	@Scheduled(initialDelay=1000, fixedRateString = "60000")
	public void directoryStructureUpdate() {
		
		try {
			 List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
			 //Convert listnames to each row in User class and print them like a class User
			 names.stream().filter(RetrieverScheduler:: isNotSam).map(User::new).forEach(user ->{
//				 LOG.info("6000_Name: "+ user.getName());
//				 LOG.info("6000_Age: "+user.getAge());
			 });
			 //Print each list item like String
			 names.forEach(fileItem -> {
					if(fileItem == null) return;
					String filename = fileItem.replaceAll("Peter", "Pedro In Mexico");
//					LOG.info("6001_: filename: "+filename);
				});
			 processFile(names);
		} catch (Exception e) {
			LOG.info("General Exception when pooling the directory [Exception:{}]", e.toString());
		} finally {
//			LOG.info("==> Finish Updating Directory Structure [Prefix:{}][Time:{} seconds][Collection:{}]");
		}

	}
	
	
	/**
	 * Process the message file
	 * 
	 * @param message Message file to be processed
	 */
	@Async
	public void processFile(List<String> names){
		LOG.debug("900AAA wait for process list files ");
		try{
			if(names != null){
				names.stream().map(User::new).forEach(user->{
//					LOG.debug("900_User: "+user.getName());
//					LOG.debug("901_Age: "+user.getAge());
					
				});
			}
		}catch(Exception ex){
			LOG.debug("Error in : "+ex.getMessage());
		}

		
	}
	
	@Async
	public void processFile(){
		LOG.debug("900AAA001 wait processFile ");
		
	}
	
	
	
	 private static boolean isNotSam(String name) {
	        return !name.equals("Sam");
	    }

	

	
	/**
	 * Get the file prefix
	 * 
	 * @return The file prefix
	 */
	
	private int getMinute(int rawMinute){
		int roundedNumber = 15;
		return ( rawMinute / roundedNumber ) * roundedNumber;
	}
	
	static class User {
        private String name;
        private Integer age = 30;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "name : " + name + " age : " + age;
        }
    }
	
	
}
