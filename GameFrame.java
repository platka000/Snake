package packaged;



import javax.swing.JFrame;









public class GameFrame extends JFrame   {

	private static final long serialVersionUID = -874934063039251991L;

	GameFrame(){
		
		this.add(new GamePanel());
		this.setTitle("Snake");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(false);
				this.pack();
				this.setVisible(true);
				this.setLocationRelativeTo(null);
	
	
	
	}

	
}
