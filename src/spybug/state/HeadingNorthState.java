package spybug.state;

import spybug.HeadingType;
import spybug.SpyBug;

public class HeadingNorthState extends HeadingState {

    public HeadingNorthState(SpyBug spyBug) {
        super(spyBug);
    }

    @Override
    public void moveLeft() {
        spyBug.setCurrentHeading(new HeadingWestState(spyBug));
    }

    @Override
    public void moveRight() {
        spyBug.setCurrentHeading(new HeadingEastState(spyBug));
    }

    @Override
    void moveForward() {
        spyBug.setY(spyBug.getY() + 1);
    }

    @Override
    boolean canMoveForwardAccordingToRoom() {
        return spyBug.getY() + 1 <= spyBug.getRoom().getHeight();
    }

    @Override
    boolean canMoveForwardAccordingToOtherDeployedBugs() {
        return spyBug.getDeployedBugs().stream().noneMatch(db -> db.getX().equals(spyBug.getX())
                && db.getY().equals(spyBug.getY() + 1));
    }

    @Override
    public HeadingType getHeadingType() {
        return HeadingType.N;
    }
}
