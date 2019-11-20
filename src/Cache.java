import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    private int cashSize = 5;
    private LinkedHashMap<String, Integer> cacheMap = new LinkedHashMap<>();

    public void setCashSize(int cashSize) {
        this.cashSize = cashSize;
    }

    public void put(String line){
        if (cacheMap.containsKey(line)) {
            int value = cacheMap.get(line);
            cacheMap.put(line, value + 1);
        } else {

            if (cacheMap.size() >= cashSize) {
                Object firstEntry = cacheMap.keySet().iterator().next();
                cacheMap.remove(firstEntry);
            }
            cacheMap.put(line, 1);
        }
    }

    public void print() {
        for (Map.Entry<String, Integer> entry : cacheMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}