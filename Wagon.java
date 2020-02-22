package edu.kit.informatik;

public class Wagon extends RollingStock {
    Wagon(Coach coach, Integer length, boolean couplingFront, boolean couplingBack) {
        super(length, couplingFront, couplingBack);
        this.coach = coach;
    }
}
