package visit;

import java.util.ArrayList;

public abstract class Composite implements Component{
	protected ArrayList<Composite> childs;
	protected Side side = Side.NONE;
	
	public Composite(){
		childs = new ArrayList<>();
	}
	
	public void setSide(Side side){
		this.side = side;
	}
	
	public void addChild(Composite node){
		if(this.side != Side.NONE){
			node.setSide(this.side);
		}
		
		childs.add(node);
	}
	
	public ArrayList<Composite> getChilds(){
		return childs;
	}
	
	public abstract String getName();
}

enum Side{
	RIGHT, LEFT, NONE;
}