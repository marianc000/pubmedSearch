/*
 */
package food.diary.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caikovsk
 */
public class FileUtilsTest {

    FileUtils i = new FileUtils();

    @Test
    public void testInputStreamToStringFromResourceFile() throws IOException {
        String resp = i.inputStreamToString(getClass().getResourceAsStream("/output.xml"));
        System.out.println(resp.length());// 358,830
        assertTrue(resp.length()>0);
    }

    @Test
    public void testInputStreamToStringFromString() throws IOException {
        System.out.println(Charset.defaultCharset()); // windows-1252
        String str = "this is a test string to be converted to InputStream";
        String copy = i.inputStreamToString(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
        assertEquals(str.length(), copy.length());
    }
}
