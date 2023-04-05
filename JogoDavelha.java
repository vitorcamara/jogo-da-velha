package com.vitorcamara.projetos;

import java.util.Scanner;

public class JogoDavelha {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[][] jogoVelha = new char[3][3];

		System.out.println("O Jogador 1 = X");
		System.out.println("O Jogador 2 = O");

		boolean ganhou = false;
		int jogada = 1;
		char sinal;
		int linha = 0, coluna = 0;

		while (!ganhou) { // enquanto jogador 1 ou 2 não ganhar, o Loop continua

			if (jogada % 2 == 1) { // quando "jogada" é ímpar, é a vez do jogador 1
				System.out.println("\nVez do jogador 1. Escolha linha e coluna [1-3].");
				sinal = 'X'; // jogador 1 joga com 'X'
			} else { // quando "jogada" é par, é a vez do jogador 2
				System.out.println("\nVez do jogador 2. Escolha linha e coluna [1-3].");
				sinal = 'O'; // jogador 2 joga com 'O'
			}

			boolean linhaValida = false;
			while (!linhaValida) {
				System.out.println("Entre com a linha [1,2 ou 3]:");
				linha = scan.nextInt();

				if (linha >= 1 && linha <= 3) {
					linhaValida = true;
				} else {
					System.out.println("Linha inválida! Digite uma linha válida:");
				}
			}

			boolean colunaValida = false;
			while (!colunaValida) {
				System.out.println("Entre com a coluna [1, 2 ou 3]:");
				coluna = scan.nextInt();

				if (coluna >= 1 && coluna <= 3) {
					colunaValida = true;
				} else {
					System.out.println("Coluna inválida! Digite uma coluna válida:");
				}

			}

			linha--;
			coluna--; // linha e coluna sofrem decrementação por conta dos índices que começam em 0

			if (jogoVelha[linha][coluna] == 'X' || jogoVelha[linha][coluna] == 'O') { // esse If impede que uma jogada
																						// já feita, seja escolhida
																						// novamente
				System.out.println("Jogada inválida! Essa posição já foi escolhida anteriormente. Tente novamente:");
			} else {
				jogoVelha[linha][coluna] = sinal; // caso não seja uma jogada inválida, a posição escolhida recebe o
													// sinal referente ao jogador da vez
				jogada++; // jogada recebe +1 para mudar para o próximo jogador
			}

			// imprimir tabuleiro

			for (int i = 0; i < jogoVelha.length; i++) {
				for (int j = 0; j < jogoVelha[i].length; j++) {
					System.out.print(jogoVelha[i][j] + " | "); // aqui as posições já escolhidas são mostradas toda vez
																// que uma nova jogada é feita
				}
				System.out.println();
			}

			// o If abaixo verifica todas as combinações de vitória do jogador 1

			if ((jogoVelha[0][0] == 'X' && jogoVelha[0][1] == 'X' && jogoVelha[0][2] == 'X') || // linha 1
					(jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[1][2] == 'X') || // linha 2
					(jogoVelha[2][0] == 'X' && jogoVelha[2][1] == 'X' && jogoVelha[2][2] == 'X') || // linha 3
					(jogoVelha[0][0] == 'X' && jogoVelha[1][0] == 'X' && jogoVelha[2][0] == 'X') || // coluna 1
					(jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][1] == 'X') || // coluna 2
					(jogoVelha[0][2] == 'X' && jogoVelha[1][2] == 'X' && jogoVelha[2][2] == 'X') || // coluna 3
					(jogoVelha[0][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][2] == 'X') || // diagonal 1
					(jogoVelha[2][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[0][2] == 'X') // diagonal 2
			) {
				ganhou = true;
				System.out.println("PARABÉNS! Jogador 1 GANHOU!");
			}

			// o Else If abaixo verifica todas as combinações de vitória do jogador 2
			else if ((jogoVelha[0][0] == 'O' && jogoVelha[0][1] == 'O' && jogoVelha[0][2] == 'O') || // linha 1
					(jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[1][2] == 'O') || // linha 2
					(jogoVelha[2][0] == 'O' && jogoVelha[2][1] == 'O' && jogoVelha[2][2] == 'O') || // linha 3
					(jogoVelha[0][0] == 'O' && jogoVelha[1][0] == 'O' && jogoVelha[2][0] == 'O') || // coluna 1
					(jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][1] == 'O') || // coluna 2
					(jogoVelha[0][2] == 'O' && jogoVelha[1][2] == 'O' && jogoVelha[2][2] == 'O') || // coluna 3
					(jogoVelha[0][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][2] == 'O') || // diagonal 1
					(jogoVelha[2][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[0][2] == 'O') // diagonal 2
			) {
				ganhou = true;
				System.out.println("PARABÉNS! Jogador 2 GANHOU!");
			} else if (jogada > 9) { // o jogo permite até 9 jogadas, ou seja, se a jogada ultrapassa 9, ninguém
										// ganhou
				ganhou = true;
				System.out.println("EMPATE! Ninguém ganhou a partida!");
			}

		}

	}

}
