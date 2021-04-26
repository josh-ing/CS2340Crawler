package quack.models.monsters;

import quack.models.*;
import quack.models.Effects.Flame;

import java.util.ArrayList;

public class Boss extends Monster {
    //particle effects for attack
    private Flame fire = new Flame();
    ArrayList<Position> attackPositions;


    public Boss() {
        super(200, 20, 2, "src/main/resources/assets/monsters/boss.gif" );
        this.attackPositions = new ArrayList<>();
    }

    @Override
    public void update() {
        movement();
        bossAttack();
    }

    public void bossAttack() {
        //boss has slightly bigger attack radius
        //each side has a hitbox 2 blocks wide
        //right
        attackPositions.add(getPosition().translateRight());
        attackPositions.add(getPosition().translateRight().translateRight());
        //down
        attackPositions.add(getPosition().translateDown());
        attackPositions.add(getPosition().translateDown().translateDown());
        //left
        attackPositions.add(getPosition().translateLeft());
        attackPositions.add(getPosition().translateLeft().translateLeft());
        //up
        attackPositions.add(getPosition().translateUp());
        attackPositions.add(getPosition().translateUp().translateUp());

        Player player = GameState.getInstance().getPlayer();

        for (Position attackPosition : attackPositions) {
            if (player.getPosition().equals(attackPosition)) {
                GameState.getInstance().getEffectObjects().add(fire);
                fire.setPosition(attackPosition);
                fire.setRotation(this.getRotation());
                attack(player);
            }
        }
    }

    public void movement() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        Rotation[] rotations = Rotation.values();
        Rotation nextMove = getAdjacent(currentRoom, rotations);
        Position nextPosition = null;

        switch (nextMove) {
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

    private Rotation getAdjacent(Room currentRoom, Rotation[] rotations) {
        int upDistance = 0;
        int downDistance = 0;
        int leftDistance = 0;
        int rightDistance = 0;
        Position currentPos = getPosition();
        Player player = GameState.getInstance().getPlayer();
        Position playerPos = player.getPosition();
        if (currentRoom.isValidPosition(currentPos.translateUp())) {
            Position adjacentUp = currentPos.translateUp();
            upDistance = Math.abs(adjacentUp.getRow() - playerPos.getRow()) + Math.abs(adjacentUp.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateDown())) {
            Position adjacentDown = currentPos.translateDown();
            downDistance = Math.abs(adjacentDown.getRow() - playerPos.getRow()) + Math.abs(adjacentDown.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateLeft())) {
            Position adjacentLeft = currentPos.translateLeft();
            leftDistance = Math.abs(adjacentLeft.getRow() - playerPos.getRow()) + Math.abs(adjacentLeft.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateRight())) {
            Position adjacentRight = currentPos.translateRight();
            rightDistance = Math.abs(adjacentRight.getRow() - playerPos.getRow()) + Math.abs(adjacentRight.getCol() - playerPos.getCol());
        }
        return this.getSmallest(upDistance, downDistance, leftDistance, rightDistance, rotations);
    }

    private Rotation getSmallest(int up, int down, int left, int right, Rotation[] rotations) {
        int[] adjacentArray = new int[]{up, down, left, right};
        int smallestIndex = 0;
        for (int i = 0; i < adjacentArray.length; i++) {
            for (int j = i + 1; j < adjacentArray.length; j++) {
                if (adjacentArray[i] > adjacentArray[j]) {
                    smallestIndex = j;
                } else {
                    smallestIndex = i;
                }
            }
        }
        int direction = -1;
        if (smallestIndex == 1) {
            direction = 3;
        } else if (smallestIndex == 2) {
            direction = 2;
        } else if (smallestIndex == 3) {
            direction = 0;
        } else if (smallestIndex == 0) {
            direction = 1;
        }
        return rotations[direction];
    }


}
