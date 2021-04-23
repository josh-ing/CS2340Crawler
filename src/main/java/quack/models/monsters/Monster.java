package quack.models.monsters;
import quack.models.*;
import quack.models.items.*;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.LongSwordWeapon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster extends GameObject implements Attacker, Attackable {
    private int health;
    private int attack;
    private int speed;
    private Random random = new Random();
    private DroppedItem loot;

    public Monster(int health, int attack, int speed, String sprite) {
        super(sprite, 1000000000 / speed);
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        ItemTypes[] types = ItemTypes.values();
        ItemTypes randomType = types[random.nextInt(types.length)];

        switch (randomType) {
        case SUPER_POTION:
            loot = new DroppedItem(new SuperPotion());
            break;
        case ATTACK_POTION:
            loot = new DroppedItem(new AttackPotion());
            break;
        case HEALTH_POTION:
            loot = new DroppedItem(new HealthPotion());
            break;
        case KNIFE:
            loot = new DroppedItem(new KnifeWeapon());
            break;
        case SWORD:
            loot = new DroppedItem(new LongSwordWeapon());
            break;
        default:
            loot = new DroppedItem(new KatanaWeapon());
        }
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
        Position nextPosition = null;

        switch (randomRotation) {
        case RIGHT:
            nextPosition = getPosition().translateRight();
            break;
        case DOWN:
            nextPosition = getPosition().translateDown();
            break;
        case LEFT:
            nextPosition = getPosition().translateLeft();
            break;
        case UP:
            nextPosition = getPosition().translateUp();
            break;
        default:
            break;
        }

        if (currentRoom.isValidPosition(nextPosition)) {
            setPosition(nextPosition);
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
            int rand = random.nextInt(2);
            if (rand == 1) {
                GameState.getInstance().getCurrentRoom().getGameObjects().add(loot);
                loot.setPosition(this.getPosition());
            }
        }
    }
}
