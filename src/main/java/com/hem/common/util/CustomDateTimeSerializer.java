package com.hem.common.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


public class CustomDateTimeSerializer extends StdSerializer<OffsetDateTime> {

	Logger logger = LogManager.getLogger(CustomDateTimeSerializer.class);
	
	//com.ecompp.util.DateFormatter dateFormatter;
		
    private static final long serialVersionUID = -2894356342227378312L;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    
  // private SimpleDateFormat formatter = new SimpleDateFormat(DateFormatter.getCurrentDateFormat());

    public CustomDateTimeSerializer() {
   // public CustomDateSerializer() {
    	 //Class<Date> t=null;
    	this(null);
    	
    	
   
        //this(null);
        logger.debug("custome Date serialize created");
    }

    public CustomDateTimeSerializer(final Class<OffsetDateTime> t) {
        super(t);
      //  formatter= new SimpleDateFormat(dateFormatter.getCurrentDateFormat());
       // logger.debug(" cuser Date Serialize created " + dateFormatter.getCurrentDateFormat());
        logger.debug("custome Date serialize created " +  t);
    }

	@Override
	public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.format(formatter));		
	}
}