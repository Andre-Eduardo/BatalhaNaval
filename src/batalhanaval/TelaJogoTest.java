package batalhanaval;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelaJogoTest {
	public TelaJogo tela;
	public int linha;
	public int coluna;
	public int x ;
	public int y ;
	public int[] qtdBarcos;// = { 1, 2, 2, 1 };
	public int[][] matrizJogo;

	@BeforeEach
	public void beforeTests() {
		// preparando as variaveis
		linha = 10;
		coluna = 10;
		x= 20;
		y = 40;
		matrizJogo = new int[linha][coluna];
		qtdBarcos = new int [5];
		tela = new TelaJogo(linha, coluna, matrizJogo, qtdBarcos);

	}

	@Test
	public void TestaGet() {

		assertEquals(linha, tela.getLinhas());
		assertEquals(coluna, tela.getColunas());

	}
	@Test
	public void TestSet() {
		tela.setX(x);
		tela.setY(y);
		assertEquals(x, tela.getX());
		assertEquals(y, tela.getY());

	}
	

}
