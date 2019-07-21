package Game.Heroes;

public class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        System.out.println("Доктор не может бить!");

        if (hero.getHealth() <= 0) System.out.println(hero.name + " погиб смертью храбрых...");
    }

    @Override
    public void healing(Hero hero) {
        if (hero.health > 0) {
            hero.addHealth(addHeal);
            System.out.println(this.name + " вылечил " + hero.name + " на " + addHeal +
                    ". Теперь у " + hero.name + " уровень здоровья: " + hero.getHealth());
        } else {
            System.out.println(hero.name + " умер и уже не вылечится.");
        }
    }
}
