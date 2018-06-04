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
	
	public TelaJogo(int linha, int coluna) {
		setLinhas(linha);
		setColunas(coluna);
		matrizExplosao = new int [colunas][linhas];
	}

	@Override
	public void paint(Graphics g) {
		
		
		
		ImageIcon imgAgua = new ImageIcon("imagens/ondas.jpg");
		ImageIcon imgExplosao = new ImageIcon("imagens/explosion.png");
		// Prepare an Image object to be used by drawImage()
		final Image agua = imgAgua.getImage();
		final Image explosao = imgExplosao.getImage();
		
		for(int i = 0; i < colunas; i++) {
			for(int j = 0; j < linhas; j++) {				
				g.drawImage(agua, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
				
				

				if(matrizExplosao[i][j] == 1) {
					g.drawImage(explosao, i*LARGURA_IMG+MARGIN, j*ALTURA_IMG+MARGIN, LARGURA_IMG, ALTURA_IMG, null);
				}
			}

		}
		PrintGrid(g);
	}
	
	public void setMatrizExplosao(int x, int y) {
		matrizExplosao[x][y] = 1;
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
