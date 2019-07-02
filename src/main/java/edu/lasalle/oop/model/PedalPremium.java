package edu.lasalle.oop.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A segunda possui um atributo limite que dá crédito a mais para o usuário caso ele precise pedalar mais do que tem na carteira.
 * Neste caso, a carteira pode ficar com valor negativo desde que não ultrapasse o limite.
 * */
public class PedalPremium extends UrbanBike {
    private double limite;

    public PedalPremium(double limite) {

        this.limite = limite;
    }

    public double getLimite() {
        return limite;
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
