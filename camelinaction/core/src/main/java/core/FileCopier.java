package core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class FileCopier {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = CamelContextFactory.getCamelContext();
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:data/indir?noop=true")
				.to("file:data/outdir");
				from("file:data/outdir?noop=true")
				.choice()
				.when(header("CamelFileName").endsWith(".xml"))
				.to("jms:xmlOrders")
				.when(header("CamelFileName").endsWith(".csv"))
				.to("jms:csvOrders")
				.otherwise()
				.to("jms:badOrders");
				
				
				//from("jms:xmlOrders").filter().xpath("/order[(@test==true)]").process(new Processor() {
				from("jms:xmlOrders").process(new Processor() {	
					public void process(Exchange exch) throws Exception {
						System.out.println(exch.getIn().getHeader("CamelFileName").toString());
					}
				}).multicast().to("jms:accounts","jms:store").bean(ReceipientListBean.class);
				
				from("jms:csvOrders").process(new Processor() {
					
					public void process(Exchange exch) throws Exception {
						System.out.println(exch.getIn().getHeader("CamelFileName").toString());
						System.out.println(exch.getIn().getBody(String.class));
						
					}
				});

				ExecutorService executor = Executors.newFixedThreadPool(16);
				
				
				from("jms:badOrders")
				.process(new Processor() {
					
					public void process(Exchange exch) throws Exception {
						System.out.println(exch.getIn().getHeader("CamelFileName").toString());
						
						
					}
				}).multicast()
				.parallelProcessing()
				.executorService(executor).to("jms:auditTrail", "jms:logging");	
				
			}
		});
		camelContext.start();
		Thread.sleep(3000);
		camelContext.stop();
	}
}
