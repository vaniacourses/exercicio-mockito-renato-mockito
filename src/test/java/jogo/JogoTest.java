package jogo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JogoTest {

	@Test
	void deveGanharPrimeiroTurnoCom7() {
		Jogador jogador = mock(Jogador.class);
		Dado dado1 = mock(Dado.class);
		Dado dado2 = mock(Dado.class);

		when(jogador.lancar(dado1, dado2)).thenReturn(7);

		Jogo jogo = new Jogo(jogador, dado1, dado2);

		assertTrue(jogo.jogo());
		verify(jogador, times(1)).lancar(dado1, dado2);
	}

	@Test
	void devePerderPrimeiroTurnoCom2() {
		Jogador jogador = mock(Jogador.class);
		Dado dado1 = mock(Dado.class);
		Dado dado2 = mock(Dado.class);

		when(jogador.lancar(dado1, dado2)).thenReturn(2);

		Jogo jogo = new Jogo(jogador, dado1, dado2);

		assertFalse(jogo.jogo());
	}

	@Test
	void deveGanharNoSegundoTurnoRepetindoPonto() {
		Jogador jogador = mock(Jogador.class);
		Dado dado1 = mock(Dado.class);
		Dado dado2 = mock(Dado.class);

		when(jogador.lancar(dado1, dado2)).thenReturn(5) // primeiro turno -> ponto = 5
				.thenReturn(3) // segundo turno (ainda não)
				.thenReturn(5); // terceiro lançamento -> ganhou

		Jogo jogo = new Jogo(jogador, dado1, dado2);

		assertTrue(jogo.jogo());
		verify(jogador, atLeast(2)).lancar(dado1, dado2);
	}

	@Test
	void devePerderNoSegundoTurnoCom7() {
		Jogador jogador = mock(Jogador.class);
		Dado dado1 = mock(Dado.class);
		Dado dado2 = mock(Dado.class);

		when(jogador.lancar(dado1, dado2)).thenReturn(4) // primeiro turno -> ponto = 4
				.thenReturn(7); // segundo turno -> perdeu

		Jogo jogo = new Jogo(jogador, dado1, dado2);

		assertFalse(jogo.jogo());
	}
}
