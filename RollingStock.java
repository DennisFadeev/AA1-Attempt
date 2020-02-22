package edu.kit.informatik;

public class RollingStock {
    Locomotive locomotive;
    Coach coach;
    String series;
    String name;
    int length;
    boolean couplingFront;
    boolean couplingBack;
    boolean available;
    
    RollingStock(int length, boolean couplingFront, boolean couplingBack){
        this.length = length;
        this.couplingFront = couplingFront;
        this.couplingBack = couplingBack;
    }
}
