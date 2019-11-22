package view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Por el momento solo tiene un botoncito
public class MVCFrame extends JFrame{
    private JPanel mainPanel;
    private JButton add_vote_Button;

    public MVCFrame(){
        super("MVC Para votaciones");
        setContentPane(mainPanel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        
        add_vote_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionRequest = "add_vote";
                //Aqui es donde ocurre la mágia
                System.out.println(actionRequest);
            }
        });
    }

    public static void main(String[] args) {
        MVCFrame frame = new MVCFrame();
    }
}