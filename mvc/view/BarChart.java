package mvc.view;

import mvc.commons.candidates.CandidateAndVotes;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart extends ApplicationFrame implements CandidatesAndVotesView {

  public BarChart() {
    super("");
  }

  private CategoryDataset createDataset(CandidateAndVotes[] candidates) {

    final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    for(CandidateAndVotes candidate : candidates){
      dataset.addValue(candidate.votes(), candidate.name(), "Votos");
    }
    return dataset;
  }

  @Override
  public void update(CandidateAndVotes[] candidates) {
    JFreeChart barChart = ChartFactory.createBarChart(
            this.getTitle(),
            "Category",
            "Score",
            createDataset(candidates),
            PlotOrientation.VERTICAL,
            true, true, false);
    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    
    setContentPane(chartPanel);
    dispose();
    setSize(560, 350);
    setLocation(800, 380);
    setVisible(true);
  }

}
