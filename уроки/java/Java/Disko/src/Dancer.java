
import java.lang.reflect.Array;
import java.util.ArrayList;
import process.Actor;
import process.DispatcherFinishException;
import process.IWaitCondition;
import rnd.Randomable;

public class Dancer extends Actor{
	
	
	private static Randomable travelRnd;
	private static Randomable timeOfDancing;
	private static double timeOfParty;
	private static double timeToBegining;
	private static PartyModel model;	
	
	public Dancer(PartyModel p) {
			super();
			this.model = p;
	}

	public static void init(PartyModel partyModel, Visual partyUI){
		model=partyModel;
		travelRnd=partyUI.getChooseRandomTimeOfWay().getRandom();
		timeOfDancing=partyUI.getChooseRandomTimeOfDancing().getRandom();
}
	@Override
	protected void rule() {
		IWaitCondition ISREADY = new IWaitCondition() {
			@Override
			public boolean testCondition() {
				return model.getDisco().isOpen();
			}
			public String toString(){
				return Dancer.this.getNameForProtocol() + "чекає відкриття";
			}
		};
		IWaitCondition ISNOTREADY = new IWaitCondition() {
			@Override
			public boolean testCondition() {
				return !model.getDisco().isOpen();
			}
			public String toString(){
				return Dancer.this.getNameForProtocol() + "чекає відкриття";
			}
		};
		//идем на дискотеку
		holdForTime(travelRnd.next());
		//приехали, ждем открытия
		try {
			waitForCondition(ISREADY);
		} catch (DispatcherFinishException e) {
			return;
		}
		//дождались или было открыто
		this.model.getDisco().getQueueDisco().add(this);		
		waitForConditionOrHoldForTime(ISNOTREADY, this.timeOfDancing.next());
		this.model.getDisco().getQueueDisco().remove(this);		
	}
	

}
