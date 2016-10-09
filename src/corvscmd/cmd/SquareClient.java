package corvscmd.cmd;

import java.util.Stack;
/**
 * Demonstrates several commands that decouples invoker with the actual object
 * that performs the action. 
 * The commands perform creation, scaling and position shifting operation executed by
 * receiver
 * 
 * @author Yergalem
 *
 */
public class SquareClient {

	public static void main(String[] args) {
		Stack<Command> stk = new Stack<>();
		
		Command cmdCreate = new CreateCommand(5);
		Square newSquare = cmdCreate.execute();
		stk.add(cmdCreate);
		
		System.out.println( newSquare.getSide());
		
		Command cmdScale = new ScaleCommand(newSquare,3);
		Square scaledSquare = cmdScale.execute();
		stk.add(cmdScale);
		
		System.out.println("Scaled:"+scaledSquare.getSide());
		
		stk.pop().undo();
		
		System.out.println("Undo Scale:"+scaledSquare.getSide());
		
		Command cmdMove = new MoveCommand(newSquare,new Coordinate(0,2));		
		Square movedSquare = cmdMove.execute();
		Command cmdMove2 = new MoveCommand(movedSquare,new Coordinate(0,3));
		Square movedSquare2 = cmdMove2.execute();
		stk.add(cmdMove);   stk.add(cmdMove2);
		
		System.out.println("Moved:"+movedSquare2.getPos().posLeft);
		
		stk.pop().undo();		
		System.out.println("Moved Back:"+ newSquare.getPos().posLeft );
		
		
	}
}
