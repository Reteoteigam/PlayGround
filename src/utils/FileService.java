package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

  private static Path temporary;
  private static Path save;
  private static Path input;
  private static Path output;

  public static Path getTemporary() {
    return temporary;
  }

  public static Path getSave() {
    return save;
  }

  public static Path getInput() {
    return input;
  }

  public static Path getOutput() {
    return output;
  }

  public static void initialze() {

    temporary = createDir("tmp");
    save = createDir("target/save");
    input = createDir("input");
    output = createDir("output");

  }

  private static Path createDir(String first) {
    Path dir = Paths.get(first);
    try {
      Files.createDirectories(dir);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return dir;
  }

  public static Path createIfNotExistsFile(Path dir, String fileName) {
    Path path = Paths.get(dir.toString(), fileName);
    if (!Files.exists(path)) {
      try {
        Files.createFile(path);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return path;
  }

}
