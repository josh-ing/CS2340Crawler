package quack.models.monsters;
//import breath first

import quack.models.GameState;
import quack.models.Position;
import quack.models.Room;

public class Boss extends Monster {
    public Boss() { super(200, 20, 2, "src/main/resources/assets/monsters/boss.gif" ); }

    @Override
    public void update() {
        movement();
        super.randomAttack();
    }

    public void movement() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        Rotation[] rotations = Rotation.values();
        Rotation nextMove = null;
        Position nextPosition = null;
        int upDistance = 0;
        int downDistance = 0;
        int leftDistance = 0;
        int rightDistance = 0;
        Position currentPos = this.getPosition();
        Position playerPos = GameState.getInstance().getPlayer().getPosition();
        if (currentRoom.isValidPosition(currentPos.translateUp())) {
            Position adjacentUp = currentPos.translateUp();
            upDistance = (adjacentUp.getRow() - playerPos.getRow()) + (adjacentUp.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateDown())) {
            Position adjacentDown = currentPos.translateDown();
            downDistance = (adjacentDown.getRow() - playerPos.getRow()) + (adjacentDown.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateLeft())) {
            Position adjacentLeft = currentPos.translateLeft();
            leftDistance = (adjacentLeft.getRow() - playerPos.getRow()) + (adjacentLeft.getCol() - playerPos.getCol());
        }
        if (currentRoom.isValidPosition(currentPos.translateRight())) {
            Position adjacentRight = currentPos.translateDown();
            rightDistance = (adjacentRight.getRow() - playerPos.getRow()) + (adjacentRight.getCol() - playerPos.getCol());
        }

        int[] adjacentArray = new int[]{upDistance, downDistance, leftDistance, rightDistance};
        int small = Integer.MAX_VALUE;
        int smallestIndex = 0;
        for (int i = 0; i < adjacentArray.length; i++) {
            if (adjacentArray[i] < small) {
                small = adjacentArray[i];
                smallestIndex = i;
            }
            if (smallestIndex == 1) {
                //up
                nextMove = rotations[1];
            } else if (smallestIndex == 3) {
                //down
                nextMove = rotations[3];
            } else if (smallestIndex == 2) {
                //left
                nextMove = rotations[2];
            } else if (smallestIndex == 0) {
                //right
                nextMove = rotations[0];
            }
        }
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
}
