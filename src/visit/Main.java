package visit;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args){
		DisplayNodeVisitor visitor = new DisplayNodeVisitor();
		
		Composite tree = buildTree();
		tree.accept(visitor);
		
		System.out.println("Right Nodes");
		HashMap<String, Integer> rightHashMap = visitor.getRightHashMap();
		for(Map.Entry<String, Integer> map : rightHashMap.entrySet()){
			System.out.println(map.getValue() + " " + map.getKey() + " nodes");
		}
		
		System.out.println("Left Nodes");
		HashMap<String, Integer> leftHashMap = visitor.getLeftHashMap();
		for(Map.Entry<String, Integer> map : leftHashMap.entrySet()){
			System.out.println(map.getValue() + " " + map.getKey() + " nodes");
		}
		
	}
	
	public static Composite buildTree(){
		Composite topic = new Root("Topic");
		Composite A = new Node("A", Side.RIGHT);
		Composite A1 = new Node("A1");
		Composite AA1 = new Node("AA1");
		Composite AA2 = new Node("AA2");
		Composite AA3 = new Node("AA3");
		Composite A2 = new Node("A2");
		Composite B = new Node("B", Side.RIGHT);
		Composite B1 = new Node("B1");
		Composite B2 = new Node("B2");
		Composite C = new Node("C", Side.RIGHT);
		Composite C1 = new Node("C1");
		Composite C2 = new Node("C2");
		Composite D = new Node("D", Side.LEFT);
		Composite D1 = new Node("D1");
		Composite D2 = new Node("D2");
		Composite E = new Node("E", Side.LEFT);
		Composite E1 = new Node("E1");
		Composite E2 = new Node("E2");
		Composite E3 = new Node("E3");
		Composite F = new Node("F", Side.LEFT);
		Composite F1 = new Node("F1");
		Composite F2 = new Node("F2");

		topic.addChild(A);
		topic.addChild(B);
		topic.addChild(C);
		topic.addChild(D);
		topic.addChild(E);
		topic.addChild(F);
		
		A.addChild(A1);
		A1.addChild(AA1);
		A1.addChild(AA2);
		A1.addChild(AA3);
		A.addChild(A2);
		
		B.addChild(B1);
		B.addChild(B2);
		
		C.addChild(C1);
		C.addChild(C2);
		
		D.addChild(D1);
		D.addChild(D2);
		
		E.addChild(E1);
		E.addChild(E2);
		E.addChild(E3);
		
		F.addChild(F1);
		F.addChild(F2);
		return topic;
	}
}
