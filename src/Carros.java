public class Carros extends Veiculo {

    private double capacidadeCarga;

    public Carros(String marca, String modelo, int ano, int capacidadeCarga) {
        super(marca, modelo, ano);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularValorAluguel(int dias) {
        return (200 * dias) + (50 * capacidadeCarga);
    }

}
