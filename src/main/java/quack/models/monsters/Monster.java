package quack.models.monsters;
import quack.models.GameObject;

public abstract class Monster extends GameObject {
    private int health;
    private int attack;
    private int speed;

    public Monster(int health, int attack, int speed) {
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    public void update() {

    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }
}
