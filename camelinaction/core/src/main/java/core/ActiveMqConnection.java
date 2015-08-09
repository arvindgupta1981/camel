package core;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqConnection {
	private static final String ACTIVE_MQ = "vm://localhost";
	private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ);
	public static ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

}
