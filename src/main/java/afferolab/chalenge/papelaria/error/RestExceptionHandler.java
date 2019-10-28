package afferolab.chalenge.papelaria.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { WrongCredentialsException.class }) 
	protected ResponseEntity<Object> handleEntityNotFound(WrongCredentialsException ex,  WebRequest request) {

		ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED,"Please, double check CM user id and password sent in request header",ex);
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	
	@ExceptionHandler(value = {JsonMappingException.class }) protected
	ResponseEntity<Object> handleEntityNotFound(JsonMappingException ex,  WebRequest request) {

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Please, check the format of your request JSON",ex);
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(value = {JsonParseException.class }) protected
	ResponseEntity<Object> handleEntityNotFound(JsonParseException ex,  WebRequest request) {

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Please, check the format of your request JSON",ex);
		return buildResponseEntity(apiError);
	}
	

}