package visit;

import java.util.HashMap;

public class DisplayNodeVisitor extends NodeVisitor{
	private HashMap<String, Integer> rightHashMap;
	private HashMap<String, Integer> leftHashMap;
	
	private Composite currentNode;
	
	public DisplayNodeVisitor() {
		// TODO Auto-generated constructor stub
		rightHashMap = new HashMap<>();
		leftHashMap = new HashMap<>();
		
	}
	
	public HashMap<String, Integer> getRightHashMap() {
		return rightHashMap;
	}
	
	public HashMap<String, Integer> getLeftHashMap() {
		return leftHashMap;
	}
	
	@Override
	public void visit(Node node) {
		// TODO Auto-generated method stub
		if(node.getSide() == Side.RIGHT){
			rightHashMap.put(currentNode.getName(), rightHashMap.get(currentNode.getName()) + 1);
		}
		if(node.getSide() == Side.LEFT){
			leftHashMap.put(currentNode.getName(), leftHashMap.get(currentNode.getName()) + 1);
		}
		for(Composite childNode : node.getChilds()){
			childNode.accept(this);
		}
		
	}
	
	
	@Override
	public void visit(Root root) {
		// TODO Auto-generated method stub
		for(Composite node : root.getChilds()){
			currentNode = node;
			if(node.getSide() == Side.RIGHT){
				rightHashMap.put(node.getName(), 1);
				for(Composite childNode : node.getChilds()){
					childNode.accept(this);
				}
				
			}
			else if(node.getSide() == Side.LEFT){
				leftHashMap.put(node.getName(), 1);
				for(Composite childNode : node.getChilds()){
					childNode.accept(this);
				}
			}
		}

	}

}
