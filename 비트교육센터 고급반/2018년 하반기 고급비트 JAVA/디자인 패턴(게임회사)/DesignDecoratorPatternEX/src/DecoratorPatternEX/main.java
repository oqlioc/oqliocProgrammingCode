package DecoratorPatternEX;

abstract class Coffee {
	String name = "None";

	public String getName() {
		return name;
	}

	public abstract Double getCost();
}

class Espresso extends Coffee {

	public Espresso() {
		name = "Espresso";
	}

	@Override
	public Double getCost() {

		return 0.99;
	}

}

class DarkRoast extends Coffee {
	public DarkRoast() {
		name = "DaekRoast";
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 1.09;
	}
}

abstract class Ingredient extends Coffee {
	@Override
	public abstract String getName();
}

class Mocha extends Ingredient {
	Coffee myCoffee;

	public Mocha(Coffee myCoffee) {
		this.myCoffee = myCoffee;
	}

	@Override
	public Double getCost() {
		return myCoffee.getCost() + 0.5;
	}

	@Override
	public String getName() {
		return myCoffee.getName() + "모카 추가";
	}
}

class Whip extends Ingredient {
	Coffee myCoffee;

	public Whip(Coffee myCoffee) {
		this.myCoffee = myCoffee;
	}

	@Override
	public String getName() {
		return myCoffee.getName() + "휘핑 추가";
	}

	@Override
	public Double getCost() {
		return myCoffee.getCost() + 0.2;
	}

}

public class main {

	public static void main(String[] args) {
		Coffee espresso = new Whip(new Espresso());
		Coffee darkrpast = new Mocha(new DarkRoast());

		System.out.println(espresso.getName() + " " + espresso.getCost());
		System.out.println(darkrpast.getName() + " " + darkrpast.getCost());
	}
}
