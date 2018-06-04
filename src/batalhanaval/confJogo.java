package batalhanaval;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class confJogo extends JFrame {
	private int larguraJ = 400, alturaJ =400 ;  // tamanho da janela
	private int botaoAltura =80, botaoLargura =100;
	private int contLinhas=0;
	 private static int linhas;
	 private static int colunas;
	private int auxMatriz = 0; 
	private int[] qtdEmbarcacoes= new int[5];; // cada posiçao corresponde ao tamnho de um barco e o valor armazenado a qtd de barcos desse tamanho
	private int aux= 0;
	private TelaJogo canvas ;
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
	
		JFileChooser chooserArquivo = new JFileChooser();
		chooserArquivo.showOpenDialog(getParent());
		String arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
		System.out.println(arquivo);
		try {
			 FileReader arq = new FileReader(arquivo);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linhaArquivo = lerArq.readLine(); // lê a primeira linha
		      contLinhas++;
		      while (linhaArquivo != null) {
		       
		        
		        linhaArquivo = lerArq.readLine(); // lê da segunda até a última linha
		        contLinhas++;
		        if(contLinhas == 2) {
		        	linhas = Integer.valueOf(linhaArquivo.substring(3, 5));
		        	colunas = Integer.valueOf(linhaArquivo.substring(0,2));
		       
		        	System.out.printf("coluna %d\n",colunas);
		        	System.out.printf("linha %d\n",linhas);
		        	
		        	
		        }
		        
		        if (contLinhas > 4 && auxMatriz <= linhas ) {
		        	 
		        	 for(char c : linhaArquivo.toCharArray()){
		        		// canvas.setMatrizExplosao(auxMatriz, Integer.parseInt(String.valueOf(c)));
	                      System.out.println( Integer.parseInt(String.valueOf(c)));
	                      
	               }
		        	 auxMatriz++;
		        }
		        
		        if (contLinhas - linhas > 6 && contLinhas - linhas < 12) {
		        	
		        	qtdEmbarcacoes[aux] = Integer.parseInt(linhaArquivo.substring(2, 3));
		        	System.out.println(Integer.parseInt(linhaArquivo.substring(2, 3)));
		        	aux++;

		        }
		}
		
		      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
	    }
		 canvas = new TelaJogo(linhas, colunas);
		ThreadJogo updateScreenThread = new ThreadJogo(canvas);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo(canvas,updateScreenThread);
					frame.setVisible(true);
				} catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o mapa do jogo!");
				}
			}
		});
	}




	public static int getLinhas() {
		return linhas;
	}




	public static int getColunas() {
		return colunas;
	}






	
}