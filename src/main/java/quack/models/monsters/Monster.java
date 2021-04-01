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

    public void attack() {
        Position attackPosition;
        if (getRotation() == Rotation.RIGHT) {
            attackPosition = getPosition().translateRight();
        } else if(getRotation() == Rotation.UP) {
            attackPosition = getPosition().translateUp();
        } else if(getRotation() == Rotation.LEFT) {
            attackPosition = getPosition().translateLeft();
        } else {
            attackPosition = getPosition().translateDown();
        }
        Player player = GameState.getInstance().getPlayer();
        if (player.getPosition() == attackPosition) {
            player.setCurrHealth(player.getCurrHealth() - attack);
        }
    }
}
