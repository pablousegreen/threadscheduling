package intelmas.app.retriever.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import intelmas.app.retriever.service.impl.ConstruramaMailServiceImpl;

@Controller
@RequestMapping("/administration/construramastore")
public class ConstruramaController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConstruramaController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    ConstruramaMailServiceImpl construramaMailServiceImpl;
    
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	@ResponseBody
	public boolean sendMail(@RequestParam("mailId") final String mailId, @RequestParam("cc") final String cc,
			@RequestParam("body") final String body) throws Exception
	{
		try
		{
			final String dest =  mailId ;
			final String subject =  mailId ;

			if (dest != null && subject != null)
			{
//				construramaMailServiceImpl.sendMail(dest, cc, "", subject, body);
				construramaMailServiceImpl.SendEmailUsingGMailSMTP(mailId, "pablo.gonzalez@neoris.com", "", "", subject, body);
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
