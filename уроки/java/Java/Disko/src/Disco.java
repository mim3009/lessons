
import process.Actor;
import process.Dispatcher;
import process.QueueForTransactions;

public class Disco extends Actor {
	private paint.Painter painter;
	private double timeOfParty;
	private double timeToBegining;
	private boolean open = false;
	private Dispatcher dispatcher;
	private Visual visual;
	
	private QueueForTransactions queueDisco;
	public QueueForTransactions getQueueDisco(){ 
		if(queueDisco == null){
			this.queueDisco = new QueueForTransactions();
			queueDisco.setDispatcher(dispatcher);
			queueDisco.setPainter(this.visual.getDiagram().getPainter());			
		}
		return this.queueDisco;
		
	}
	public boolean isOpen(){
		return this.open;
	}
	public Disco(Visual v, Dispatcher d){
		this.visual = v;
		this.painter = v.getDiagram().getPainter();
		this.timeOfParty = v.getChooseDataTimeOfParty().getDouble();
		this.timeToBegining = v.getChooseDataTimeToBegining().getDouble();
		this.dispatcher = d;
	}
	
	public void setPainter(paint.Painter p){
		this.painter = p;
	}
	
	public paint.Painter getPainter(){
		return this.painter;
	}
	protected void rule() {
		holdForTime(this.timeToBegining);
		this.open = true;
		holdForTime(timeOfParty);
		this.open = false;
	}
	
}
