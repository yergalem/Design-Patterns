package buildervsflyweight;

import java.awt.Color;

/**
 *  Stores Intrinsic state. Avoids duplicate instantiation of locationMap instance
 *  for many customers with same representation
 *  
 * @author Yergalem
 *
 */
public class ConcreteFlyWeight implements FlyWeight {

	Circle image;
	private static int counter = 0;
	
	public ConcreteFlyWeight( Color color ) {
		this.image = new Circle(color);
		counter++;
	}

	
	@Override
	public int countAttendants(Customer customer) {
		
		return counter;
	}
}
 