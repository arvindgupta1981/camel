package basics;

import org.apache.camel.RecipientList;
import org.apache.camel.language.XPath;

public class ReceipientListBean {
	@RecipientList
	public String[] route(@XPath("/order/@customer") String customer) {
		if(customer != null && customer.equals("honda")) {
			return new String[] {"jms:accounting", "jms:store"};
		} else {
			return new String[] {"jms:accounting"};
		}
	}
}
