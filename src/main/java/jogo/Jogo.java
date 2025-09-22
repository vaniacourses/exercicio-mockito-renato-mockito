package jogo;

public class Jogo {

	private Jogador jogador;
	private Dado dado1;
	private Dado dado2;

	public Jogo(Jogador jogador, Dado dado1, Dado dado2) {
		this.jogador = jogador;
		this.dado1 = dado1;
		this.dado2 = dado2;
	}

	/*
	 * Se for o primeiro turno e a soma das faces dos dados cair 7 ou 11, voce ganha
	 * o jogo; Se for o primeiro turno e a soma das faces dos dados cair 2, 3 e 12,
	 * voce perde o jogo;  Se nao cair nenhum desses valores, o valor é armazenado e
	 * passa para o segundo turno; Se for o segundo turno e a soma das faces dos
	 * dados cair 7 novamente, voce perde o jogo; Se for o segundo turno, voce
	 * continuando jogando os dados e só ganha se cair um numero igual ao anterior
	 * do primeiro turno;
	 */

	public boolean jogo() {
		int resultado = jogador.lancar(dado1, dado2);

		if (resultado == 7 || resultado == 11) {
			return true;
		} else if (resultado == 2 || resultado == 3 || resultado == 12) {
			return false;
		}

		int ponto = resultado;
		resultado = jogador.lancar(dado1, dado2);

		while (resultado != ponto && resultado != 7) {
			resultado = jogador.lancar(dado1, dado2);
		}

		return resultado == ponto;
	}
}
