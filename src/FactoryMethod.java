import java.util.ArrayList;
import java.util.List;

public class FactoryMethod {

	public static void main(String[] args) {
		MazeGame mz = new MagicMazeGame();
	}
}


 abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<>();

    public MazeGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        //room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
        
        System.out.println("Here");
    }

    abstract protected Room makeRoom();
}
 
  class MagicMazeGame extends MazeGame {
	    @Override
	    protected Room makeRoom() {System.out.println("Comes");
	        return new MagicRoom(); 
	    }
	}

	 class OrdinaryMazeGame extends MazeGame {
	    @Override
	    protected Room makeRoom() {
	    	
	        return new OrdinaryRoom(); 
	    }
	}
	 


	 
 class Room {
	 
 }
 
 class MagicRoom extends Room {
	 
 }
 
 class OrdinaryRoom extends Room {
	 
 }
 
 
 
 