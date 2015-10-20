package epam.com.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class App
{
    static private final String HDFS_URL = "hdfs://192.168.56.101";
    static private final String FILES_URL = "/my";

    public static void main( String[] args ) throws IOException
    {

        Configuration conf = new Configuration();
        conf.set("fs.default.name", HDFS_URL);
        
        FileSystem fileSystem = FileSystem.get(conf);
        FileStatus[] files = fileSystem.listStatus(new Path(FILES_URL));

        Calculator calc = new Calculator();
        
        for(FileStatus stat: files) {
            System.out.println(stat.getPath().getName() + " is processed");
            FSDataInputStream in = fileSystem.open(stat.getPath());
            IPinyouLogParserIterator parser = new IPinyouLogParserIterator(new InputStreamReader(in));
            while(parser.hasNext()) {
                calc.calculate(parser.next());
            }
        }

        // results output
        FSDataOutputStream out = fileSystem.create(new Path(FILES_URL + "/../results.txt"));
        Map<String, Long> results = calc.getResults();
        for(String key: results.keySet()) {
            System.out.println(key + " - " + results.get(key));
            out.writeUTF(key + " " + results.get(key) + "\n");
        }
    }
}
