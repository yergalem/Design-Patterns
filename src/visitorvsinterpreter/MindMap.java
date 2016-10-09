package visitorvsinterpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import visitorvsinterpreter.interpreter.Side;


interface NodeVisitor {
    void visit( Root root);
    void visit( Node node);
}

interface Component {
	
    void accept( NodeVisitor visitor);
    void addChild(Component child);
	Side getSide();
    String getName();
}

class Composite implements Component {
    private String name;    
    private Side side;
    
    private List<Component> children = new ArrayList<>();

    public Composite(String name){
    	this.name = name;
    }
    public Composite(String name, Side sid) {
        this.name = name;
        //children = new ArrayList<>();;
        this.side = sid;
    }

    public String getName() {
        return this.name;
    }

	@Override
	public Side getSide() {
		
		return side;
	}
	
	public void setSide(Side side){
		this.side = side;
	}
	
	public void addChild(Component e) {
	      children.add(e);
	}
	@Override
	public void accept(NodeVisitor visitor) {
		
		Iterator<Component> itr = children.iterator();
		while (itr.hasNext()) {
			Component component = (Component) itr.next();
			
			component.accept(visitor);
		}
	}
	public List<Component> getChildren() {
		return children;
	}
	
	

}

class Root extends Composite {
    public Root(String name) {
		super(name);
		
	}

	public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}

class Node extends Composite {
	
    public Node(String name) {
		super(name);
		
	}
	public Node(String name, Side side) {
		super(name, side);
	}
	public void accept( NodeVisitor visitor) {
        visitor.visit(this);
    }
}


class DisplayNodeVisitor implements NodeVisitor {
	private Map<String, Integer> rightChild;
	private Map<String, Integer> leftChild;
		
	public DisplayNodeVisitor() {

		rightChild = new HashMap<>();
		leftChild = new HashMap<>();
		
	}
	
	public Map<String, Integer> getRightChild() {
		return rightChild;
	}
	
	public Map<String, Integer> getLeftChild() {
		return leftChild;
	}
	

    public void visit(Root root) {      
        System.out.println( root.getName() );
        
    }

    public void visit(Node node) {
    	
    	if(node.getSide() == Side.RIGHT){
			rightChild.put( node.getName(), rightChild.get(node.getName()) + 1);
		}
		if(node.getSide() == Side.LEFT){
			leftChild.put( node.getName(), leftChild.get(node.getName()) + 1);
		}

        List<Component> children = node.getChildren();
        for (Component child: children) {
			child.accept(this);		
		}
        
       
    }

}

class SaveNodeVisitor implements NodeVisitor {

	@Override
	public void visit(Root root) {
	}

	@Override
	public void visit(Node node) {
	}
   
}




