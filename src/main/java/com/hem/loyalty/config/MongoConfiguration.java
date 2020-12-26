package com.hem.loyalty.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.hem.converter.OffsetDateTimeReadConverter;
import com.hem.converter.OffsetDateTimeWriteConverter;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration{

	private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
	
   @Autowired
   private MappingMongoConverter mongoConverter;
	
	@Override
	protected String getDatabaseName() {
		
		return "loyalty_db";
	}
	@Override
	public MongoCustomConversions customConversions() {
		converters.add(new OffsetDateTimeReadConverter());
		converters.add(new OffsetDateTimeWriteConverter());
		
		return new MongoCustomConversions(converters);
	}

}
