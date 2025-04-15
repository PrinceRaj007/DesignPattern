package StructuralDesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverClient {
	public static void main(String[] args) {
		Cart cart = new Cart(100);
		CartObserver observer = new PriceObserver();
		cart.attach(observer);
		cart.addInCart(100);
		cart.addInCart(150);
		System.out.println(cart);
	}
}

class Cart {
	int id;
	int itemsPrice;
	int itemCount;
	int discount;
	int shipping;
	List<CartObserver> observers = new ArrayList<>();

	public Cart(int id) {
		this.id = id;
	}

	public void attach(CartObserver observer) {
		observers.add(observer);
	}

	public void dettach(CartObserver observer) {
		observers.remove(observer);
	}

	public void addInCart(int price) {
		this.itemsPrice += price;
		itemCount++;
		observers.forEach(o -> o.updated(this));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemsPrice() {
		return itemsPrice;
	}

	public void setItemsPrice(int itemsPrice) {
		this.itemsPrice = itemsPrice + shipping - discount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getShipping() {
		return shipping;
	}

	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", itemsPrice=" + itemsPrice + ", itemCount=" + itemCount + ", discount=" + discount
				+ ", shipping=" + shipping + "]";
	}

}

interface CartObserver {
	void updated(Cart cart);
}

class PriceObserver implements CartObserver {

	@Override
	public void updated(Cart cart) {
		if (cart.getItemsPrice() >= 500) {
			cart.setDiscount(20);
		}else if(cart.getItemsPrice()>=200) {
			cart.setDiscount(10);
		}

	}

}