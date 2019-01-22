package log;

import domain.Contact;

public class AOPLoggerRemover {
	
	public void log(Contact contact) {
		System.out.println("AOP Logger pointcut : before remove contact ("+ contact+") with id "+contact.getId());
	}

}