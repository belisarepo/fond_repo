package by.belisa.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
	private boolean ok;
	private List<String> errMessages = new ArrayList<String>();
	
	
	public boolean isOk() {
		return errMessages.isEmpty();
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<String> getErrMessages() {
		return errMessages;
	}
	public void setErrMessages(List<String> errMessages) {
		this.errMessages = errMessages;
	}
	
	
	

}
