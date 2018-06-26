package intelmas.app.retriever.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadConfig.class);

    @Bean
    @Primary
    public TaskExecutor threadPoolTaskExecutor() {
    	LOGGER.info("700 ThreadConfig_threadPoolTaskExecutor ");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("default_task_executor_thread");
        executor.initialize();
        
        return executor;
    }

    @Bean(name = "specificTaskExecutor")
    public TaskExecutor specificTaskExecutor() {
    	LOGGER.info("701 ThreadConfig_threadPoolTaskExecutor ");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        return executor;
    }

}