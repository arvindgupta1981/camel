package core;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopier {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
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
