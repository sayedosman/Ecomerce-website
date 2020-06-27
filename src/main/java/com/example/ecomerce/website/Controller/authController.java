package com.example.ecomerce.website.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.Servlet;
import javax.validation.Valid;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.auth.UserValidator;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.SizeService;
import com.example.ecomerce.website.services.UserService;
import com.sun.mail.smtp.SMTPTransport;

import io.swagger.models.Model;
@Controller
public class authController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	 @Autowired
	 private UserValidator userValidator;
	 @Autowired
	 private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView showProducts()
	  {
		System.out.println("welcome");
		  ModelAndView mvn=new ModelAndView("auth/login");
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  return mvn;
	  }
	
	@GetMapping("/register")
	public ModelAndView showRegister()
	{
		List<String>genders=new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		 ModelAndView mvn=new ModelAndView("auth/Register");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  mvn.addObject("genders",genders);
		  return mvn;
		/*model.addAttribute("user", new User());
		model.addAttribute("Categeries",categoryService.getAllCategory());
		model.addAttribute("Brands",brandService.getAllBrand());
		model.addAttribute("genders",genders);
		  return "auth/Register";*/
	}
	@PostMapping("/processRegister")
	public ModelAndView ProcessRegister(@ModelAttribute("user") User  user,BindingResult bindingResult)
	{
		//Color color=new Color();
		  Map<String,String>message=userValidator.validate(user);
		if (message.size()>0) {
			System.out.println("welcome");
			bindingResult.getAllErrors().get(0);
			List<String>genders=new ArrayList<String>();
			genders.add("Male");
			genders.add("Female");
			ModelAndView mvn=new ModelAndView("auth/Register");
			 mvn.addObject("Categeries",categoryService.getAllCategory());
			  mvn.addObject("Brands",brandService.getAllBrand());
			  mvn.addObject("user",user);
			  mvn.addObject("genders",genders);
			  mvn.addObject("bindingResult",bindingResult);
			  return mvn;
        }
		userService.save(user,"user");
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
                     

                     msg.addRecipients(Message.RecipientType.TO,InternetAddress.parse(user.getEmail()));
                     msg.setSubject("mail vervication");
                 
                     msg.setText("your vervication link is ::"+"http://localhost:8080/login");
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
		
		
		
		
		
	
	
	
	
}
