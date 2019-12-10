package framework.example.view;


import framework.example.commons.candidates.Candidate;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VoterViewsContainer extends JFrame {

  private VoterViewsContainer(String title, Candidate[] candidates) {
    super(title);
    init(candidates);
  }

  public void init(Candidate[] candidates) {
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
    mainPanel.add(new JLabel(" "));

    for (Candidate candidate : candidates) {
      mainPanel.add(new VoterView(candidate));
    }

    this.setContentPane(new JScrollPane(mainPanel));
  }

  public static void run(String title, Candidate[] candidates) {
    VoterViewsContainer mainFrame = new VoterViewsContainer(title, candidates);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.pack();
    mainFrame.setSize(300, 200);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);
  }
}
