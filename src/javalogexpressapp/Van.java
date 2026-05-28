package javalogexpressapp;

public class Van extends Veiculo {
    public Van(String placa, String modelo, double capacidadeCargaKg) {
        super(placa, modelo, capacidadeCargaKg);
    }

    @Override
    public double calcularCustoFrete(double distanciaKm) {
        if(capacidadeCargaKg > 1000) {
            double custoBase = 30;
            double custoPorKm = 2.50; 
            return custoBase + (custoPorKm * distanciaKm);
        }
        else {
            double custoBase = 0;
            double custoPorKm = 2.50; 
            return custoBase + (custoPorKm * distanciaKm);
        }
    }
    
}
