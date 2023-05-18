import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessPanel extends JPanel implements ActionListener {

    private JLabel text;

    private JTextField input;

    private JButton submitButton;

    private int randomNumber;

    private int tries = 1;

    public GuessPanel(int randomNumber) {

        setLayout(new FlowLayout());

        this.randomNumber = randomNumber;

        text = new JLabel("Enter a number between 1-100");
        text.setBackground(Color.lightGray);

        input = new JTextField(5);

        submitButton = new JButton("Submit guess");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);

        add(text);
        add(input);
        add(submitButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String guess = input.getText();
        int guessParse = -1;
        String command = e.getActionCommand();

        switch (command) {
            case "Submit":
                try{
                    guessParse = Integer.parseInt(guess);
                } catch (NumberFormatException ex){
                    System.out.println("Can't parse the input");
            }

                if(guessParse == randomNumber) {
                    JOptionPane.showMessageDialog(null, "CORRECT!! You guessed the random number of " + randomNumber + " in " + tries + " tries!!", "YAY", JOptionPane.INFORMATION_MESSAGE);

                } else if(guessParse < 1 || guessParse > 100) {
                    JOptionPane.showMessageDialog(null, "Not within 1-100. Try again! Attempts: " + tries, "Try again", JOptionPane.ERROR_MESSAGE);
                    tries++;
                }else {

                    JOptionPane.showMessageDialog(null, "Nope. You didn't get it. Try again! Attempts: " + tries, "Try again", JOptionPane.ERROR_MESSAGE);
                    tries++;

                }




        }

    }
}
