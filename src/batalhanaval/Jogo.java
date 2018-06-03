package batalhanaval;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Jogo extends JFrame  {

	private TelaJogo canvas = new TelaJogo();
	ThreadJogo updateScreenThread = new ThreadJogo(canvas);
	
	
	
	public static void main(String[] args) {
		new JanelaInicial();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centralizar Janela
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		setTitle("Batalha Naval");
		getContentPane().add("Center", canvas);
		
		// Define largura e altura da janela principal
		setSize(canvas.LARGURA_IMG * canvas.getColunas(), canvas.ALTURA_IMG * canvas.getLinhas());
		
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

		        canvas.setMatrizExplosao(x_pos, y_pos);
				
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
