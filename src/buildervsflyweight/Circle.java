package buildervsflyweight;

import java.awt.Color;

public class Circle  {
	   private Color color;
	   private int x;
	   private int y;
	   private int radius;

	   public Circle(Color color){
	      this.color = color;		
	   }

	   public void setX(int x) {
	      this.x = x;
	   }

	   public void setY(int y) {
	      this.y = y;
	   }

	   public void setRadius(int radius) {
	      this.radius = radius;
	   }

	   public void draw(){
		   System.out.println("Creating Image:");
	   }
	  
	}
