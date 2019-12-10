package framework.example.controller;

import framework.example.utilities.Listener;
import framework.example.view.BarChart;
import framework.example.view.PieChart;
import framework.example.view.ShowVotesCLI;

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
