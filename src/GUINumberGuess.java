import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUINumberGuess extends JFrame {

    private GuessPanel guessPanel;

    public GUINumberGuess() {
        this.setTitle("Number Guess");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500,500));
        this.setResizable(false);

        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;
        System.out.println("\n*** For grading purposes, the random number generated is " + randomNumber + " ***");

        guessPanel = new GuessPanel(randomNumber);

        add(guessPanel);

        setVisible(true);

    }


}
