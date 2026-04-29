import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {
    private Map<String, String> cache = new HashMap<>();

    public ICDCodeTabularOptimizedForTime(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (int i = 87; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.matches("^[A-Z][0-9]{2}.*")) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    cache.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    @Override
    public String getDescription(String code) {
        if (!cache.containsKey(code)) {
            throw new IndexOutOfBoundsException("Kod " + code + " nie istnieje.");
        }
        return cache.get(code);
    }
}