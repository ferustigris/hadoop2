package epam.com.hadoop;

public class IPinyouLogParser {
    public LogItem parseLogLine(String line) {
        String fields[] = line.split("\\s+");
        if (fields.length < 3) {
            return new LogItem("");//empty object
        }
        return new LogItem(fields[2]);
    }
}
