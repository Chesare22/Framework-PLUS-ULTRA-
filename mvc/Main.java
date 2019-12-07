package mvc;

import mvc.controller.Controller;
import mvc.model.Model;

public class Main {
    public static void main(String[] args) {
        if(args.length  == 0){
            System.out.println("No se indicaron los candidatos");
            System.exit(1);
        }
        Model model = new Model(args);
        Controller controller = new Controller(model);
        controller.startApp();
    }
}
