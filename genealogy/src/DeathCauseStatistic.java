import java.util.Arrays;

public class DeathCauseStatistic {
    private final String icd10Code;
    private final int[] deathsByAge;

    private DeathCauseStatistic(String icd10Code, int[] deathsByAge) {
        this.icd10Code = icd10Code;
        this.deathsByAge = deathsByAge;
    }

    public String getIcd10Code() {
        return icd10Code;
    }

    public static DeathCauseStatistic fromCsvLine(String line) {
        String[] parts = line.split(",");
        

        String rawCode = parts[0];
        String icd10 = rawCode.split("\\t")[0].trim();
        

        int[] deaths = new int[parts.length - 2];
        for (int i = 2; i < parts.length; i++) {
            String value = parts[i].trim();
            if (value.equals("-")) {
                deaths[i - 2] = 0;
            } else {
                deaths[i - 2] = Integer.parseInt(value);
            }
        }
        
        return new DeathCauseStatistic(icd10, deaths);
    }

    public AgeBracketDeaths getAgeBracketDeaths(int age) {
        int index;
        if (age >= 95) {
            index = deathsByAge.length - 1;
        } else {
            index = age / 5;
        }

        int young = index * 5;
        int old = (index == deathsByAge.length - 1) ? 150 : young + 4;
        int count = deathsByAge[index];

        return new AgeBracketDeaths(young, old, count);
    }

    public static class AgeBracketDeaths {
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
        
        @Override
        public String toString() {
            return young + "-" + old + ": " + deathCount;
        }
    }
}