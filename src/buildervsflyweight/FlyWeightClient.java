package buildervsflyweight;

import java.awt.Color;
/**
 * Demonstrates the flyweight pattern 
 * 
 * @author Yergalem
 *
 */
public class FlyWeightClient {

	private static final Color colors[] = { Color.red };
	   
	public static void main(String[] args) {

		
	      for(int i=0; i < 20; ++i) {
	    	  Color color = getRandomColor();
	    	  ConcreteFlyWeight location = FlyWeightFactory.getInstance(color);
	         
	    	  location.image.setX(getRandomX());
	    	  location.image.setY(getRandomY());
	          location.image.setRadius(100);
	          
	      } 	     
	        
	 } 	   
	   
	   private static Color getRandomColor() {
		      return colors[(int)(Math.random()*colors.length)];
		   }
	   private static int getRandomX() {
	      return (int)(Math.random()*100 );
	   }
	   private static int getRandomY() {
	      return (int)(Math.random()*100);
	   }
}
