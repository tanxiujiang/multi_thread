package harry.tan.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ServiceHello implements IServiceHello {

	@Override
	public String getValue(String name) {
		return "my name is " + name;
	}

	public static void main(String[] args) {
		IServiceHello service = new ServiceHello();
		Endpoint.publish("http://localhost:9001/service/serviceHello", service);
		System.out.println("start is success");
	}

	@Override
	public String youSelf(String name) {
		
		return null;
	}
}
