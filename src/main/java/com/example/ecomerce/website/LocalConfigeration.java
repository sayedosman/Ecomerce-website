package com.example.ecomerce.website;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
public class LocalConfigeration extends  WebMvcConfigurerAdapter  {

	@Bean
	public LocaleResolver localeResolver() {
	   SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	   sessionLocaleResolver.setDefaultLocale(Locale.US);
	   return sessionLocaleResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	   LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	   localeChangeInterceptor.setParamName("lang");
	   
	   return localeChangeInterceptor;
	}
	 /*@Bean
	    public MessageSource messageSource()  {
	        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();         
	        // For example: i18n/messages_en.properties
	        // For example: i18n/messages_fr.properties
	        messageResource.setDefaultEncoding("UTF-8");
	        return messageResource;
	    }*/
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	     
	   }
}
