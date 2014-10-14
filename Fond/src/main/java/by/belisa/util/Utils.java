package by.belisa.util;

import java.util.List;
import java.util.Map;

import by.belisa.bean.CheckUslResult;
import by.belisa.validation.ValidationResult;

public class Utils {

	public static String createErrorMsg(String fio, CheckUslResult checkUslResult){
		StringBuffer message = new StringBuffer(fio);
		message.append(" не может учавствовать в конкурсе,<br/>");
		message.append("так как он уже участвует в следующих конкурсах: <br/>");
		message.append("<ul>");
		for (Map.Entry<String, String> entry : checkUslResult.getKonkursRuk().entrySet()){
			message.append("<li>");
			message.append(entry.getKey());
			message.append(" - руководитель ");
			message.append(entry.getValue());
			message.append("</li>");
		}
		message.append("</ul>");
		return message.toString();
	}
	public static String createErrorMsg(ValidationResult vr){
		List<String> errors = vr.getErrMessages();
		StringBuffer message = new StringBuffer("<ul>");
		for (String entry : errors){
			message.append("<li>");
			message.append(entry);
			message.append("</li>");
		}
		message.append("</ul>");
		return message.toString();
	}
}
