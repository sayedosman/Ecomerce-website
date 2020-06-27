package com.example.ecomerce.website.Controller;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.OfferService;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.SizeService;
import com.example.ecomerce.website.services.UserService;
import com.sun.mail.smtp.SMTPTransport;

@Controller
@RequestMapping("/Rest")
public class PasswordController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@GetMapping("/password")
	public ModelAndView showRestPassowrd() {
		ModelAndView mvn=new ModelAndView("auth/ForgetPassword");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		return mvn;
	}
	@GetMapping("/send/{email}")
	public ModelAndView send(@PathVariable("email") String email) {
		 String uemail="sayedothman46@gmail.com";
         String upass="sayosm1234";
         
         Properties props = System.getProperties();
                 props.put("mail.smtps.host","smtp.gmail.com");
                 props.put("mail.smtps.auth","true");
         
         props.put("mail.smtp.starttls","true");
         
         Session  session = Session.getInstance(props,null);
              
               try {
                         Message msg = new MimeMessage(session);
                         msg.setFrom(new InternetAddress("sayedothman46@gmail.com",false));
                     

                     msg.addRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
                     msg.setSubject("mail vervication");
                 
                     msg.setText("your vervication link is ::"+"http://localhost:8080/Rest/show/"+email);
                     msg.setHeader("X-Mailer", "Tov Are's program");
                         SMTPTransport t =
                                    (SMTPTransport)session.getTransport("smtps");
                   t.connect("smtp.gmail.com","sayedothman46@gmail.com", "sayosm1234");
                                t.sendMessage(msg, msg.getAllRecipients());
                     } catch (MessagingException ex) {
                   System.out.println(ex.toString());
               Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
             
		 ModelAndView mvn=new ModelAndView("auth/ForgetPassword2");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
                 return mvn;
	}
	@GetMapping("/show/{email}")
	public ModelAndView showrest(@PathVariable("email")String email)
	{
		ModelAndView mvn=new ModelAndView("auth/ForgetPassword3");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 mvn.addObject("email",email);
             return mvn;
	}
	@PostMapping("/passwordProcess")
	public ModelAndView passwordProcess(@ModelAttribute("email") String email) {
		User user=userService.getUser(email);
		if(user==null)
		{
			String messaged="not the mail stord in your account";
			ModelAndView mvn=new ModelAndView("auth/ForgetPassword");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			 mvn.addObject("email",email);
			 mvn.addObject("message",messaged);
			 return mvn;
		}
		else
		{
			 String uemail="sayedothman46@gmail.com";
	         String upass="sayosm1234";
	         
	         Properties props = System.getProperties();
	                 props.put("mail.smtps.host","smtp.gmail.com");
	                 props.put("mail.smtps.auth","true");
	         
	         props.put("mail.smtp.starttls","true");
	         
	         Session  session = Session.getInstance(props,null);
	              
	               try {
	                         Message msg = new MimeMessage(session);
	                         msg.setFrom(new InternetAddress("sayedothman46@gmail.com",false));
	                     

	                     msg.addRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
	                     msg.setSubject("mail vervication");
	                 
	                     msg.setText("your vervication link is ::"+"http://localhost:8080/Rest/show/"+email);
	                     msg.setHeader("X-Mailer", "Tov Are's program");
	                         SMTPTransport t =
	                                    (SMTPTransport)session.getTransport("smtps");
	                   t.connect("smtp.gmail.com","sayedothman46@gmail.com", "sayosm1234");
	                                t.sendMessage(msg, msg.getAllRecipients());
	                     } catch (MessagingException ex) {
	                   System.out.println(ex.toString());
	               Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	    		 ModelAndView mvn=new ModelAndView("auth/ForgetPassword2");
				mvn.addObject("Categeries",categoryService.getAllCategory());
				 mvn.addObject("Brands",brandService.getAllBrand());
				 mvn.addObject("email",email);
                     return mvn;
		}
	}
	
	@PostMapping("/RestProcess")
	public ModelAndView RestProcess(@RequestParam("pass") String pass,@RequestParam("repass") String repass,@RequestParam("email") String email)
	{
		
		//in this 
		if(pass.equals(repass))
		{
			System.out.println(pass);
			System.out.println(repass);
			System.out.println(email);
			User user=userService.getUser(email);
			userService.update(pass, user.getUserId());
			ModelAndView mvn=new ModelAndView("auth/login");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			
                return mvn;
		}
		else
		{
	
			System.out.println(email);
			System.out.println("welcome");
			ModelAndView mvn=new ModelAndView("auth/ForgetPassword3");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			 mvn.addObject("email",email);
                return mvn;
		}
	}
}
