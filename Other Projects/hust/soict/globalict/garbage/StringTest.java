package Lab01.hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringTest {
    public static void main(String[] args) throws IOException {
        String filename = "text.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
        long startTime , endTime ;
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte b : inputBytes)
            outputString += (char)b;
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
