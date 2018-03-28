package food.diary.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024 * 8];
        try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            int length;
            while ((length = in.read(buffer)) > -1) {
                sb.append(buffer, 0, length);
            }
        }
        return sb.toString();
    }
}
