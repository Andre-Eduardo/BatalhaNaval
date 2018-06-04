package batalhanaval;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Jogo extends JFrame  {

	//private TelaJogo canvas = new TelaJogo();
//	ThreadJogo updateScreenThread = new ThreadJogo(canvas);
	
	
	
	public static void main(String[] args) {
		new JanelaInicial();
		
	}

	public Jogo(TelaJogo canvas, ThreadJogo updateScreenThread, int[][] matriJogo) {
		Container c = getContentPane();
		c.add(BorderLayout.CENTER, canvas);
		c.add(BorderLayout.WEST, new MenuJogo());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centralizar Janela
		setLocationRelativeTo(null);
		
		//getContentPane().setLayout(new BorderLayout());
		setTitle("Batalha Naval");
		//getContentPane().add("Center", canvas);
		
		// Define largura e altura da janela principal
		setSize(TelaJogo.LARGURA_IMG * (canvas.getColunas()+1) , TelaJogo.ALTURA_IMG * (canvas.getLinhas()+1));
		
		setVisible(true);
		
		// Inicia Thread com timer para redesenhar a tela.
		updateScreenThread.start();
		
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
		        int x=e.getX();
		        int y=e.getY();
				
		        int x_pos = x/canvas.LARGURA_IMG;
		        int y_pos = y/canvas.ALTURA_IMG;

		        if (matriJogo[y_pos][x_pos] == 2 || matriJogo[y_pos][x_pos] == 1 ||matriJogo[y_pos][x_pos] == 3 || matriJogo[y_pos][x_pos] == 4|| matriJogo[y_pos][x_pos] == 5) {
		        canvas.setMatrizExplosao(x_pos, y_pos);
		        }
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}


		});
	}

	

}
