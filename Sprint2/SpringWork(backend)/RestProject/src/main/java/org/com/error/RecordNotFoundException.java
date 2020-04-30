/*package org.com.error;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	
	
	public RecordNotFoundException(String s) {
		super(s);
	}

}

package org.com.error;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RecordNotFoundException extends RuntimeException {

	BindingResult bindingResult1;
    public RecordNotFoundException(Exception ex,BindingResult bindingResult) {
		this.bindingResult1=bindingResult;
		my();
		
	}

    public void my() {
   
 
    
    
  

    //Get all errors
    List<String> errors = bindingResult1
            .getFieldErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.toList());

   

    for(int i=0;i<errors.size();i++) {
    	System.out.println(errors.get(i));
    }
    

}
}
*/