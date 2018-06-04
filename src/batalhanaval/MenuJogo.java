package batalhanaval;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MenuJogo extends JPanel {
	JLabel recursos = new JLabel("Recursos");
	JLabel habilidades = new JLabel("Habilidades");
	JLabel at1Posicao = new JLabel("Atacar 1 posição");
	JLabel descobrir2 = new JLabel("Descobir 2x2");
	JLabel at2Posicao = new JLabel("Atacar 2x2");
	JLabel atLinha = new JLabel("Atacar linha");
	public MenuJogo() {
		setLayout(null);
		
		Container c = new Container();
		c.setLayout(new GridLayout(6,1));
		c.add(recursos);
		c.add(habilidades);
		c.add(at1Posicao);
		c.add(at2Posicao);
		c.add(descobrir2);
		c.add(atLinha);
	}

}
