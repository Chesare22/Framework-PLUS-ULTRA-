package mvc.model;


import java.util.Arrays;
import mvc.commons.candidates.*;
// import mvc.commons.sockets.*;

public class Model {

  private final int[] votes;
  private final Candidate[] candidates;
  // private final MessageHandler messageHandler = new MessageHandler();

  public Model(String[] candidatesNames) {
    votes = new int[candidatesNames.length];
    Arrays.fill(votes, 0);

    candidates = new Candidate[candidatesNames.length];
    for (int i = 0; i < candidatesNames.length; i++) {
      candidates[i] = new Candidate(i, candidatesNames[i]);
    }
  }

    /* public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No se indicaron los candidatos");
            System.exit(1);
        }
        Model mvc.model = new Model(args);
        mvc.model.startServer();
    }

  public void startServer(){
      while (true){
          messageHandler.handleIncomingMessage();
      }
  } */

  public void vote(int candidateId) {
    votes[candidateId]++;
  }

  public Candidate[] getCandidates() {
    return candidates;
  }

  public CandidateAndVotes[] candidatesAndVotes() {
    CandidateAndVotes[] cav = new CandidateAndVotes[candidates.length];
    for (int i = 0; i < candidates.length; i++) {
      cav[i] = new CandidateAndVotes(candidates[i], votes[i]);
    }
    return cav;
  }

  /* private class MessageHandler{
    private final Forwarder forwarder = new Forwarder();
    private final Receiver receiver = new Receiver(1429,20);

    public void sendMessage(String message){
        forwarder.send("client", message);
    }
    public void handleIncomingMessage(){
        String message = "";
        try {
            message = receiver.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Incoming message: " + message);

        if(message.equals("Hi server, can you gimme your candidates' array? UwU")){
            System.out.println("Of course, you handsome (:");
            System.out.println("");
            forwarder.addService("client", new Service("127.0.0.1", 1428));
            sendMessage(Candidate.stringify(getCandidates()));
            return;
        }
        if(message.startsWith("Somebody wanna vote for ")){
            System.out.println("Got it ^^");
            System.out.println("");
            vote(Integer.valueOf(message.split(" ")[4]));
            return;
        }
        if(message.equals("Oh no, I forgot how are the elections going D:")){
            System.out.println("Haha don't worry, here's the marker");
            System.out.println("");
            sendMessage(Candidate.stringify((candidatesAndVotes())));
        }
    }
  } */
}
