import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {
    private final String filePath;

    public ICDCodeTabularOptimizedForMemory(String path) {
        this.filePath = path;
    }

    @Override
    public String getDescription(String code) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if (lineNum < 88) continue;
                
                line = line.trim();

                if (line.startsWith(code) && line.length() > code.length() && line.charAt(code.length()) == ' ') {
                    return line.substring(code.length()).trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IndexOutOfBoundsException("Nie znaleziono opisu dla kodu: " + code);
    }
}