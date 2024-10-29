import java.util.Scanner;

public class JogoDaVelha {
    //Tabuleiro do Jogo
    private static char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private static char jogadorAtual = 'X';
    //Ativar o Jogo
    public static void main(String[] args) {
        boolean jogoAtivo = true;
        Scanner scanner = new Scanner(System.in);

        while (jogoAtivo) {
            mostrarTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada (linha e coluna): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
                System.out.println("Movimento inválido. Tente novamente.");
            } else {
                tabuleiro[linha][coluna] = jogadorAtual;
                if (verificarVencedor()) { //Verificar o Vencedor
                    mostrarTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (empate()) {   //Empate
                    mostrarTabuleiro();
                    System.out.println("O jogo empatou!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }
        }
        scanner.close();
    }

    private static void mostrarTabuleiro() { //Mostrar o Tabuleiro durante os Jogos
        System.out.println("==== Jogo da Velha ====");
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }
    //Método para veriicar o vencedor do jogo
    private static boolean verificarVencedor() {
        // Verificação de linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual)
                return true;
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)
                return true;
        }
        // Verificação das diagonais
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual)
            return true;
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)
            return true;
        return false;
    }

    private static boolean empate() { //Verificar as linhas para declarar empate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}