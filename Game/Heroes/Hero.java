package Game.Heroes;

public abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    protected boolean isAlive = true;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    public abstract void hit(Hero hero);

    public abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            isAlive = false;
            System.out.println(this.name + " уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    public void info() {
        System.out.println(name + " " + (health <= 0 ?  "Герой мертвый" : health) + " " + damage);
    }
}