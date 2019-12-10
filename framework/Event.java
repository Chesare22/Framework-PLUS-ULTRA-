package framework;

import com.sun.source.tree.ReturnTree;

public class Event{
    private String name;
    private int votes;
    private int ID;
    
    public Event(String name, int votes){
        this.name = name;
        this.votes = votes;
    }

    public Event(int ID, int votes){
        this.ID = ID;
        this.votes = votes;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    //Que yo recuerde todo lo debe almacenar como String 
    //pero eso mañana se le pregunta a garci
    public int getVotes(){
        return this.votes;
    }

}