package com.example.ecomerce.website.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
   
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	
        User user = (User) o;
      
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
    	Matcher m = p.matcher(user.getEmail());
    	 System.out.println(user);
    	String str="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        if (user.getFirstname().length() < 4 || user.getFirstname().length() > 32) {
        	System.out.println("asd");
            errors.rejectValue("firstname", "Size.userForm.firstname");
        }
      
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
      if (user.getLastname().length() < 4 || user.getLastname().length() > 32) {
    	  System.out.println("asd2");
            errors.rejectValue("lastname", "Size.userForm.lastname");
        }
   
         if(!m.find())
    	{System.out.println("asd3");
        	  
        	 errors.rejectValue("email", "Email not vaild");
        	     	
    	}
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Not valid");
          if(!Pattern.compile(str).matcher(user.getPhone()).matches())
    	{System.out.println("asd4");
        	  errors.rejectValue("phone", "Phone not vaild"); 	
    	}
        if (userService.getUser(user.getEmail()) != null) {
        	System.out.println("asd5");
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
        	System.out.println("asd6");
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
        	System.out.println("asd7");
            errors.rejectValue("confirmPassword", "Diff.userForm.passwordConfirm");
        }
    }
}