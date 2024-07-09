package dados;

public class Competidor {
    private String nome;
    private int aposta;

    public Competidor(String nome) {
        this.nome = nome;
        this.aposta = -1; // Valor inicial inválido para aposta
    }

    public String getNome() {
        return nome;
    }

    public int getAposta() {
        return aposta;
    }

    public void fazerAposta(int valor) {
        this.aposta = valor;
    }
}


