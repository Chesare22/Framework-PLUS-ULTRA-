package mvc.commons.candidates;

import java.util.ArrayList;
import java.util.List;

public class Candidate {

  private final int id;
  private final String name;

  public Candidate(int id, String name) {
    this.id = id;
    this.name = name;
  }
  public  Candidate(String[] candidateData){
    this.id = Integer.parseInt(candidateData[0]);
    this.name = candidateData[1];
  }

  public int id() {
    return id;
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return String.valueOf(id()) + " " + String.valueOf(name());
  }

  public static String stringify(Candidate[] candidates){
    String text = "";
    for (int i = 0; i < candidates.length-1 ; i++){
      text = text + candidates[i].toString() + ",";
    }
    text = text + candidates[candidates.length-1].toString();
    return text;
  }
  public static Candidate[] parse(String text) {
    String[] candidatesArr = text.split(",");
    boolean hasVotes = candidatesArr[0].split(" ").length == 3;
    List<Candidate> candidates = new ArrayList<>();
    for (String candidate: candidatesArr) {
      String[] candidateArr = candidate.split(" ");
      candidates.add(hasVotes ? new CandidateAndVotes(candidateArr) : new Candidate(candidateArr));
    }
    return candidates.toArray(hasVotes ? new CandidateAndVotes[candidates.size()] : new Candidate[candidates.size()]);
  }

}
