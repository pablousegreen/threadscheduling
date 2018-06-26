package intelmas.app.retriever.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intelmas.app.retriever.service.AsynchronousService;

@RestController
public class HelloController {

//    @Autowired
//    EmployeeRepository employeeRepository;

    @Autowired
    private AsynchronousService anAsynchronousService;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(value = "/alarms/runTask", method = RequestMethod.GET)
    public String executeAsync() {
    	try{
    		anAsynchronousService.executeAsynchronously();
    		anAsynchronousService.executeAsynchronously0();
    	}catch(Exception ex){
    		LOGGER.info("Error 500 : "+ex.getMessage());
    	}

        return "OK";
    }

//    @RequestMapping("/employees")
//    public List<Employee> employees() throws Exception {
//
//        return anAsynchronousService.fetchEmployess().get();
//    }
//
//    @RequestMapping(value = "/employee",method = RequestMethod.POST)
//    public void add(@RequestBody Employee employee) {
//
//        employeeRepository.save(employee);
//    }

}