package factory.abstraction;

public class HappyKid extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0.1;
	}

}

class Micky extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0.25;
	}

}

class Cartoon extends GiftPack {

	@Override
	double getPackagingCost() {
		// TODO Auto-generated method stub
		return 0.5;
	}

}
