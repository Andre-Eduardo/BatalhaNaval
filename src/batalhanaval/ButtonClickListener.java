package batalhanaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "iniciar":
			System.out.println("1");

			new confJogo().setVisible(true);
			
			
			break;

		case "rank":
			System.out.println("2");
			break;
			
		case "file":
			 new confJogo().arquivo();
		}

	}

}
