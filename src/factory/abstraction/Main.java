package factory.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * Implementation of online gift items shopping using Abstract Factory Pattern
 * 
 * @author Yergalem
 *
 */
public class Main {

	public static void main(String[] args) {
		List<GiftPack> pacs = new ArrayList<>();
		GiftPackFactory busPacFactory = new BusinessGiftPackFactory();
		
		GiftPack giftPack = busPacFactory.getGiftPack("merchant");
		PackagingFactory pkfac = new PackagingFactory();
		Packaging bag = pkfac.getPackaging("bag");
		Packaging box = pkfac.getPackaging("box");
		
		List items = Arrays.asList(				
				new GiftItem("111","Pen","Blue Pen made in Italy","bag", bag), 
				new GiftItem("222","CD","CD with MP3 loaded in it","wrap", box) );
		
		giftPack.setGiftItems(items);
		giftPack.setPackType("business");
		pacs.add( giftPack );
		giftPack  = busPacFactory.getGiftPack("hardplastic");
		giftPack.setGiftItems(items);
		pacs.add( giftPack );
		
        GiftPackFactory kidPacFactory = new KidGiftPackFactory();
		
		GiftPack kidGiftPack = kidPacFactory.getGiftPack("micky");
		kidGiftPack.setGiftItems(items);
		kidGiftPack.setPackType("business");
		pacs.add( kidGiftPack );
		
		Order order = new Order();
		
		
		
		order.setLst(pacs);
		System.out.println( order.computePackagingCost() );
		
	}
}


class Order {
	
    List<GiftPack> lst = new ArrayList<>();

	public List<GiftPack> getLst() {
		return lst;
	}

	public void setLst(List<GiftPack> lst) {
		this.lst = lst;
	}
	
	public double computePackagingCost(){

		Iterator<GiftPack> itr = lst.iterator();
        double val = 0.0;
         while ( itr.hasNext() ) {
			GiftPack pak  = itr.next();
			
			val += pak.getPackagingCost();
			
		}
         
         return val;
	}
    
    
}
