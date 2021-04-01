package quack.models.monsters;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Player;
import quack.models.Position;

public abstract class Monster extends GameObject {
    private int health;
    private int attack;
    private int speed;

    public Monster(int health, int attack, int speed, String sprite) {
        super(sprite, 1000);
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    public void update() {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
