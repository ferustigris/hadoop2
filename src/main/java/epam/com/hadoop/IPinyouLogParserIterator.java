package epam.com.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class IPinyouLogParserIterator implements Iterator<LogItem> {
    private BufferedReader reader;
    private String nextLine = "";
    private IPinyouLogParser parser = new IPinyouLogParser();

    public IPinyouLogParserIterator(Reader fileReader) {
        reader = new BufferedReader(fileReader);
    }

    public boolean hasNext() {
        try {
            nextLine = reader.readLine();
        } catch (IOException e) {
            return false;
        }
        return nextLine.length() > 0;
    }

    public LogItem next() {
        return parser.parseLogLine(nextLine);
    }

    public void remove() {}
}
