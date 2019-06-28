package edu.lasalle.oop.manager;

public interface Imprimivel {

    default void mostrarDados() {
        System.out.println(this.toString());
    }

}
