package framework.example.controller;


import framework.example.utilities.Listener;
import framework.example.view.CandidatesAndVotesView;

public class ViewUpdater implements Listener {

  private final CandidatesAndVotesView view;

  public ViewUpdater(CandidatesAndVotesView view) {
    this.view = view;
  }
  
  @Override
  public void update() {
    view.update(Controller.getInstance().getModelCandidatesAndVotes());
  }
}
