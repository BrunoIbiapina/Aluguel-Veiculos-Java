public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private boolean alugado;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.alugado = false;
    }

    public void alugar() {
        if (this.alugado) {
            System.out.println("O veículo está alugado.");
        } else {
            this.alugado = true;
            System.out.println("Vaículo alugado.");
        }
    }

    public void devolver() {
        if (!this.alugado) {
            System.out.println("O veículo não está alugado");
        } else {
            this.alugado = false;
            System.out.println("O veículo foi devolvido");
        }
    }

    public boolean isAlugado() {
        return alugado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public abstract double calcularValorAluguel(int dias);
}
