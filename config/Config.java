package config;

public class Config {
    private static final Config INSTANCE = new Config();

    private Config(){

    }

    public static Config getInstance(){
        return INSTANCE;
    }
}