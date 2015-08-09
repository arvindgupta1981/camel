package core;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouting {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = CamelContextFactory.getCamelContext();
		
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
			}
		});
	}

}

