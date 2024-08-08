import controller.CommandController;
import model.Animal;
import service.AnimalCrudService;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args)  {

        AnimalCrudService animalCrudService = new AnimalCrudService();

        CommandController commandController = new CommandController(animalCrudService);
        commandController.startAplication();



    


}







