package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            int number = Integer.parseInt(line);
            for (int i = 0; i < number; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
