package batalhanaval;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class confJogo extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	private int botaoAltura =80, botaoLargura =100;
	private int retorno;
	private int contLinhas=0;
	private int linhaMatriz;
	private int colunaMatriz ;
	private char[] linhaVetor ;
	private int auxMatriz = 0; 
	private TelaJogo canvas = new TelaJogo();
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
		try {
			 FileReader arq = new FileReader(arquivo);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // lê a primeira linha
		      contLinhas++;
		      while (linha != null) {
		       
		        
		        linha = lerArq.readLine(); // lê da segunda até a última linha
		        contLinhas++;
		        if(contLinhas == 2) {
		        	linhaMatriz = Integer.valueOf(linha.substring(3, 5));
		        	colunaMatriz = Integer.valueOf(linha.substring(0,2));
		        	canvas.setColunas(colunaMatriz);
		        	canvas.setLinhas(linhaMatriz);
		        	
		        }
		        
		        if (contLinhas > 4 && auxMatriz <= linhaMatriz ) {
		        	 linhaVetor = linha.toCharArray();
		        	 for(char c : linha.toCharArray()){
		        		 
	                      System.out.println("Char: "+c);
	                      
	               }
		        	 auxMatriz++;
		        }
		}
		
		      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
	    }
	}
}