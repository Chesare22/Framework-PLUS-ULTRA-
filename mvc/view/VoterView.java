package mvc.view;


import mvc.commons.candidates.Candidate;
import mvc.controller.Voter;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VoterView extends JPanel{
  
  private static final String BUTTON_TEXT = "Votar";
  
  public VoterView(Candidate candidate){
    super();
    init(candidate);
  }
  
  public VoterView(Candidate candidate, LayoutManager layout){
    super(layout);
    init(candidate);
  }
  
  private void init(Candidate candidate) {
    Voter voter = new Voter(candidate.id());
    
    JButton voterButton = new JButton();
    voterButton.addActionListener(voter);
    voterButton.setText(BUTTON_TEXT);
    this.add(voterButton);
    
    this.add(new JLabel(candidate.name()));
  }
}
