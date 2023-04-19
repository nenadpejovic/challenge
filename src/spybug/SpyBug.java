package spybug;

import spybug.state.*;

import java.util.List;

public class SpyBug {

    private HeadingState currentHeading;
    private Integer x;
    private Integer y;
    private Room room;
    private List<SpyBug> deployedBugs;

    public SpyBug(HeadingType headingType, Integer x, Integer y,
                  Room room, List<SpyBug> deployedBugs) {
        this.setCurrentHeading(createFromHeadingType(headingType));
        this.x = x;
        this.y = y;
        this.room = room;
        this.deployedBugs = deployedBugs;
    }

    public HeadingState getCurrentHeading() {
        return currentHeading;
    }

    public void setCurrentHeading(HeadingState currentHeading) {
        this.currentHeading = currentHeading;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Room getRoom() {
        return room;
    }

    public List<SpyBug> getDeployedBugs() {
        return deployedBugs;
    }

    public void moveForward() {
        currentHeading.moveForwardWithLimitations();
    }

    public void moveLeft() {
        currentHeading.moveLeft();
    }

    public void moveRight() {
        currentHeading.moveRight();
    }

    public HeadingState createFromHeadingType(HeadingType headingType) {
        return switch (headingType) {
            case E -> new HeadingEastState(this);
            case W -> new HeadingWestState(this);
            case N -> new HeadingNorthState(this);
            case S -> new HeadingSouthState(this);
        };
    }
}
