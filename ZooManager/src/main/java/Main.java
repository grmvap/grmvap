import controller.CommandController;
import model.Animal;
import service.AnimalCrudService;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args)  {


        /*Wolf wolf = new Wolf("Волк", 4, true,"Серый", "Сибирь");
        Tiger tiger = new Tiger("Тигр", 4,true, "Желиый", "Африка");
        testPolimorf(tiger);
        testPolimorf(wolf);
        List <Animal> list = new ArrayList<>();
        list.add(tiger);
        list.add(wolf);
        for (int i = 0; i < list.size(); i++) {
           testPolimorf(list.get(i));
        }*/

        //System.out.println("Введите: 'создать тигра'");

        AnimalCrudService animalCrudService = new AnimalCrudService();

        CommandController commandController = new CommandController(animalCrudService);
        commandController.startAplication();



    }

    public static void testPolimorf(Animal animal) {
        System.out.println(animal.toString());
    }


}







