package epam.com.hadoop;

import java.util.Map;
import java.util.TreeMap;

public class Calculator {
    private Map<String, Long> results = new TreeMap<String, Long>();

    public void calculate(LogItem item) {
        Long count = Long.valueOf(1);
        if (results.containsKey(item.getiPinyouID())) {
            count = results.get(item.getiPinyouID()) + 1;
        }
        results.put(item.getiPinyouID(), count);
    }

    public Map<String, Long> getResults() {
        return results;
    }
}
