package framework;

import framework.example.controller.Controller;
import framework.example.model.Model;

public class Main {
    public static void main(String[] args) {
        /*if(args.length  == 0){
            System.out.println("No se indicaron los candidatos");
            System.exit(1);
        }*/

        //Im not supossed to move this class from anything

        String[] arguments = {"Carlos", "Rico", "Cesar", "Diego"};
        Model model = new Model(arguments);
        Controller controller = new Controller(model);
        controller.startApp();
    }
}
