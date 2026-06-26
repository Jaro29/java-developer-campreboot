package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class AiTask05 {
    public static void main(String[] args) {

    }
    public static void projectStructureCreator(String projectName){
        Path projectPath = Path.of(projectName);
        try {
            Files.createDirectory(projectPath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static String getProjectName(Scanner scanner){


        return "";
    }
}
