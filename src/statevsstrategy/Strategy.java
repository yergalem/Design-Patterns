package statevsstrategy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface Model {
	public final int BASE_TICKET_PRICE = 300;
	public final int FIXED_FLIGHT_PRICE = 50000;

	double getRevenue(List flights);
}

class SinglePrice implements Model {
	private double revenue = 0;

	@Override
	public double getRevenue(List flights) {
		
		@SuppressWarnings("unchecked")
		Iterator<Flight> itr = flights.iterator();
		
		while(itr.hasNext()) {
			Flight fl = itr.next();
			revenue += fl.numberOfPassangers*BASE_TICKET_PRICE - FIXED_FLIGHT_PRICE;
		}
		
		return revenue;
	}

}

class TwoClass implements Model {
   double revenue = 0;
   
	@Override
	public double getRevenue(List flights) {

		Iterator<Flight> itr = flights.iterator();
		    double BUSINESS_BASE_TICKET_PRICE = 1.5 * BASE_TICKET_PRICE;
		    double COACH_BASE_TICKET_PRICE = 0.75 * BASE_TICKET_PRICE;
		    double TWOCLASS_FIXED_COST = 1.1 * FIXED_FLIGHT_PRICE;
		    
		while(itr.hasNext()) {
			Flight fl = itr.next();
		    
			revenue += ( 1/3.0 * fl.numberOfPassangers  ) * BUSINESS_BASE_TICKET_PRICE +
					   ( 2/3.0 * fl.numberOfPassangers )  * COACH_BASE_TICKET_PRICE - TWOCLASS_FIXED_COST;
		}
		
		return revenue;
	}

}

class MultiClass implements Model {

	double revenue = 0;
	
	@Override
	public double getRevenue(List flights) {

		Iterator<Flight> itr = flights.iterator();
		
			    double FIRST_CLASS_BASE_TICKET_PRICE = 4 * BASE_TICKET_PRICE;
			    double BUSINESS_BASE_TICKET_PRICE = 1.5 * BASE_TICKET_PRICE;
			    double COACH_BASE_TICKET_PRICE = 0.75 * BASE_TICKET_PRICE;
			    double MULTICLASS_FIXED_COST = 1.2 * FIXED_FLIGHT_PRICE;
			    
			while(itr.hasNext()) {
				Flight fl = itr.next();				
			    double val = 0.1 * fl.numberOfPassangers * FIRST_CLASS_BASE_TICKET_PRICE +
						     0.2 * fl.numberOfPassangers * BUSINESS_BASE_TICKET_PRICE    +
					         0.7 * fl.numberOfPassangers * COACH_BASE_TICKET_PRICE;
			   
				revenue += val - MULTICLASS_FIXED_COST;
			}
			
			return revenue;
		}

}


class FlightProcessor {
	private Model strategy;

	public void setStrategy(Model strategy) {
		this.strategy = strategy;
	}

	public double getTotalRevenue(List flights) {
		return strategy.getRevenue(flights);
	}
}

public class Strategy {

  public static void main(String[] args) {

	List flightList = Arrays.asList(  new Flight(200, "DRV123", "takeoff", "flight"),
									  new Flight(200, "DRV123", "takeoff", "flight"),
									  new Flight(200, "DRV123", "takeoff", "flight"),
									  new Flight(200, "DRV123", "takeoff", "flight")			
			);
	
   FlightProcessor fp= new FlightProcessor();
   double singleClsRevenue, twoClsRevenue, multiClsRevenue;
   
     fp.setStrategy( new SinglePrice());
     singleClsRevenue = fp.getTotalRevenue(flightList);
     fp.setStrategy(new TwoClass());
     twoClsRevenue = fp.getTotalRevenue(flightList);
     fp.setStrategy( new MultiClass());
     multiClsRevenue = fp.getTotalRevenue(flightList);
     
     System.out.println( String.format("Total Revenue: %.2f", singleClsRevenue +
    		 			 twoClsRevenue + multiClsRevenue) );
     
  }	
	
}
