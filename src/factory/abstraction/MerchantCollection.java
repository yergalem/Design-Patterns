package factory.abstraction;

import java.util.Iterator;
/**
 * 
 * Concrete class for creating Merchant collection Business Gift Pack 
 *
 */
public class MerchantCollection extends GiftPack {

	
	public double getPackagingCost() {
		//Iterator iterator = giftItems.iterator();
		
		return 0.5;
	}
}


/**
 * 
 * Concrete class for creating HardPlastic Business Gift Pack 
 *
 */
class HardPlasticGiftPack extends GiftPack {

	@Override
	double getPackagingCost() {
		return 1.0;
	}

}


class HolidaySurpriseGiftPack extends GiftPack {

	@Override
	double getPackagingCost() {
		
		return 0.25;
	}

}
