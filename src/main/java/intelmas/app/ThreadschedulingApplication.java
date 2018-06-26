package intelmas.app;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import intelmas.app.retriever.scheduler.RetrieverScheduler;

@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration
public class ThreadschedulingApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ThreadschedulingApplication.class);
	public static void main(String[] args) {
		LOG.info("we are beginning the app: ThreadschedulingApplication ");
		SpringApplication.run(ThreadschedulingApplication.class, args);
	}
	
	 @Bean
	    public Executor asyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(2);
	        executor.setQueueCapacity(500);
	        executor.setThreadNamePrefix("GithubLookup-");
	        executor.initialize();
	        return executor;
	    }

}
