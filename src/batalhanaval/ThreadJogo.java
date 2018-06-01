package batalhanaval;

public class ThreadJogo extends Thread {
	private TelaJogo canvas;
	private boolean running = true; 
	
	public ThreadJogo(TelaJogo canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canvas.paint(canvas.getGraphics());
		}
	}
}
