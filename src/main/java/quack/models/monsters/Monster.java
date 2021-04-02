package quack.models.monsters;
import quack.models.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster extends GameObject implements Attacker, Attackable {
    private int health;
    private int attack;
    private int speed;
    private Random random = new Random();

    public Monster(int health, int attack, int speed, String sprite) {
        super(sprite, 1000000000 / speed);
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    public void update() {
        randomMove();
        randomAttack();
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

    public void randomAttack() {
        ArrayList<Position> attackPositions = new ArrayList<>();
        attackPositions.add(getPosition().translateRight());
        attackPositions.add(getPosition().translateDown());
        attackPositions.add(getPosition().translateLeft());
        attackPositions.add(getPosition().translateUp());

        Player player = GameState.getInstance().getPlayer();

        for (Position attackPosition : attackPositions) {
            if (player.getPosition().equals(attackPosition)) {
                attack(player);
            }
        }
    }

    public void randomMove() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        Rotation[] rotations = Rotation.values();

        Rotation randomRotation = rotations[random.nextInt(rotations.length)];
        Position nextPostion = null;

        switch (randomRotation) {
            case RIGHT:
                nextPostion = getPosition().translateRight();
                break;
            case DOWN:
                nextPostion = getPosition().translateDown();
                break;
            case LEFT:
                nextPostion = getPosition().translateLeft();
                break;
            case UP:
                nextPostion = getPosition().translateUp();
                break;
        }

        if (currentRoom.isValidPosition(nextPostion)) {
            setPosition(nextPostion);
        }
    }

    @Override
    public void attack(Attackable target) {
        if (target != null) {
            target.damage(getAttack());
        }
    }

    @Override
    public void damage(int damage) {
        setHealth(getHealth() - damage);

        if (getHealth() <= 0) {
            GameState.getInstance().getCurrentRoom().getGameObjects().remove(this);
        }
    }
}
