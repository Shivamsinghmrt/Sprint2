package org.com.dto;

import org.com.model.Test;

public class OrderRequest {
	
private Test test;


public OrderRequest() {}

public OrderRequest(Test test) {
	super();
	this.test = test;
}

public Test getTest() {
	return test;
}

public void setTest(Test test) {
	this.test = test;
}

@Override
public String toString() {
	return "OrderRequest [test=" + test + "]";
}





}
