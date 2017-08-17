package br.com.dnsouza.java8inaction.files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExplorer {

    private final static String FULL_PATH_DIR = "C:\\Desenvolvimento\\edigmar\\";

    public static boolean checkValidfile(final Path path) {
        return path.toFile().isFile() && path.toString().contains("BILEC");
    }

    public static void main(final String[] args) throws IOException {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(FULL_PATH_DIR),
                        PathExplorer::checkValidfile)) {
            for (Path entry : stream) {
                moveFile(entry);
            }
        } ;

    }

    public static void moveFile(final Path path) {
        System.out.println("Path moved: " + path.toString());
    }

    private PathExplorer() {
        throw new IllegalAccessError("Code for learning purposes");
    }

}
