package intelmas.app.retriever.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import intelmas.app.retriever.config.MyThread;
import intelmas.app.retriever.controller.HelloController;

@Service
public class AsynchronousService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousService.class);


    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Async
//    @Transactional
//    public void printEmployees() {
//
//        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
//        employees.stream().forEach(e->System.out.println(e.getEmail()));
//    }
//
//    @Async("specificTaskExecutor")
//    @Transactional
//    public CompletableFuture<List<Employee>> fetchEmployess() {
//        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
//        return CompletableFuture.completedFuture(employees);
//    }


    public void executeAsynchronously0() {

        MyThread myThread = applicationContext.getBean(MyThread.class);
        taskExecutor.execute(myThread);
    }
    
    public void executeAsynchronously() {
    	MyThread myThread = applicationContext.getBean(MyThread.class);
//        taskExecutor.execute(myThread);
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                //TODO add long running task
            	LOGGER.debug("799_ execute");
            }
        });
    }
}
