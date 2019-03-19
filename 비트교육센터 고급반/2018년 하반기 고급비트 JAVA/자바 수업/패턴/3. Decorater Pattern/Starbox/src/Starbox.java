 abstract class Coffee {
	String name = "None";
	public  String getName() {
		return name;
	};
	public abstract Double getCost();
	
}
class Espresso extends Coffee{
	
	public Espresso() {
		name = "Espresso";
	}

	@Override
	public Double getCost() {
		return 1.99;
	}
}

class DarkRoast extends Coffee{

	public DarkRoast() {
		name = "Dark Roast";
	}
	
	@Override
	public Double getCost() {
		return 2.09;
	}
}

abstract class ingredient extends Coffee{
	
	@Override
	public abstract String getName();
	
}
class Whip extends ingredient{
	Coffee mycoffee;
	
	public Whip(Coffee mycoffee) {
		this.mycoffee = mycoffee;
	}

	@Override
	public String getName() {
		return mycoffee.getName() + " add Whip";
	}
	
	@Override
	public Double getCost() {
		return mycoffee.getCost() + 0.2;
	}
}
class Mocha extends ingredient {
	Coffee mycoffee;
	public Mocha(Coffee mycoffee) {
		this.mycoffee = mycoffee;
	}
	@Override
	public String getName() {
		return mycoffee.getName() + "add Mocha";
	}

	@Override
	public Double getCost() {
		return mycoffee.getCost() + 0.5;
	}
	
}
public class Starbox {
	public static void main(String[] args) {
		
		Coffee es = new Espresso();
		Coffee dr = new Mocha(new Whip(new Whip(new DarkRoast())));
		/*
		Coffee drr = new DarkRoast();
		drr = new Whip(drr);
		drr = new Whip(drr);
		drr = new Mocha(drr);
		*/
		System.out.println(es.getName() + " $"+es.getCost());
		System.out.println(dr.getName() + " $"+dr.getCost());
		
	}
}
