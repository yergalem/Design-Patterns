package factory.abstraction;

public class ReusableShopper extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}


class PlainPaper extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0.25;
	}

}

class EveryDayValue extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}