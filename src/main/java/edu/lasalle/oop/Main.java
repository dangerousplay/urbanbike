package edu.lasalle.oop;

import edu.lasalle.oop.manager.Relatorio;
import edu.lasalle.oop.model.Ciclistas;
import edu.lasalle.oop.model.UrbanBike;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Ciclistas ciclistas = new Ciclistas();

        System.out.println("Olá, seja bem-vindo");

        while (true) {

            showMainMenu();

            final int opcao = SCANNER.nextInt();

            switch (opcao) {
                case 1:
                    ciclistas.inserir(createAccount());
                    break;
                case 2:
                    int accountNumber = getAccountNumber();

                    if (ciclistas.remover(accountNumber)) {
                        System.out.println("Pedal removido com sucesso!");
                        System.out.println();
                    } else {
                        System.out.printf("Pedal não encontrado com o número: %s\n", accountNumber);
                    }
                    break;
                case 3:
                    System.out.println("Gerando relatório: ");
                    new Relatorio(ciclistas).gerarRelatorio();
                    System.out.println("....");
                    break;
                case 4:
                    System.out.println("Digite o número da conta: ");
                    final Optional<UrbanBike> conta = ciclistas.procurarPedal(SCANNER.nextInt());

                    if(!conta.isPresent()){
                        System.out.println("Conta não encontrada...");
                        continue;
                    }
                    showAccountMenu(conta.get());
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inexistente...");
                    break;
            }
        }


    }

    private static void showMainMenu() {
        System.out.println("Escolha uma opção: ");
        System.out.println();
        System.out.println(
                "1. Criar pedal\n" +
                        "2. Remover Pedal: o usuário informa o número do Pedal. Se existe, então é excluído e uma mensagem de sucesso é informada. Senão, informar mensagem de Pedal inexistente.\n" +
                        "3. Gerar relatório: mostra os dados de todos os Pedals cadastrados no Ciclistas.\n" +
                        "4. Selecionar Pedal: o usuário informa o número do pedal. Se existir, mostra o menu abaixo (A até E). Caso contrário, mostra mensagem de Pedal inexistente.\n" +
                        "5. Finalizar: terminar a aplicação.\n"
        );
    }

    private static void showAccountMenu(final UrbanBike account) {
        System.out.println("Escolha uma opção: ");

        System.out.println("1. Creditar: recebe um valor e deposita na carteira.\n" +
                "2. Pedalar: recebe um valor e tenta usar.\n" +
                "3. Transferir: recebe um valor e o número de outro Pedal. Caso exista, transfere o valor de um Pedal para o outra. Senão, informar mensagem de Pedal inexistente.\n" +
                "4. Gerar relatório: mostra os dados do Pedal selecionado.\n" +
                "5. Retornar ao menu anterior: exibe o menu anterior (opções 1 a 2).");

        final int opcao = SCANNER.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Digite o valor a ser depositado: ");
                final double valor = SCANNER.nextDouble();
                account.creditar(valor);
                break;
            case 2:
                System.out.println("Digite a quantidade a pedalar: ");
                final double distance = SCANNER.nextDouble();
                account.pedalar(distance);
                break;
            case 3:
                break;
            case 4:

                break;
            case 5:
                break;
            default:
                System.out.printf("Opção inválida: %s\n", opcao);
                break;
        }
    }

    private static UrbanBike createAccount() {
        System.out.println("Digite o número da conta: ");
        final int accountNumber = SCANNER.nextInt();


    }

    private static int getAccountNumber() {
        System.out.println("Digite o número da conta: ");
        return SCANNER.nextInt();
    }

}
