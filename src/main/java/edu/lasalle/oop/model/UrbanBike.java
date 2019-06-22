package edu.lasalle.oop.model;

import edu.lasalle.oop.manager.Imprimivel;
import io.vavr.control.Try;

import java.util.Objects;

public abstract class UrbanBike implements Imprimivel {
    private Integer accountNumber;
    private double saldo;

    public void debitar(final double valor){
        this.saldo -= valor;
    }

    public void pedalar(final double valor) {
        this.debitar(valor);
    }

    public void creditar(final double valor) {
        this.saldo += valor;
    }

    public Try<Void> transferir(final UrbanBike urbanBike, final double valor){
        Objects.requireNonNull(urbanBike);

        if(this.saldo < valor){
            return Try.failure(new IllegalArgumentException("Not enought money to transfer"));
        }

        this.debitar(valor);
        urbanBike.creditar(valor);

        return Try.success(null);
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "UrbanBike{" +
                "accountNumber='" + accountNumber + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrbanBike urbanBike = (UrbanBike) o;
        return Double.compare(urbanBike.saldo, saldo) == 0 &&
                accountNumber.equals(urbanBike.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, saldo);
    }
}
