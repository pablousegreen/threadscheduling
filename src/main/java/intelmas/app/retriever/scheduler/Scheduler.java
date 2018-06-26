package intelmas.app.retriever.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import intelmas.app.ThreadschedulingApplication;
import intelmas.app.retriever.service.AsynchronousService;

@Component
public class Scheduler {
	
	private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);
    @Autowired
    private AsynchronousService checkAsyncService;

    @Scheduled(fixedDelay = 10000)
    public void checkTheScedule() {
//        checkAsyncService.printEmployees();
    	LOG.debug("1000ADK100 checkTheScedule .......");
    }

}