package core;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelContextFactory {
	private static CamelContext camelContext =new DefaultCamelContext();
	public static CamelContext getCamelContext() {
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(ActiveMqConnection.getConnectionFactory()));
		return camelContext;
	}

}
