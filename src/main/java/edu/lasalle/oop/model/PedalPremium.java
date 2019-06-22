package edu.lasalle.oop.model;

import java.util.Objects;

public class PedalPremium extends UrbanBike {
    private double limite;

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PedalPremium{" +
                "urbanBike=" + super.toString() +
                "limite=" + limite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PedalPremium that = (PedalPremium) o;
        return Double.compare(that.limite, limite) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), limite);
    }
}
