package connection;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IService {
	
	@Inject
	private I i;
	
	public IService(){
		
	}
	
	public String getItem(){
		return i.getItem();
	}
}
