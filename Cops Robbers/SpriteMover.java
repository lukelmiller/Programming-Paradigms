
public class SpriteMover extends Thread{
	
	Model model;
	View view;
	
	
	public SpriteMover(Model model, View view){
		
		this.model = model;
		this.view = view;
		
	}
	
	public void run() {
		
		while(true) {
			
			model.updateScene(view.getWidth(),view.getHeight());
			view.repaint();
			try {
	            Thread.sleep(2);
	        } catch (InterruptedException e) {}
		}
		
	}

}
