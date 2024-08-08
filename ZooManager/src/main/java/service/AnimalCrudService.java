package service;

import model.Animal;
import model.Penguin;
import model.Tiger;
import model.Wolf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalCrudService {
    private final FileService fileService = new FileService(); // композиця

    public void printText() {

        String text = "Введите животное, которое хотите создать";
        System.out.println(text);


    }

    public void printText1() {
        String text2 = "Введите характеристики животного:\n" + "имя\n" + "количество ног\n" + "хищность\n" + "цвет\n" + "среду обитания";
        System.out.println(text2);

    }


    public void createAnimal() {

        printText();

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        printText1();
        String name = scanner.nextLine();
        int legs = Integer.parseInt(scanner.nextLine());
        Boolean predator = Boolean.parseBoolean(scanner.nextLine());
        String color = scanner.nextLine();
        String location = scanner.nextLine();
        List<Animal> listAnimals = new ArrayList<>();
        //todo написать код создания всех животных
        switch (word) {

            case "Тигр":

                Animal tiger = new Tiger(name, legs, predator, color, location);

                System.out.println(tiger);


                listAnimals.add(tiger);
                fileService.writeAnimalToFile(tiger);

                System.out.println(listAnimals);
                break;

            case "Волк":


                Animal wolf = new Wolf(name, legs, predator, color, location);

                System.out.println(wolf);


                listAnimals.add(wolf);
                fileService.writeAnimalToFile(wolf);

                System.out.println(listAnimals);
                break;
            case "Пингвин":


                Animal penguin = new Penguin(name, legs, predator, color, location);

                System.out.println(penguin);


                listAnimals.add(penguin);
                fileService.writeAnimalToFile(penguin);

                System.out.println(listAnimals);
                break;
        }


    }

    public void printAllAnimals() {
        fileService.printAll();
    }

    public void deleteAnimal() {
        System.out.println("Какое животное хотите удалить?");
        Scanner scanner = new Scanner(System.in);

        String lineToRemove = scanner.nextLine();
        fileService.deleteAnimal(lineToRemove);
    }

    public void renameAnimal() {

        System.out.println("Какое животное хотите переименовать?");
        Scanner scanner = new Scanner(System.in);
        String lineToRemove = scanner.nextLine();
        String newName = scanner.nextLine();
        fileService.renameAnimal(lineToRemove, newName);


    }


}
