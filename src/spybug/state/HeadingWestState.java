package spybug.state;

import spybug.HeadingType;
import spybug.SpyBug;

public class HeadingWestState extends HeadingState {

    public HeadingWestState(SpyBug spyBug) {
        super(spyBug);
    }

    @Override
    public void moveLeft() {
        spyBug.setCurrentHeading(new HeadingSouthState(spyBug));
    }

    @Override
    public void moveRight() {
        spyBug.setCurrentHeading(new HeadingNorthState(spyBug));
    }

    @Override
    void moveForward() {
        spyBug.setX(spyBug.getX() - 1);
    }

    @Override
    boolean canMoveForwardAccordingToRoom() {
        return spyBug.getX() - 1 >= 0;
    }

    @Override
    boolean canMoveForwardAccordingToOtherDeployedBugs() {
        return spyBug.getDeployedBugs().stream().noneMatch(db -> db.getX().equals(spyBug.getX() - 1)
                && db.getY().equals(spyBug.getY()));
    }

    @Override
    public HeadingType getHeadingType() {
        return HeadingType.W;
    }

}
