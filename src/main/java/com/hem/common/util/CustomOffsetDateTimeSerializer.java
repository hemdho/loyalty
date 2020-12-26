package com.hem.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


public class CustomOffsetDateTimeSerializer extends StdSerializer<OffsetDateTime> {

	Logger logger = LogManager.getLogger(CustomOffsetDateTimeSerializer.class);
	
	//com.ecompp.util.DateFormatter dateFormatter;
		
    private static final long serialVersionUID = -2894356342227378312L;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    
  //private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CustomOffsetDateTimeSerializer() {
   // public CustomDateSerializer() {
    	 //Class<Date> t=null;
    	this(null);
    	
    	
   
        //this(null);
        logger.debug("custome Date serialize created");
    }

    public CustomOffsetDateTimeSerializer(final Class<OffsetDateTime> t) {
        super(t);
      //  formatter= new SimpleDateFormat(dateFormatter.getCurrentDateFormat());
       // logger.debug(" cuser Date Serialize created " + dateFormatter.getCurrentDateFormat());
        logger.debug("custome Date serialize created " +  t);
    }

	@Override
	public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		//if(value!=null)
		//formatter.format(value.toInstant());
			System.out.println(formatter.format(value));
		gen.writeString(formatter.format(value));		
	}
}