package connection;

import javax.inject.Named;

@Named
public class I1Impl implements I{

	@Override
	public String getItem() {
		return "I1Impl";
	}

}
