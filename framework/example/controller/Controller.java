package framework.example.controller;

import framework.Event;
import framework.example.model.Model;
import framework.example.utilities.Notifier;
import framework.example.view.VoterViewsContainer;
import framework.example.commons.candidates.*;
import framework.example.utilities.Listener;

public class Controller {
  
  private static Controller singleController;
  private final Notifier notifier = new Notifier();
  private final Model model;

  public Controller(Model model) {
    this.model = model;
  }

  public void startApp() {

    singleController = this;
    
    Listener[] listeningViews = ViewsCreator.createListeningViews();
    for (Listener listeningView : listeningViews) {
      notifier.addListener(listeningView);
    }
    
    VoterViewsContainer.run("Votaciones",model.getCandidates());
  }
  
  public void vote(int id) {
    model.vote(id);
    notifier.updateAll();
  }

  public CandidateAndVotes[] getModelCandidatesAndVotes() {
    return model.candidatesAndVotes();
  }
  public static Controller getInstance(){
    return singleController;
  }

}
