package transformation;

import java.math.BigDecimal;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;

import model.PurchaseOrder;

public class PurchaseOrderConverter {
	@Converter
	public static PurchaseOrder csvToObject(byte[] data, Exchange exchange) {
		PurchaseOrder order = null;
		TypeConverter converter = exchange.getContext().getTypeConverter();
		String dataInStr = converter.convertTo(String.class, data);
		if(dataInStr != null) {
			String[] str = dataInStr.split(",");
			order = new PurchaseOrder(str[0], new BigDecimal(str[1]), Integer.parseInt(str[2]));
		}
		return order;
	}
}
