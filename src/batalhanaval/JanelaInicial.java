package batalhanaval;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaInicial extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	private int botaoAltura =80, botaoLargura =100;

	private JPanel tela; // tela do jogo

	public JanelaInicial() {
		super("Batalha Naval");
		setLayout(null);
		
		//Container c = getContentPane();
		//c.setLayout( new BorderLayout());
		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(2,1));
		c2.setBounds((larguraJ -larguraJ/2)-(botaoLargura/2),(alturaJ-50)-botaoAltura,botaoLargura,botaoAltura); // posicionando os botoes na tela
		
	       JButton botao = new JButton("Iniciar");
	       JButton botao2 = new JButton("Rank");
	       c2.add(botao);
	       c2.add(botao2);
	       //c.add(BorderLayout.SOUTH,c2);
	       add(c2);
	     

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(larguraJ, alturaJ); // tamanho da janela
		setVisible(true);
		
	}




	
	
	
	

}
