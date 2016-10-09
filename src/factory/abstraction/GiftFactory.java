package factory.abstraction;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract factory that provides concrete factories 
 *
 *
 */
public interface GiftFactory {
   abstract GiftPackFactory createGiftPack();
   abstract PackagingFactory createPackaging();
}
/**
 * 
 * A factory that gives common operations belonging to sub-classes such as business gift pack, adult and kid pack
 *
 */
abstract class GiftPackFactory  {
	abstract GiftPack getGiftPack( String name);
}

/**
 * 
 * Concrete factory for creating business gift pack instances.
 *
 */
class BusinessGiftPackFactory extends GiftPackFactory {
	
	GiftPack gp = null;  // better be interface
	@Override
	public GiftPack getGiftPack(String name) {
		if (name.equals("merchant")) {
			gp =  new MerchantCollection();
		} else if( name.equals("hardplastic") ){
			gp =  new HardPlasticGiftPack();
		}
		else  gp = new HolidaySurpriseGiftPack();
	
	  
		return gp;
  
   }
}

/**
 * 
 * Concrete factory for creating adult gift pack instances.
 *
 */
class AdultGiftPackFactory extends GiftPackFactory {
	
	GiftPack gp = null;  // better be interface
	@Override
	public GiftPack getGiftPack(String name) {
		if (name.equals("reusable")) {
			gp =  new ReusableShopper();
		} else if( name.equals("paper") ){
			gp =  new PlainPaper();
		}
		else  gp = new EveryDayValue();
	
	  
		return gp;
  
   }
}

/**
 * 
 * Concrete class for creating business Kid pack instances.
 *
 */
class KidGiftPackFactory extends GiftPackFactory{
	
	GiftPack gp = null;  // better be interface
	@Override
	public GiftPack getGiftPack(String name) {
		if (name.equals("happykid")) {
			gp =  new HappyKid();
		} else if( name.equals("micky") ){
			gp =  new Micky();
		}
		else  gp = new Cartoon();
	
	  
		return gp;
  
   }
}

/**
 * 
 * Concrete Factory for creating packaging instances such as Bag, Box and Wrap
 *
 */
class PackagingFactory  {
	
	Packaging pac = null;  // better be interface
	
	public Packaging getPackaging(String name) {
		if ( name.equals("bag") ) {
			pac =  new Bag();
		} else if( name.equals("micky") ){
			pac =  new Box();
		}
		else  pac = new Wrap();	
	  
		return pac;
  
   }
}

/**
 * 
 * Provides common functionalities that belong to packaging types as that of Bag, Box and Wrap
 *
 */
 interface Packaging {
  	abstract void createWeightMap();
 }


class Bag implements Packaging {
    String name;
    Map<String, Double> rate = new HashMap<>();

    public Bag() {
		
	}

	@Override
	public void createWeightMap() {

       
		
	}

}

class Box implements Packaging {

	@Override
	public void createWeightMap() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class Wrap implements Packaging {

	@Override
	public void createWeightMap() {
		// TODO Auto-generated method stub
		
	}
	
	
}