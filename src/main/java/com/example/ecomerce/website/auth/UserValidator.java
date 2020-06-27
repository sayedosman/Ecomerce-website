package com.example.ecomerce.website.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.UserService;

@Component
public class UserValidator   {
    @Autowired
    private UserService userService;
    private Map<String,String>message;

   	public Map<String, String> getMessage() {
   		return message;
   	}

   	public void setMessage(Map<String, String> message) {
   		this.message = message;
   	}
 
   	public  Map<String,String> validate(User user)
	{
		
		message=new HashMap<String, String>();
      
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
    	Matcher m = p.matcher(user.getEmail());
    	 System.out.println(user);
    	String str="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    	
        if (user.getFirstname().length() < 4 || user.getFirstname().length() > 32) {
        	message.put("firstname", "Size.userForm.firstname");
        }
      
      if (user.getLastname().length() < 4 || user.getLastname().length() > 32) {
    	  message.put("lastname", "Size.userForm.lastname");
        }
   
        if(m.matches()) {
        	
        
        if (userService.getUser(user.getEmail()) != null) {
        	
        	message.put("email", "Duplicate.userForm.email");
        }
        }
        else {
        	message.put("email", "not a email");
        }
       
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
        	message.put("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
        	
        	message.put("confirmPassword", "Diff.userForm.passwordConfirm");
        }
    	return message;
    }
}