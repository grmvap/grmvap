package controller;

import enums.CommandType;
import model.Animal;
import model.Tiger;
import service.AnimalCrudService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CommandController {
    private AnimalCrudService animalCrudService; // агрегация

    public CommandController(AnimalCrudService animalCrudService) {
        this.animalCrudService = animalCrudService;
    }

    public void startAplication() {
        while (true) {
            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals(CommandType.CREATE_ANIMAL.getValue())) { //todo перевести все команды на ЭНАМЫ enum!
                animalCrudService.createAnimal();

            } else if (command.equals(CommandType.PRINT_ALL_ANIMALS.getValue())) {
                animalCrudService.printAllAnimals();
            } else if (command.equals(CommandType.DELETE_ANIMAL.getValue())) {

                animalCrudService.deleteAnimal();

            } else if (command.equals(CommandType.RENAME_ANIMAL.getValue())) {
                animalCrudService.renameAnimal();

            }
        }
    }


}






