package my.edu.utar;

class salesObject{
	
	public int getPromoItems(){		

		int quantity=0;
		
		// randomly select promotion items and return the quantity
		
		return quantity;
	}
	
	public void updatePrice(int discount){
		// update the new price based on discount rate
	}
}

public class MyOwnBiz {
	
	salesObject so;
	
	public MyOwnBiz(salesObject so){
		this.so=so;
	}
	
	public void doPromotion(){
		int quantity;
		int discount;
		
		quantity = so.getPromoItems();
		
		if(quantity < 5000)
			discount =10;
		else
			discount = 5;
		so.updatePrice(discount);
	}
}
