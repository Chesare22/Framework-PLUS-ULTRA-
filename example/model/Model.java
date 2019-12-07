package example.model;

import config.Event;

import java.util.HashMap;

public class Model{
    //Queda como (candidato, numero de voto)
    private HashMap<String, Integer> votes = new HashMap<>();

    public Model(){
        votes.put("Cesar", 0);
        votes.put("Carlos", 0);
        votes.put("Rico", 0);
    }

    public void addVote(Event event){
        int countVotes = this.votes.get(event.getName());
        this.votes.replace(event.getName(),++countVotes);
        System.out.println("Se voto por " + event.getName());
        System.out.println("this.toString: " + toString());
    }

    // Just for testing purposes
    @Override
    public String toString(){
        return votes.toString();
    }
}