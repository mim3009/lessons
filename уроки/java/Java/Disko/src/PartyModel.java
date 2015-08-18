

import process.Dispatcher;

public class PartyModel {
	private Dispatcher dispatcher;
	private Disco disco;
	
	public Disco getDisco(){
		return this.disco;
	}
	
	private Dispatcher getDispatcher(){
		return this.dispatcher;
	}
	
	public void initForStart(Visual v){
		int n=v.getChooseDataCountDancers().getInt();
		Dancer.init(this, v);
		for (int i = 0; i < n; i++) {
			Dancer dancer =new Dancer(this);
			dancer.setNameForProtocol("Відвідувач"+(i+1));
			getDispatcher().addStartingActor(dancer);	
		}
		getDispatcher().addStartingActor(this.getDisco());
		//getDispatcher().start();
	}
	
	public PartyModel(Visual v, Dispatcher d){
		this.dispatcher = d;
		this.disco = new Disco(v, getDispatcher());
		initForStart(v);		
	}
	
}
