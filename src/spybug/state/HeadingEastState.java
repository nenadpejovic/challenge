package spybug.state;

import spybug.HeadingType;
import spybug.SpyBug;

public class HeadingEastState extends HeadingState {

    public HeadingEastState(SpyBug spyBug) {
        super(spyBug);
    }

    @Override
    public void moveLeft() {
        spyBug.setCurrentHeading(new HeadingNorthState(spyBug));
    }

    @Override
    public void moveRight() {
        spyBug.setCurrentHeading(new HeadingSouthState(spyBug));
    }

    @Override
    void moveForward() {
        spyBug.setX(spyBug.getX() + 1);
    }

    @Override
    boolean canMoveForwardAccordingToRoom() {
        return spyBug.getX() + 1 <= spyBug.getRoom().getWidth();
    }

    @Override
    boolean canMoveForwardAccordingToOtherDeployedBugs() {
        return spyBug.getDeployedBugs().stream().noneMatch(db -> db.getX().equals(spyBug.getX() + 1)
                && db.getY().equals(spyBug.getY()));
    }

    @Override
    public HeadingType getHeadingType() {
        return HeadingType.E;
    }

}
