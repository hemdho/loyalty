package com.hem.loyalty.service;

import com.hem.auth.model.User;

public interface MyService<T,S> {

	
	T findById(S s);	
	boolean isExist(S t);
	T create(T t,User user);
	T update(T t);
	boolean isActive(S t);
	
}
