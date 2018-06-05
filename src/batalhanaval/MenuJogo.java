package batalhanaval;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MenuJogo extends JPanel {
	JLabel recursos = new JLabel("Recursos");
	JLabel habilidades = new JLabel("Habilidades");
	JLabel at1Posicao = new JLabel("Atacar 1 posição");
	JLabel descobrir2 = new JLabel("Descobir 2x2");
	JLabel at2Posicao = new JLabel("Atacar 2x2");
	JLabel atLinha = new JLabel("Atacar linha");
	JLabel vazio = new JLabel(" -- ");
	JLabel vazio2 = new JLabel(" 100 ");
	JRadioButton radio = new JRadioButton("5");
	JRadioButton radio2 = new JRadioButton("10");
	JRadioButton radio3 = new JRadioButton("15");
	JRadioButton radio4 = new JRadioButton("20");
	
	public MenuJogo() {
		
		
		
		setLayout(new GridLayout(6,2));
		add(recursos);
		add(vazio);
		add(habilidades);
		add(vazio2);
		add(at1Posicao);
		add(radio);
		add(at2Posicao);
		add(radio2);
		add(descobrir2);
		add(radio3);
		add(atLinha);
		add(radio4);
		
		
		
	}

}
