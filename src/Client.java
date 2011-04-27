import java.awt.BorderLayout;
import javax.swing.JFrame;
import view.MancalaComponent;

/**
 * Client class. Contains the main method that starts the game. Creats the JFrame
 */
public class Client 
{

    /**
     * Starts the game
     * @param args the args
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        MancalaComponent component = new MancalaComponent();
        frame.setSize(1000, 750);
        frame.setTitle("Mancala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(component, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
