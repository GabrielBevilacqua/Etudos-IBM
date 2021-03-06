package cameltomq.processor;

import cameltomq.model.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        Employee employee = exchange.getIn().getBody(Employee.class);
        employee.setEmpName("JavaInUse Rocks");
        System.out.println(employee);
        exchange.getIn().setBody(employee);
    }
}
