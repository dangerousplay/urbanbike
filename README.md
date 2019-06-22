1. Crie uma classe abstrata Conta UrbanBike que contém como atributos o número da conta, a carteira (saldo), e como métodos abstratos pedalar (gastar os créditos) e creditar (carregar créditos na carteira) que recebem um parâmetro do tipo double.

2. Crie as classes Pedal Pop e Pedal Premium que herdam da Conta UrbanBike. 
A primeira possui um atributo taxaDeOperacao que é descontado sempre que ciclista pedalar ou creditar. 
A segunda possui um atributo limite que dá crédito a mais para o usuário caso ele precise pedalar mais do que tem na carteira. 
Neste caso, a carteira pode ficar com valor negativo desde que não ultrapasse o limite. 
Isso não pode acontecer na classe Pedal Pop. 
Para ser Pedal Premium é obrigatório creditar um mínimo de R$100,00 na carteira na criação.

3. Crie uma interface Imprimível que declara um método mostrarDados.

4. Faça as classes Pedal Pop e Pedal Premium implementarem a interface e mostrar os atributos.

5. Crie uma classe Relatório que possui um método gerarRelatorio que gera o relatório de tudo.

6. Incremente a classe Conta UrbanBike com o método transferir que recebe o parâmetro o valor (double) e um objeto Conta UrbanBike e transfere o valor desejado do Pedal atual para o Pedal informado. Use os métodos pedalar e creditar para isso.

7. Crie uma classe Ciclistas que possui um arraylist de Pedais e implemente os métodos inserir, remover e procurarPedal. O primeiro e o segundo recebem um objeto Pedal (que pode ser Pop ou Premium) e o insere e remove no arraylist. O terceiro recebe um inteiro como parâmetro representando o número do Pedal e retorna um objeto Conta UrbanBike, caso essa conta exista no arraylist, ou null, caso contrário.

8. Faça a classe Ciclistas utilizar/acordar a interface imprimível, onde a implementação de método consiste em executar método mostrarDados de cada Pedal.

9. Crie outra classe executável que instancie Ciclistas e ofereça o seguinte menu para o usuário:

MENU APLICAÇÃO:
I. Criar pedal: o usuário informa se é pop ou premium (deve depositar valor inicial) e os dados do pedal. O objeto correspondente é criado e inserido no Ciclistas através do método inserir. Exibir uma mensagem de sucesso.
II. Remover Pedal: o usuário informa o número do Pedal. Se existe, então é excluído e uma mensagem de sucesso é informada. Senão, informar mensagem de Pedal inexistente.
III. Gerar relatório: mostra os dados de todos os Pedals cadastrados no Ciclistas.
IV. Selecionar Pedal: o usuário informa o número do pedal. Se existir, mostra o menu abaixo (A até E). Caso contrário, mostra mensagem de Pedal inexistente.
V. Finalizar: terminar a aplicação.

MENU OPÇÃO IV:
A. Creditar: recebe um valor e deposita na carteira.
B. Pedalar: recebe um valor e tenta usar.
C. Transferir: recebe um valor e o número de outro Pedal. Caso exista, transfere o valor de um Pedal para o outra. Senão, informar mensagem de Pedal inexistente.
D. Gerar relatório: mostra os dados do Pedal selecionado.
E. Retornar ao menu anterior: exibe o menu anterior (opções I a V).