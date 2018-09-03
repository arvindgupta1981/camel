package core;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelContextFactory {
	private static CamelContext camelContext =new DefaultCamelContext();
	private static final int WAIT_TIME = 5000;
	
	public static CamelContext getCamelContext() {
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(ActiveMqConnection.getConnectionFactory()));
		return camelContext;
	}
	
	public static void start() throws Exception {
		camelContext.start();
		Thread.sleep(WAIT_TIME);
	}
	
	public static void stop() throws Exception {
		camelContext.stop();
	}
	

}
