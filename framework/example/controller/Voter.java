package framework.example.controller;

import framework.ActionInvoker;
import framework.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Voter implements ActionListener {

  private final int candidateId;

  public Voter(int candidateId) {
    this.candidateId = candidateId;
  }
  
  public void vote(){
    Controller.getInstance().vote(candidateId);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //vote();
    ActionInvoker invoker = ActionInvoker.getInstance();
    invoker.invokeAction("add_vote", new Event(candidateId, 1));
  }

}
