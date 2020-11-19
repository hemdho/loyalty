package com.hem.common.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer  extends StdDeserializer<Date> {
	 
	
    private MyDateTimeFomatter formatter=Util.getMyDateTimeFormatter();
    
 
    public CustomDateDeserializer() {
       this(null);
    }
 
    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }
    
    
 
    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException, JsonProcessingException {
        String date = jsonparser.getText();
        try {
            return formatter.getDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}