package edu.lasalle.oop.model;

import edu.lasalle.oop.manager.Imprimivel;
import io.vavr.control.Either;

import java.util.List;
import java.util.Optional;

/**
 * Crie uma classe Ciclistas que possui um arraylist de Pedais e implemente os métodos inserir, remover e procurarPedal.
 * O primeiro e o segundo recebem um objeto Pedal (que pode ser Pop ou Premium) e o insere e remove no arraylist.
 * O terceiro recebe um inteiro como parâmetro representando o número do Pedal e retorna um objeto Conta UrbanBike,
 * caso essa conta exista no arraylist, ou null, caso contrário.
 * */
public class Ciclistas implements Imprimivel {
    private List<UrbanBike> pedais;

    public void inserir(final UrbanBike bike){
        pedais.add(bike);
    }

    public boolean remover(final UrbanBike bike){
       return pedais.remove(bike);
    }

    public boolean remover(final int accountNumber){
        return pedais.removeIf(p -> p.getAccountNumber() == accountNumber);
    }

    public Optional<UrbanBike> procurarPedal(final int number) {
        return pedais.stream().filter(p -> p.getAccountNumber().equals(number)).findFirst();
    }

    public Either<String, Void> pedalar(final UrbanBike conta, double valor){
        if(conta == null)
            return Either.left("Conta não pode ser nula");

        if(conta instanceof PedalPop){
            final PedalPop pop = (PedalPop) conta;

            if((pop.getSaldo() + pop.getTaxaDeOperacao()) < valor){
                return Either.left("Você não tem saldo suficiente");
            } else {
                pop.pedalar(valor);
            }
        } else {
            final PedalPremium premium = (PedalPremium) conta;

            if(premium.getSaldo() < -premium.getLimite()){
                return Either.left("Você não tem saldo suficiente");
            }

            premium.pedalar(valor);
        }

        return Either.right(null);
    }

    @Override
    public String toString() {
        return "Ciclistas{" +
                "pedais=" + pedais +
                '}';
    }
}
