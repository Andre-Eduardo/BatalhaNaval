package batalhanaval;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class TelaJogo extends Canvas {
	public static final int LARGURA_IMG = 80;
	public static final int ALTURA_IMG = 80;
	public static final int MARGIN = 0;
	private int linhas; 
	private int colunas;  // deve ser lido do arquivo
	private int[][] matrizExplosao;
	private int[][] matrizCordenadas;
	private int[] cont = {0,0,0,0,0};
	private int[]qtdEmbarcacoes;
	private int x;
	private int y;
	
	public TelaJogo(int linha, int coluna, int [][]matrizJogo,int []qtdBarcos) {
		setLinhas(linha);
		setColunas(coluna);
		qtdEmbarcacoes = qtdBarcos.clone();
		matrizExplosao = new int [colunas][linhas];
		matrizCordenadas = new int [colunas][linhas];
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				matrizCordenadas[i][j] = matrizJogo[i][j];
			}
		}
	}

	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	@Override
	public void paint(Graphics g) {
		
		// declarando as immagens
		ImageIcon barco5 = new ImageIcon("imagens/Battleship/ShipBattleshipHull.png");//barco de tamanho 5
		ImageIcon barco4 = new ImageIcon("imagens/Carrier/ShipCarrierHull.png"); // barco de tamanho 4
		ImageIcon barco3 = new ImageIcon("imagens/Cruiser/ShipCruiserHull.png");//barco de tamanho 3
		ImageIcon barco2 = new ImageIcon("imagens/Destroyer/ShipDestroyerHull.png");//barco de tamanho 2
		ImageIcon barco1 = new ImageIcon("imagens/PatrolBoat/ShipPatrolHull.png");//barco de tamanho 1
		ImageIcon imgAgua = new ImageIcon("imagens/ondas.jpg");
		ImageIcon imgExplosao = new ImageIcon("imagens/explosion.png");
	
		
		final Image shipPatrol =  barco1.getImage();
		final Image shipDestroyer =  barco2.getImage();
		final Image shipCruiser =  barco3.getImage();
		final Image shipCarrier =  barco4.getImage();
		final Image battleship =  barco5.getImage();
		final Image agua = imgAgua.getImage();
		final Image explosao = imgExplosao.getImage();
		
		for(int i = 0; i < colunas; i++) {
			for(int j = 0; j < linhas; j++) {				
				g.drawImage(agua, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
				
				

				if(matrizExplosao[i][j] == 1) {
					g.drawImage(explosao, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
					//g.drawImage(battleship, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
				}
				
				switch (matrizCordenadas[x][y]) {
				case 1:
					cont[0]++;
				if (cont[0] == qtdEmbarcacoes[0]) {
					// repintar o fundo da tela 
					
					g.drawImage(shipPatrol, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
				}
				break;

				case 2:
				cont[1]++;
			if (cont[1] == qtdEmbarcacoes[1]) {
				// repintar o fundo da tela 
				
				g.drawImage(shipDestroyer, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
			}
				break;
				case 3:
				cont[2]++;
			if (cont[2] == qtdEmbarcacoes[2]) {
				// repintar o fundo da tela 
				
				g.drawImage(shipCruiser, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
			}			
				break;
				case 4:
				cont[3]++;
			if (cont[3] == qtdEmbarcacoes[3]) {
				// repintar o fundo da tela 
				
				g.drawImage(shipCarrier, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
			}
				break;
				case 5:
				cont[4]++;
			if (cont[4] == qtdEmbarcacoes[4]) {
				// repintar o fundo da tela 
				
				g.drawImage(battleship, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
			}
				break;
				
				default:
					break;
				}
			}

		}
		
		
		
		PrintGrid(g);
	}
	
	public void setMatrizExplosao(int x, int y) {
		matrizExplosao[x][y] = 1;
		setX(x);
		setY(y);
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	
    public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void PrintGrid(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.BLACK);
        
        for (int i = 0; i < linhas + 1; i++){
                g2d.drawLine(MARGIN, MARGIN+i*ALTURA_IMG, MARGIN+LARGURA_IMG*colunas, MARGIN+i*ALTURA_IMG);
        }
        
        for (int i = 0; i < colunas + 1; i++){
                g2d.drawLine(MARGIN+i*LARGURA_IMG, MARGIN, MARGIN+i*LARGURA_IMG, MARGIN+ALTURA_IMG*linhas);
        }
    }

}
