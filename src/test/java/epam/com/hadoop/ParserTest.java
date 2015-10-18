package epam.com.hadoop;

import junit.framework.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParserTest extends Assert
{
    @Test
    public void parseOneLineTest() {
        IPinyouLogParser parser = new IPinyouLogParser();
        LogItem item = parser.parseLogLine("b382c1c156dcbbd5b9317cb50f6a747b        20130606000104008       Vh16OwT6OQNUXbj mozilla/4.0 (compatible; msie 6.0; windows nt 5.1; sv1; qqdownload 718) 180.127.189.*   80      87      1       tFKETuqyMo1mjMp45SqfNX  249b2c34247d400ef1cd3c6bfda4f12a                mm_11402872_1272384_3182279     300     250     1       1       0       00fccc64a1ee2809348509b7ac2a97a5        227     3427    null");
        assertEquals("Vh16OwT6OQNUXbj", item.getiPinyouID());
    }

    @Test
    public void parseFromFileTest() throws FileNotFoundException {
        IPinyouLogParserIterator parser = new IPinyouLogParserIterator(new FileReader("test.txt"));
        assertTrue(parser.hasNext());
        assertEquals("Vh16OwT6OQNUXbj", parser.next().getiPinyouID());
        assertTrue(parser.hasNext());
        assertEquals("Vhkr1vpROHuhQWB", parser.next().getiPinyouID());
        assertTrue(parser.hasNext());
        assertEquals("VhKdLnuY3tlhXMa", parser.next().getiPinyouID());
    }
}
