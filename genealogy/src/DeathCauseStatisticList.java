import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DeathCauseStatisticList {
    private List<DeathCauseStatistic> statistics = new ArrayList<>();

    public void repopulate(String path) throws IOException {
        statistics.clear();
        List<String> lines = Files.readAllLines(Paths.get(path));
        

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (!line.isEmpty()) {
                statistics.add(DeathCauseStatistic.fromCsvLine(line));
            }
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
        return statistics.stream()
                .filter(s -> !s.getIcd10Code().equals("OGÓŁEM"))
                .sorted((s1, s2) -> {
                    int d1 = s1.getAgeBracketDeaths(age).deathCount;
                    int d2 = s2.getAgeBracketDeaths(age).deathCount;
                    return Integer.compare(d2, d1); // Malejaco
                })
                .limit(n)
                .collect(Collectors.toList());
    }
}