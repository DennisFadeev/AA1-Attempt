package edu.kit.informatik;

public class Engine extends TrainSet {
    Engine(Locomotive loc, String series, String name, int length, boolean couplingFront, boolean couplingBack) {
        super(series, name, length, couplingFront, couplingBack);
        this.locomotive = loc;
    }
}
