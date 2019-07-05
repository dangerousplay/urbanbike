package edu.lasalle.oop.manager;

import edu.lasalle.oop.model.Ciclistas;

public class Relatorio {
    private Ciclistas ciclistas;

    public Relatorio(Ciclistas ciclistas) {
        this.ciclistas = ciclistas;
    }

    public void gerarRelatorio(){
        ciclistas.mostrarDados();
    }
}
