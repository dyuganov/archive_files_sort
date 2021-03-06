package main.java.ru.dyuganov;

import main.java.ru.dyuganov.FileSorter.FileSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            FileSorter fileSorter = new FileSorter();
            String path;

            System.out.println("Enter folder to sort path:");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                path = reader.readLine();
                fileSorter.sort(path);
            }
        }
        catch (RuntimeException e){
            e.printStackTrace(System.err);
        }
    }
}
