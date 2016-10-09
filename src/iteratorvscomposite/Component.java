package iteratorvscomposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class Component {
	private Collection<Component> lst = new ArrayList<>(); 
	protected String name;
	protected double id;

	public Component(String name) {
		this.name = name; 
	}

	public void addNode(Component elt) {
		lst.add(elt);
	}
	
    public Collection<Component> displayNodes(){ return lst; } 
    
	public abstract void print();
	public abstract void displayNode( Collection<Component> c);

}

class Leaf extends Component {

	private String number;
	public Leaf(String number, String title) {
		super(title);
		this.number = number;
	}
	//for addItem() method, print a message “cannot add child”
	public void print() {
		System.out.println("Leaf [isbn=" + number + ", title=" + name + "]");
	}
	@Override
	public void displayNode(Collection<Component> c) {
		// TODO Auto-generated method stub
		
	}
}


class Composite extends Component {

	public Composite(String name) {
		super(name);
	}

	public void print() {
		System.out.println("Composite name=" + name );
		Collection<Component> lst =  displayNodes();
		for (Component item : lst) {
			item.print();
			
		}
	}
	
    public  void displayNode( Collection<Component> c){ 
    	
    	//Collection<Component> lst = displayNodes();
    	Iterator<Component> itr =  c.iterator();
    	
    	if( c.isEmpty() ) return;
    	
    	while( itr.hasNext() ) {
    		Component tag = itr.next() ;
    		if( tag instanceof Leaf ){
    			System.out.println( tag );
    			c.remove(tag);
    		}
    		//else
    			//displayNode(c);
    	      tag.print();
    	}
    	
    } 

}
