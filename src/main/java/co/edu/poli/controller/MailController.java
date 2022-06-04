package co.edu.poli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.models.Mail;
import co.edu.poli.repository.MailService;
import io.swagger.annotations.Api;


@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: userController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class MailController {
 
	@Autowired
	private MailService notificationService;
	
	/* JSON email...
	{
	    "mailTo": "miserrano3@poligran.edu.co",
	    "mailSubject": "hola mundo",
	    "mailContent": "bienvenidos",
	    "attachments" : ["/Users/wilsonsoto/Downloads/TransaccionPNCBANK.pdf"]
	}
	*/
	/*@RequestMapping(value = "/api/v1/msg", method=RequestMethod.GET)
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}*/
	
	@GetMapping("/msg")
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}
	
}
