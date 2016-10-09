package factory.abstraction;

import java.util.List;

public class GiftItem {
	private String giftId;
	private String giftName;
	private String description;
	private String packagingType; //"bag", "box", or "wrap".
	private Packaging pck;

	
	public GiftItem(String giftId, String giftName, String description, String packagingType, Packaging  pack) {
		super();
		this.giftId = giftId;
		this.giftName = giftName;
		this.description = description;
		this.packagingType = packagingType;
		this.pck = pack;
	}
} 

abstract class GiftPack {
	protected List<GiftItem> giftItems;
	protected Address shippingAddress;
	protected String packType; //"Business", "Adults", or "Kids"
	
	
	public List<GiftItem> getGiftItems() {
		return giftItems;
	}
	public void setGiftItems(List<GiftItem> giftItems) {
		this.giftItems = giftItems;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	
	abstract double getPackagingCost();

	
}