package edu.lasalle.oop.model;

import io.vavr.control.Try;

import java.util.Objects;

public class PedalPop extends UrbanBike {
    private double taxaDeOperacao;

    public PedalPop(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public void pedalar(double valor) {
        super.pedalar(valor);

        this.debitar(taxaDeOperacao);
    }

    @Override
    public void creditar(double valor) {
        super.creditar(valor);

        this.debitar(taxaDeOperacao);
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public String toString() {
        return "PedalPop{" +
                "urbanBike=" + super.toString() +
                "taxaDeOperacao=" + taxaDeOperacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PedalPop pedalPop = (PedalPop) o;
        return Double.compare(pedalPop.taxaDeOperacao, taxaDeOperacao) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taxaDeOperacao);
    }
}
