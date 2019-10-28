package afferolab.chalenge.papelaria.error;

public class WrongCredentialsException extends Exception {

	public WrongCredentialsException(String errorMesg) {
		super(errorMesg);
	}
	
	public WrongCredentialsException(Exception e) {
		super(e);
	}
}
