package framework.example.model;

import java.util.Arrays;

import framework.example.commons.candidates.*;

public class Model {

  private final int[] votes;
  private final Candidate[] candidates;

  public Model(String[] candidatesNames) {
    votes = new int[candidatesNames.length];
    Arrays.fill(votes, 0);

    candidates = new Candidate[candidatesNames.length];
    for (int i = 0; i < candidatesNames.length; i++) {
      candidates[i] = new Candidate(i, candidatesNames[i]);
    }
  }

  public void vote(int id) {
    votes[id]++;
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
}


