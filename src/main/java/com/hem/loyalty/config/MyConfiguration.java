package com.hem.loyalty.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hem.common.util.MyDateTimeFomatter;
import com.hem.common.util.SequenceGeneratorService;
import com.hem.common.util.Util;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

	@Bean
	@Autowired
	public SequenceGeneratorService getSequenceGenerator(MongoOperations mongoOperations) {
		return new SequenceGeneratorService(mongoOperations);
	}
	
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// TODO Auto-generated method stub
		resolvers.add(new org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver());
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}
	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	//	objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,true);
		
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		/*
		 * StringHttpMessageConverter string1 = new
		 * StringHttpMessageConverter(StandardCharsets.UTF_8); List<MediaType>
		 * mediaTypeList = new ArrayList<MediaType>();
		 * string1.setWriteAcceptCharset(false); // MediaType m= new MediaType
		 * converters.add(string1);
		 */
		converters.add(customJackson2HttpMessageConverter());
		WebMvcConfigurer.super.configureMessageConverters(converters);
	}

	
	 
	@Bean(name = "currentDateFormat")
	public String getCurrentDateFormat() {
		return "dd-MM-yyyy";
	}
	@Bean(name="dateTimeFormatter")
	public String getCurrentDateTimeFormat(){
		return "dd-MM-yyyy HH:mm:ss";
	}
	@Bean
	public MyDateTimeFomatter getMyDateTimeFormatter() {
		MyDateTimeFomatter formatter= new MyDateTimeFomatter(getCurrentDateFormat(),getCurrentDateTimeFormat());
		Util.setDateTimeFormatter(formatter);
		return formatter;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	
	
}
