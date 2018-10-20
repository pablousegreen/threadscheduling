package intelmas.app.retriever.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import intelmas.app.retriever.service.AsynchronousService;

@RestController
public class HelloController {

//    @Autowired
//    EmployeeRepository employeeRepository;

    @Autowired
    private AsynchronousService anAsynchronousService;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

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
    
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	@ResponseBody
	public boolean sendMail(@RequestParam("mailId") final String mailId, @RequestParam("cc") final String cc,
			@RequestParam("body") final String body)
	{
		try
		{
			final String dest =  mailId ;
			final String subject =  mailId ;

			if (dest != null && subject != null)
			{
				//construramaMailService.sendMail(dest, cc, "", subject, body);
				System.out.println("POST POSITION TU SERVER SENDMAIL: {}"+ dateFormat.format(new Date()));
				System.out.println("*******900: "+dest +" , subject: "+subject +"\n "+", body: "+body);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch (final MessagingException e)
		{
			e.printStackTrace();
			return false;
		}
	}

}