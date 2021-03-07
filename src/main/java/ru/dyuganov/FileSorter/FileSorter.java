package main.java.ru.dyuganov.FileSorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FileSorter {
    public final void sort(final String folderPath) throws IOException {
        final File sortingFolder = new File(folderPath);
        final int stringLengthLimit = 10;
        for(final File fileInFolder : Objects.requireNonNull(sortingFolder.listFiles())){
            if(fileInFolder.isDirectory()){
                continue;
            }
            Path filePath = Paths.get(fileInFolder.getPath());
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            String[] date = attributes.lastModifiedTime().toString().substring(0, stringLengthLimit).split("-");
            String creationDate = date[0] + "." + date[1] + "." + date[2];
            String pathFolderWithDateName = folderPath + "/" + creationDate;
            final File newFolder = new File(pathFolderWithDateName);

            boolean newDirCreated = newFolder.mkdir();
            if(newDirCreated || newFolder.exists()){
                final Path newFilePath = Paths.get(pathFolderWithDateName + "/" + filePath.getFileName());
                Files.move(filePath, newFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
            else{
                System.err.println("Can't create directory and move file " + filePath);
            }
        }
    }
}
