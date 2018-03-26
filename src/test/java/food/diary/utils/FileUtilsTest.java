/*
 */
package food.diary.utils;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caikovsk
 */
public class FileUtilsTest {

    FileUtils i = new FileUtils();

    @Test
    public void testInputStreamToString() throws IOException {
        String resp = i.inputStreamToString( getClass().getResourceAsStream("/output.xml"));
        System.out.println(resp.length());
        assertTrue(resp.length() > 0);
    }
}
