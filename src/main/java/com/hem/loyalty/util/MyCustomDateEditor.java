package com.hem.loyalty.util;

import java.text.DateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;

public class MyCustomDateEditor extends CustomDateEditor{

	public MyCustomDateEditor(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		super.setAsText(text);
	}

	
}
