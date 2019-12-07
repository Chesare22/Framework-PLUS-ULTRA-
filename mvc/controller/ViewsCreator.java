package mvc.controller;

import mvc.utilities.Listener;
import mvc.view.BarChart;
import mvc.view.PieChart;
import mvc.view.ShowVotesCLI;

public class ViewsCreator {

  public static Listener[] createListeningViews() {
    ViewUpdater[] viewUpdaters = {
      new ViewUpdater(new ShowVotesCLI()),
      new ViewUpdater(new PieChart("Titulo")),
      new ViewUpdater(new BarChart())
    };
    return viewUpdaters;
  }
}
