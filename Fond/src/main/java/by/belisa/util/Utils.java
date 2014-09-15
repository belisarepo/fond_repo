package by.belisa.util;

import java.util.Map;

import by.belisa.bean.CheckUslResult;

public class Utils {

	public static String createErrorMsg(String fio, CheckUslResult checkUslResult){
		StringBuffer message = new StringBuffer(fio);
		message.append(" не может учавствовать в конкурсе,<br/>");
		message.append("так как он уже учавствует в следующих конкурсах: <br/>");
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
}
