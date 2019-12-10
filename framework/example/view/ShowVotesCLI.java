package framework.example.view;


import framework.example.commons.candidates.CandidateAndVotes;

public class ShowVotesCLI implements CandidatesAndVotesView {
  
  @Override
  public void update(CandidateAndVotes[] candidates) {
    for(CandidateAndVotes candidate: candidates){
      System.out.println(candidate.name() + " tiene " + candidate.votes() + " votos.");
    }
    System.out.println("");
  }
}
