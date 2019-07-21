package Game.Heroes;

import java.util.Random;

public class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println(this.name + "погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name + " на " + (this.damage + this.cricitalHit)  +
                    ". Теперь у " + hero.name + " уровень здоровья: " + hero.getHealth());
        }

        if (hero.getHealth() <= 0) System.out.println(hero.name + " погиб смертью храбрых...");
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
