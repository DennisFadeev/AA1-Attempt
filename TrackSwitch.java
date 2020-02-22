package edu.kit.informatik;

public class TrackSwitch extends Tracks {
    boolean position;

    TrackSwitch(int trackID, int startX, int startY, int endX, int endY, int endX2, int endY2) {
        super('s', trackID, startX, startY, endX, endY);
        this.endX2 = endX2;
        this.endY2 = endY2;
    }
}
