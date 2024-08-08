package service;

import model.Animal;
import model.Tiger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private final File file;


    {
        file = new File("C:\\Users\\555\\Desktop\\JR_Projects\\Study1\\ZooManager\\animals.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void writeAnimalToFile(Animal animal) {

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(animal.toString() + "\n");

            fileWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void printAll() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {


            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(file.getPath());
        }


    }

    private void writeAndResaveFile(File tempFile, List<String> lines, File inputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удаляем оригинальный файл
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
            return;
        }

        // Переименовываем временный файл в оригинальное имя
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }

    }

    public void deleteAnimal(String lineToRemove) {
        File inputFile = new File(String.valueOf(file));
        File tempFile = new File("tempAnimals.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Сохраняем все строки, кроме той, которую нужно удалить
                if (!currentLine.contains(lineToRemove)) {
                    // Удаляем имя животного из строки


                    lines.add(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeAndResaveFile(tempFile, lines, inputFile);
    }

    public void renameAnimal(String lineToRemove, String newName) {
        File inputFile = new File(String.valueOf(file));
        File tempFile = new File("tempAnimals.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Сохраняем все строки, кроме той, которую нужно удалить
                if (currentLine.contains(lineToRemove)) {
                    currentLine = currentLine.replace(lineToRemove, newName);
                }


                lines.add(currentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        writeAndResaveFile(tempFile, lines, inputFile);

    }
}

