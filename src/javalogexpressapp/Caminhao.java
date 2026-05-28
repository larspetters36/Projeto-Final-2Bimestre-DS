package javalogexpressapp;

public class Caminhao extends Veiculo {
    private int eixos;

    public Caminhao(String placa, String modelo, double capacidadeCargaKg, int eixos) {
        super(placa, modelo, capacidadeCargaKg);
        this.eixos = eixos;
    }

    @Override
    public double calcularCustoFrete(double distanciaKm) {
        double custoBase = 0;
        double custoPorKm = 4.50; 
        return custoBase + (custoPorKm * distanciaKm * eixos);
    }
    
}
