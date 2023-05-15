package Lab01.hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringBufferTest {
    public static void main(String[] args) throws IOException {
        String filename = "text.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
        long startTime , endTime ;
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for(byte b : inputBytes)
            outputStringBuilder.append((char)b);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
