package spybug.state;

import spybug.HeadingType;
import spybug.SpyBug;

public abstract class HeadingState {

    SpyBug spyBug;

    public HeadingState(SpyBug spyBug) {
        this.spyBug = spyBug;
    }

    public abstract void moveLeft();

    public abstract void moveRight();

    public void moveForwardWithLimitations() {
        if(canMoveForwardAccordingToRoom() && canMoveForwardAccordingToOtherDeployedBugs()) {
            moveForward();
            System.out.println(spyBug.getX() + " " + spyBug.getY() + " " + getHeadingType());
        }
    }

    abstract void moveForward();

    abstract boolean canMoveForwardAccordingToRoom();

    abstract boolean canMoveForwardAccordingToOtherDeployedBugs();

    public abstract HeadingType getHeadingType();
}
