package config;

public class Event{
    private String name;
    private int votes;
    
    public Event(String name, int votes){
        this.name = name;
        this.votes = votes;
    }

    public String getName(){
        return this.name;
    }

    //Que yo recuerde todo lo debe almacenar como String 
    //pero eso mañana se le pregunta a garci
    public int getVotes(){
        return this.votes;
    }

}