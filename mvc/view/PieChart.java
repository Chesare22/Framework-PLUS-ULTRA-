package mvc.view;

import javax.swing.JPanel;

import mvc.commons.candidates.CandidateAndVotes;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class PieChart extends ApplicationFrame implements CandidatesAndVotesView {


  public PieChart(String title) {
    super(title);
  }

  private void iniciar() {
    setSize(560, 350);
    setLocation(800, 10);
    setVisible(true);
  }

  private static PieDataset createDataset(CandidateAndVotes[] candidates) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    
    for(CandidateAndVotes candidate : candidates) {
      dataset.setValue(candidate.name(), candidate.votes());
    }
    
    return dataset;
  }

  private static JFreeChart createChart(PieDataset dataset) {
    JFreeChart chart = ChartFactory.createPieChart(
            "Votos circular", // chart title 
            dataset, // data    
            true, // include legend   
            true,
            false);

    return chart;
  }

  private static JPanel createDemoPanel(CandidateAndVotes[] candidates) {
    JFreeChart chart = createChart(createDataset(candidates));
    return new ChartPanel(chart);
  }

  @Override
  public void update(CandidateAndVotes[] candidates) {
    setContentPane(createDemoPanel(candidates));
    dispose();
    iniciar();
  }

}
