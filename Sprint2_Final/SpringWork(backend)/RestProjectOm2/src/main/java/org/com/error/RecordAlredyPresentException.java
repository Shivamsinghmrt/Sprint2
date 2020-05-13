package org.com.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class RecordAlredyPresentException extends RuntimeException {



public RecordAlredyPresentException(String msg) {
	super(msg);
}
	
}
