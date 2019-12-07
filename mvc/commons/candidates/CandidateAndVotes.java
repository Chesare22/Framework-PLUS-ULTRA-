package mvc.commons.candidates;

public class CandidateAndVotes extends Candidate {

  private final int votes;

  public CandidateAndVotes(Candidate candidate, int votes) {
    super(candidate.id(), candidate.name());
    this.votes = votes;
  }

  public CandidateAndVotes(String[] candidateData){
    super(Integer.parseInt(candidateData[0]), candidateData[1]);
    this.votes = Integer.parseInt(candidateData[2]);
  }

  public int votes() {
    return votes;
  }

  @Override
  public String toString() {
    return String.valueOf(id()) + " " + String.valueOf(name()) + " " + String.valueOf(votes());
  }
}
