package weapon;
import weapon.strategy.*;

public class Knife extends Weapon{
    @Override
    public void attack() {
        System.out.println("칼로 베다");
    }
}