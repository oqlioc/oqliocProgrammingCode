package weapon;
import weapon.strategy.*;

public class Bow extends Weapon{
    @Override
    public void attack() {
        System.out.println("활 날렸다.");
    }
}