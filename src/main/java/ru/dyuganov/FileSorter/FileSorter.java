package main.java.ru.dyuganov.FileSorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FileSorter {
    public final void sort(final File folder) throws IOException {
        if (folder == null) {
            throw new IllegalArgumentException("FileSorter got folder == null.");
        }
        for(final File fileEntry : Objects.requireNonNull(folder.listFiles())){
            if(fileEntry.isDirectory()){
                continue;
            }
            Path path = Paths.get(fileEntry.getPath());
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Creation date: " + attributes.creationTime());
        }
    }
}
