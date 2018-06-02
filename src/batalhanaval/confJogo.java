package batalhanaval;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class confJogo extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	private int botaoAltura =80, botaoLargura =100;
	private int retorno;
	
	
	public confJogo() {
		super("Batalha Naval");
		setLayout(null);
		

		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(1,1,0,10));
		c2.setBounds((larguraJ -larguraJ/2)-(botaoLargura/2),(alturaJ-50)-botaoAltura,botaoLargura,botaoAltura); // posicionando os botoes na tela
		
	       JButton iniciar = new JButton("escolha o arquivo");
	       
	       c2.add(iniciar);
	       
	       add(c2);

	     iniciar.setActionCommand("file");
	     
	     
	     iniciar.addActionListener(new ButtonClickListener()); 
	  
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // nao deixa mudar tamanho da janela
		setSize(larguraJ, alturaJ); // tamanho da janela
		setVisible(true);
	}
	
	
	
	
	
	public void arquivo() {
		//JFileChooser chooser = new JFileChooser();
		//retorno = chooser.showOpenDialog(null);
	//	System.out.println(retorno);
		JFileChooser chooserArquivo = new JFileChooser();
		int escolha = chooserArquivo.showOpenDialog(getParent());
		String arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
		System.out.println(arquivo);
		
	}
}