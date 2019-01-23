package log;

import domain.Contact;

public class AOPLoggerSaver {
	
	public void log(Contact contact) {
		System.out.println("AOP Logger pointcut : before save contact "+ contact);
	}

}