
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Veiculo[] veiculos = new Veiculo[3];
        veiculos[0] = new Carros("Toyota", "Corolla", 2024, 4);
        veiculos[1] = new Moto("Suzuki", "Titan", 2024, 200);
        veiculos[2] = new Caminhao("Volto", "Bi Trem", 2023, 1000);

        while (true) {
            System.out.println("1. Alugar Veículos.");
            System.out.println("2. Devolver Veículos.");
            System.out.println("3. Calcular Valor Aluguel.");
            System.out.println("4. Mostrar veículos alugados e descricão.");
            System.out.println("5. Sair do sistema.");
            System.out.println("Escolha uma opcão: ");
            int opcao = sc.nextInt();

            if (opcao == 5) {
                System.out.println("Saindo do sistema.");
                break;
            }

            if (opcao == 1) {
                // Mostra apenas o tipo de veículo para alugar
                System.out.println("\nSelecione o tipo de veículo para alugar:");
                for (int i = 0; i < veiculos.length; i++) {
                    String tipoVeiculo = veiculos[i] instanceof Carros ? "Carro"
                            : veiculos[i] instanceof Moto ? "Moto" : "Caminhão";
                    System.out.println((i + 1) + " - " + tipoVeiculo);
                }

                int escolhaVeiculo = sc.nextInt() - 1;
                if (escolhaVeiculo < 0 || escolhaVeiculo >= veiculos.length) {
                    System.out.println("Inválido");
                    continue;
                }
                Veiculo veiculoEscolhido = veiculos[escolhaVeiculo];
                if (!veiculoEscolhido.isAlugado()) {
                    veiculoEscolhido.alugar();
                    System.out.println("Informe a quantidade de dias para o aluguel:");
                    int dias = sc.nextInt();
                    double valor = veiculoEscolhido.calcularValorAluguel(dias);
                    System.out.printf("O valor total do aluguel é: R$ %.2f%n", valor);
                } else {
                    System.out.println("O veículo já está alugado.");
                }
            } else if (opcao == 2) {
                // Mostra apenas o tipo de veículo para devolver
                System.out.println("\nSelecione o tipo de veículo para devolver:");
                for (int i = 0; i < veiculos.length; i++) {
                    String tipoVeiculo = veiculos[i] instanceof Carros ? "Carro"
                            : veiculos[i] instanceof Moto ? "Moto" : "Caminhão";
                    System.out.println((i + 1) + " - " + tipoVeiculo);
                }

                int escolhaVeiculo = sc.nextInt() - 1;
                if (escolhaVeiculo < 0 || escolhaVeiculo >= veiculos.length) {
                    System.out.println("Escolha inválida");
                    continue;
                }
                Veiculo veiculoEscolhido = veiculos[escolhaVeiculo];

                if (veiculoEscolhido.isAlugado()) {
                    veiculoEscolhido.devolver();
                    System.out.println("O veículo foi devolvido com sucesso.");
                } else {
                    System.out.println("O veículo não está alugado.");
                }
            } else if (opcao == 3) {
                // Calcula o valor do aluguel de um veículo específico
                System.out.println("\nSelecione o veículo para calcular o valor do aluguel:");
                for (int i = 0; i < veiculos.length; i++) {
                    System.out.println((i + 1) + " - " + veiculos[i].getMarca() + " " + veiculos[i].getModelo());
                }

                int escolhaVeiculo = sc.nextInt() - 1;
                if (escolhaVeiculo < 0 || escolhaVeiculo >= veiculos.length) {
                    System.out.println("Escolha inválida");
                    continue;
                }

                Veiculo veiculoEscolhido = veiculos[escolhaVeiculo];
                if (veiculoEscolhido.isAlugado()) {
                    System.out.println("Informe a quantidade de dias para calcular o valor:");
                    int dias = sc.nextInt();
                    double valor = veiculoEscolhido.calcularValorAluguel(dias);
                    System.out.printf("O valor total do aluguel é: R$ %.2f%n", valor);
                } else {
                    System.out.println("O veículo não está alugado.");
                }
            } else if (opcao == 4) {
                int[] diasAlugados = new int[veiculos.length];
                // Exibe os veículos que estão alugados e os detalhes do aluguel
                System.out.println("\nVeículos Alugados e Descrição:");
                boolean algumVeiculoAlugado = false;
                for (int i = 0; i < veiculos.length; i++) {
                    if (veiculos[i].isAlugado()) {
                        veiculos[i].alugar();
                        System.out.println("Informe a quantidade de dias que o veículo " + veiculos[i].getMarca() + " "
                                + veiculos[i].getModelo() + " foi alugado:");
                        diasAlugados[i] = sc.nextInt();

                        double valorAluguel = veiculos[i].calcularValorAluguel(diasAlugados[i]);
                        System.out.println("Veículo: " + veiculos[i].getMarca() + " " + veiculos[i].getModelo());
                        System.out.println("Dias alugados: " + diasAlugados[i]);
                        System.out.printf("Valor do aluguel: R$ %.2f%n", valorAluguel);
                        System.out.println("-------------------------------");
                        algumVeiculoAlugado = true;
                    }
                }
                if (!algumVeiculoAlugado) {
                    System.out.println("Nenhum veículo está alugado no momento.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();

    }
}
