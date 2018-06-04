package batalhanaval;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaInicial extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	private int botaoAltura =80, botaoLargura =100;

	
	
	public JanelaInicial() {
		super("Batalha Naval");
		setLayout(null);
		
		

		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(2,1,0,10));
		c2.setBounds((larguraJ -larguraJ/2)-(botaoLargura/2),(alturaJ-50)-botaoAltura,botaoLargura,botaoAltura); // posicionando os botoes na tela
		
	       JButton iniciar = new JButton("Iniciar");
	       JButton rank = new JButton("Rank");
	       c2.add(iniciar);
	       c2.add(rank);
	       add(c2);

	     iniciar.setActionCommand("iniciar");
	     rank.setActionCommand("rank");
	     
	     iniciar.addActionListener(new ButtonClickListener()); 
	     rank.addActionListener(new ButtonClickListener()); 
	       

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // nao deixa mudar tamanho da janela
		setSize(larguraJ, alturaJ); // tamanho da janela
		setVisible(true);
		
	}




	
	
	
	

}
