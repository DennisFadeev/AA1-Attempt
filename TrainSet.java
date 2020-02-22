package edu.kit.informatik;

public class TrainSet extends RollingStock {
    TrainSet(String series, String name, int length, boolean couplingFront, boolean couplingBack){
        super(length, couplingFront, couplingBack);
        this.series = series;
        this.name = name;
    }
}
