package dados;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class JogoDados {
    private List<Competidor> jogadores;
    private Set<Integer> valoresEscolhidos;
    private Random random;
    private static final int NUMERO_MAXIMO_JOGADORES = 11;

    public JogoDados() {
        this.jogadores = new ArrayList<>();
        this.valoresEscolhidos = new HashSet<>();
        this.random = new Random();
    }

    public void adicionarJogador(String nome) {
        if (jogadores.size() < NUMERO_MAXIMO_JOGADORES) {
            jogadores.add(new Competidor(nome));
        } else {
            System.out.println("Número máximo de jogadores atingido!");
        }
    }

    public boolean escolherValorAposta(int jogadorIndex, int valor) {
        if (valor < 2 || valor > 12) {
            System.out.println("Valor de aposta inválido! Escolha um valor entre 2 e 12.");
            return false;
        }
        if (valoresEscolhidos.contains(valor)) {
            System.out.println("Este valor de aposta já foi escolhido por outro jogador!");
            return false;
        }

        Competidor jogador = jogadores.get(jogadorIndex);
        jogador.fazerAposta(valor);
        valoresEscolhidos.add(valor);
        return true;
    }

    public void lancarDados() {
        int dado1 = random.nextInt(6) + 1; // Gera número entre 1 e 6
        int dado2 = random.nextInt(6) + 1;

        int somaDados = dado1 + dado2;
        System.out.println("Resultado do lançamento dos dados: " + dado1 + " e " + dado2 + " (Soma: " + somaDados + ")");

        verificarVencedor(somaDados);
    }

    private void verificarVencedor(int somaDados) {
        boolean jogadorVenceu = false;
        Competidor vencedor = null;

        for (Competidor jogador : jogadores) {
            if (jogador.getAposta() == somaDados) {
                jogadorVenceu = true;
                vencedor = jogador;
                break;
            }
        }

        if (jogadorVenceu) {
            System.out.println("O jogador " + vencedor.getNome() + " venceu com a aposta de " + vencedor.getAposta() + "!");
            registrarVitoria(vencedor);
        } else {
            System.out.println("Nenhum jogador acertou a soma. O computador venceu!");
        }
    }

    private void registrarVitoria(Competidor vencedor) {
        // Implementar a persistência em arquivo CSV aqui
        // Exemplo: adicionar o vencedor ao arquivo CSV
    }
}
