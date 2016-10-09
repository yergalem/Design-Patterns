package visitorvsinterpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import visitorvsinterpreter.interpreter.Side;

public class VisitorDemo {

	public static void main(String[] args) {
        
           
            Component root = new Composite("Topic");
            constructTree(root);
      
            DisplayNodeVisitor nodeVisitor = new DisplayNodeVisitor();
            root.accept(nodeVisitor);
            
            System.out.println(root.getName());
            System.out.println("Right Nodes");
            display(nodeVisitor.getRightChild());
            System.out.println("Left Nodes");
            display(nodeVisitor.getLeftChild());
            
           
            
   }         
   
private static void display(Map items) {
	
	Iterator<Map.Entry<String, String>> iterator = items.entrySet().iterator() ;
    while(iterator.hasNext()){
        Map.Entry<String, String> nodeEntry = iterator.next();
        System.out.println( nodeEntry.getKey() +" :: "+ nodeEntry.getValue());
       
    }

	
}

public static void constructTree(Component topic ) {
	   
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
	}
}
