package hh.swd20.MovieStore;

import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MessageConfig implements WebMvcConfigurer {

	
	@Bean
	  public CookieLocaleResolver localeResolver() {
	      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	      localeResolver.setDefaultLocale(Locale.ENGLISH);
	      localeResolver.setCookieName("my-locale-cookie");
	      localeResolver.setCookieMaxAge(3600);
	      return localeResolver;
	  }
	
	   @Bean
	   public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      return localeChangeInterceptor;
	   }
	
	@Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	  }
	
	@Bean("messageSource")
	  public MessageSource messageSource() {
	      ResourceBundleMessageSource messageSource = 
	               new ResourceBundleMessageSource();
	      messageSource.setBasenames("language/messages");
	      messageSource.setDefaultEncoding("UTF-8");
	      return messageSource;
	  }
	
	
	
}
