package javalogexpressapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract class Veiculo {
    private String placa;
    private String modelo;
    protected double capacidadeCargaKg;

    public Veiculo(String placa, String modelo, double capacidadeCargaKg) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeCargaKg = capacityValida(capacidadeCargaKg);
    }

    private double capacityValida(double carga) {
        return carga > 0 ? carga : 100; // Validação simples de encapsulamento
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public double getCapacidadeCargaKg() { return capacidadeCargaKg; }

    // Método polimórfico que cada tipo de veículo calculará de sua forma
    public abstract double calcularCustoFrete(double distanciaKm);
    double distanciaKm = 100;
}

// ====================================================================
// TODO: ALUNO DEVE IMPLEMENTAR AS SUBCLASSES (Caminhao e Van) AQUI
// ====================================================================

// 2. CLASSE PRINCIPAL DO SISTEMA
public class JavaLogExpressApp {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Veiculo> frota = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- JAVALOG EXPRESS - SISTEMA DE FROTA ---");
            System.out.println("1. Cadastrar Van no Sistema");
            System.out.println("2. Cadastrar Caminhão no Sistema");
            System.out.println("3. Listar Veículos da Frota e Custos de Frete Simulados");
            System.out.println("0. Encerrar Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer do Enter

            switch (opcao) {
                case 1:
                    System.out.print("Digite a Placa da Van: ");
                    String pVan = leitor.nextLine();
                    System.out.print("Digite o Modelo: ");
                    String mVan = leitor.nextLine();
                    System.out.print("Capacidade de Carga (kg): ");
                    double cVan = leitor.nextDouble();

                    frota.add(new Van(pVan, mVan, cVan));
                    
                    // TODO: Instanciar a Van e adicionar na lista 'frota'
                    System.out.println("Van cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a Placa do Caminhão: ");
                    String pCam = leitor.nextLine();
                    System.out.print("Digite o Modelo: ");
                    String mCam = leitor.nextLine();
                    System.out.print("Capacidade de Carga (kg): ");
                    double cCam = leitor.nextDouble();
                    System.out.print("Número de Eixos do Caminhão: ");
                    int eixos = leitor.nextInt();
                    
                    frota.add(new Caminhao(pCam, mCam, cCam, eixos));
                    // TODO: Instanciar o Caminhão e adicionar na lista 'frota'
                    System.out.println("Caminhão cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- RELATÓRIO DA FROTA E SIMULAÇÃO DE FRETE (Para 100km) ---");
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado na frota.");
                    } else {
                        // TODO: Percorrer a frota exibindo os dados e o cálculo do frete polimórfico
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        leitor.close();
    }
}