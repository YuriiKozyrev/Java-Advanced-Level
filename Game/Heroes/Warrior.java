package Game.Heroes;

public class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println(this.name + " погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name + " на " + this.damage +
                    ". Теперь у " + hero.name + " уровень здоровья: " + hero.getHealth());
        }

        if (hero.getHealth() <= 0) System.out.println(hero.name + " погиб смертью храбрых...");
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}
