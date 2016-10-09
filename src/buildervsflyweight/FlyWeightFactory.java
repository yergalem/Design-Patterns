package buildervsflyweight;

import java.awt.Color;
import java.util.HashMap;

public class FlyWeightFactory {
	static ConcreteFlyWeight byColor[] = new ConcreteFlyWeight[1];
	static {
		byColor[0] = new ConcreteFlyWeight( Color.red );
	} 

	 private static final HashMap<Color, ConcreteFlyWeight> locMap = new HashMap();

	 public static ConcreteFlyWeight getInstance( Color color) {
		 ConcreteFlyWeight imgMap = (ConcreteFlyWeight)locMap.get(color);

	      if( imgMap == null) {
	    	  imgMap = new ConcreteFlyWeight( Color.red );
	          locMap.put(color, imgMap);
	         System.out.println("Creating locationMap  : " + color);
	      }
	      
	      return imgMap;
	 }
	

	public static ConcreteFlyWeight getInstance(int i) {
		return byColor[i%byColor.length];
	}
}
