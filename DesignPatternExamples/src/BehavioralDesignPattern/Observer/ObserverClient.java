package BehavioralDesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverClient {

	public static void main(String[] args) {
		PriceObserver priceObserver = new PriceObserver();
		QuantityObserver quantityObserver = new QuantityObserver();
		Cart cart =  new Cart(123);
		cart.attach(priceObserver);
		cart.attach(quantityObserver);
		cart.addItems(100);
		cart.addItems(100);
		cart.addItems(100);
		cart.addItems(100);
		System.out.println(cart);
	}

}

interface CartObserver {
	void updated(Cart cart);
}

class PriceObserver implements CartObserver {

	@Override
	public void updated(Cart cart) {
		if (cart.getTotalPrice() >= 200) {
			cart.setDiscount(20);
		}else if(cart.getTotalPrice()>=500) {
			cart.setDiscount(40);
		}
	}
}
class QuantityObserver implements CartObserver{

	@Override
	public void updated(Cart cart) {
		if(cart.getItemCount()>=2) {
			cart.setShippingCharge(50);
		}else if(cart.getItemCount()>=5) {
			cart.setShippingCharge(20);
		}
	}
	
}

class Cart {
	private int id;
	private int itemCount;
	private int totalPrice;
	private int discount;
	private int shippingCharge;
	List<CartObserver> observers = new ArrayList<>();

	Cart(int id) {
		this.id = id;
	}

	public void attach(CartObserver observer) {
		observers.add(observer);
	}

	public void dettach(CartObserver observer) {
		observers.remove(observer);
	}

	public void addItems(int price) {
		totalPrice += price;
		itemCount++;
		observers.forEach(o -> o.updated(this));
	}

	public int getItemCount() {
		return itemCount;
	}

	public int getTotalPrice() {
		return totalPrice + getShippingCharge() - getDiscount();
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(int shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", itemCount=" + itemCount + ", totalPrice=" + getTotalPrice() + ", discount=" + discount
				+ ", shippingCharge=" + shippingCharge + "]";
	}

}