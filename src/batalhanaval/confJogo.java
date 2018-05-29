package batalhanaval;

import javax.swing.JFrame;

public class confJogo extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	

	
	
	public confJogo() {
		super("Batalha Naval");
		setLayout(null);
		

		

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // nao deixa mudar tamanho da janela
		setSize(larguraJ, alturaJ); // tamanho da janela
		setVisible(true);
	}
}