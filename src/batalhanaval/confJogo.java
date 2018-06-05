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
// classe que le o arquivo e configura o jogo
public class confJogo extends JFrame {
	private int larguraJ = 300, alturaJ =200 ;  // tamanho da janela
	private int botaoAltura =40, botaoLargura =150;
	private int contLinhas=0;
	 private static int linhas;
	 private static int colunas;
	private int auxMatriz = 0; 
	private int[][] matrizJogo;
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
		        	 String [] tamanhoMatriz = linhaArquivo.split(" ");
		                
		                colunas = Integer.parseInt(tamanhoMatriz[0]);
		                linhas = Integer.parseInt(tamanhoMatriz[1]);
		        
		        	matrizJogo = new int [linhas][colunas];
		        	System.out.printf("coluna %d\n",colunas);
		        	System.out.printf("linha %d\n",linhas);
		        	
		        	
		        }
		        
		        if (contLinhas > 4 && auxMatriz <= linhas ) {
		        	 int j = 0; 
		        	 for(char c : linhaArquivo.toCharArray()){
		        		
		        		 matrizJogo[auxMatriz][j] = Integer.parseInt(String.valueOf(c));
	                      System.out.println( Integer.parseInt(String.valueOf(c)));
	                      j++;
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
		 canvas = new TelaJogo(linhas, colunas,matrizJogo,qtdEmbarcacoes);
		ThreadJogo updateScreenThread = new ThreadJogo(canvas);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo(canvas,updateScreenThread,matrizJogo);
					frame.setVisible(true);
				} catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o mapa do jogo!");
				}
			}
		});
	}




	public int[][] getMatrizJogo() {
		return matrizJogo;
	}








	
}