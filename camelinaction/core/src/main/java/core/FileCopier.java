package core;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

public class FileCopier {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = CamelContextFactory.getCamelContext();
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:data/indir?noop=true")
				.to("file:data/outdir");
			}
		});
		camelContext.start();
		Thread.sleep(3000);
		camelContext.stop();
	}
}
