package harry.tan.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="MyService",targetNamespace="http://www.harry.com")
public interface IServiceHello {
	
	@WebMethod(operationName="getValue")
	public String getValue(@WebParam(name="name")String name);
	
	@WebMethod(exclude=true)
	public String youSelf(String name);
}
