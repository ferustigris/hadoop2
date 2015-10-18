package epam.com.hadoop;

import java.io.FileReader;
import java.io.IOException;
//import org.apache.hadoop.fs.*;
//import org.apache.hadoop.conf.*;
//import org.apache.hadoop.util.*;
//import org.apache.commons.compress.compressors.bzip2.*;
public class App
{
    static private String[] files = {"test.txt"};

    public static void main( String[] args ) throws IOException
    {
        Calculator calc = new Calculator();

        for(String fn: files) {
            IPinyouLogParserIterator parser = new IPinyouLogParserIterator(new FileReader(fn));
            while(parser.hasNext()) {
                calc.calculate(parser.next());
            }
        }
//        Configuration conf = new Configuration();
//        FileSystem fileSystem = FileSystem.get(conf);
    }
}
