package mvc.controller;

/* import mvc.commons.sockets.Forwarder;
import mvc.commons.sockets.Receiver;
import mvc.commons.sockets.Service; */
import mvc.model.Model;
import mvc.utilities.Notifier;
import mvc.view.VoterViewsContainer;
import mvc.commons.candidates.*;
import mvc.utilities.Listener;

// import java.io.IOException;


public class Controller {
  
  private static Controller singleController;
  private final Notifier notifier = new Notifier();
  // private final MessageHandler messageHandler = new MessageHandler();
  private final Model model;

  public Controller(Model model) {
    this.model = model;
  }

  /* public static void main(String[] args) {
    Controller mvc.controller = new Controller();
    mvc.controller.startApp();
  } */

  public void startApp() {

    singleController = this;
    
    Listener[] listeningViews = ViewsCreator.createListeningViews();
    for (Listener listeningView : listeningViews) {
      notifier.addListener(listeningView);
    }
    
    // Candidate[] candidates = messageHandler.askForCandidates();
    VoterViewsContainer.run("Votaciones",model.getCandidates());
  }
  
  public void vote(int id) {
    // messageHandler.vote(id);
    model.vote(id);
    notifier.updateAll();
  }
  public CandidateAndVotes[] getModelCandidatesAndVotes() {
    // return messageHandler.askForCandidatesAndVotes();
    return model.candidatesAndVotes();
  }
  public static Controller getInstance(){
    return singleController;
  }

  /* private class MessageHandler{
    private final Forwarder forwarder = new Forwarder();
    private final Receiver receiver = new Receiver(1428,20);

    public MessageHandler(){
      forwarder.addService("server", new Service("127.0.0.1", 1429));
    }

    public void sendMessage(String message){
      forwarder.send("server", message);
    }

    public Candidate[] askForCandidates() {
      sendMessage("Hi server, can you gimme your candidates' array? UwU");
      try {
        String candidates = receiver.getMessage();
        return Candidate.parse(candidates);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    public void vote(int id) {
      sendMessage("Somebody wanna vote for " + id);
    }

      public CandidateAndVotes[] askForCandidatesAndVotes() {
        sendMessage("Oh no, I forgot how are the elections going D:");
          try {
              String candidates = receiver.getMessage();
              return (CandidateAndVotes[]) Candidate.parse(candidates);
          } catch (IOException e) {
              e.printStackTrace();
          }
          return null;
      }
  } */
}
