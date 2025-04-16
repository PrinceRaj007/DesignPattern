package BehavioralDesignPattern.Strategy;

public class StrategyClient {

	public static void main(String[] args) {
		ShoppingCart shoppingCart1 = new ShoppingCart(new CrediCardPayment());
		shoppingCart1.checkOut();
		ShoppingCart shoppingCart2 = new ShoppingCart(new PayPalPayment());
		shoppingCart2.checkOut();
	}

}
interface PaymentStrategy{
	public void pay();
}
class CrediCardPayment implements PaymentStrategy{

	@Override
	public void pay() {
		System.out.println("Payment is being Processed using CREDIT CARD PAYMENT GATEWAY");
		System.out.println("Payment Completed Using CREDIT CARD");
	}
}
class PayPalPayment implements PaymentStrategy{
	
	@Override
	public void pay() {
		System.out.println("Payment is being Processed using PAY PAL PAYMENT GATEWAY");
		System.out.println("Payment Completed Using PAY PAL");
	}
}
class ShoppingCart{
	PaymentStrategy paymentStrategy;
	public ShoppingCart(PaymentStrategy paymentStrategy) {
		this.paymentStrategy =  paymentStrategy;
	}
	public void checkOut() {
		paymentStrategy.pay();
	}
}

