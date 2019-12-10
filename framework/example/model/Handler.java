package framework.example.model;

import framework.Event;
import framework.example.controller.Controller;

public class Handler {

    public Handler(){
    }

    public void addVote(Event event){
        Controller.getInstance().vote(event.getID());
    }

}