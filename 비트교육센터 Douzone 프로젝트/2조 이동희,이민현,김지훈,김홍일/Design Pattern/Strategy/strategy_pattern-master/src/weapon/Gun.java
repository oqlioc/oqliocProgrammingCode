package weapon;
import weapon.strategy.*;

public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("총을 쏘다");
    }   
}