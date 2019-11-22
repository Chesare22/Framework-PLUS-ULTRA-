package model;

import java.util.HashMap;

public class Model{
    //Queda como (candidato, numero de voto)
    private HashMap<String, Integer> votes = new HashMap<>();

    public Model(){
        votes.put("Cesar", 0);
        votes.put("Carlos", 0);
        votes.put("Rico", 0);
    }

    public void add_Vote(Object name){
        int countVotes = this.votes.get((String)name);
        this.votes.replace((String)name,++countVotes);
    }

    // Just for testing purposes
    @Override
    public String toString(){
        return votes.toString();
    }
}