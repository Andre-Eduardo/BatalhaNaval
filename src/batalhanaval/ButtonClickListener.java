package batalhanaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "iniciar":
			
			
			
			new confJogo().setVisible(true);
			
			
			break;

		case "rank":
			
			break;
			
		case "file":
			 new confJogo().arquivo();
		}

	}

}
