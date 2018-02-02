import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cart{
	Map<String, List<Integer>> cartItems;
	public cart(){ 
		cartItems = new HashMap<String, List<Integer>>();
	}
	public Map getCartItems(){
		return cartItems;
	}	
	public void addToCart(String itemID, int price, int quantity){
		List<Integer> val = new ArrayList<Integer>();
		//adds more to cart if it already contains the item
		if (cartItems.containsKey(itemID)) {
			val.add(price);
	        val.add(quantity+cartItems.get(itemID).get(1));
			cartItems.put(itemID, val);
		}
		else {
	        val.add(price);
	        val.add(quantity);
			cartItems.put(itemID, val);
		}
	}
	public void deleteFromCart(String itemID){
			cartItems.remove(itemID);

    }
	public int total() {
		int total =0;
		for(String key: cartItems.keySet()){
			//multiplies the price and the quantity
			total = total + (cartItems.get(key).get(0) * cartItems.get(key).get(1)) ;
			}
			return total;
	}
}
