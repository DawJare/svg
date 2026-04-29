import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DeathCauseStatisticList list = new DeathCauseStatisticList();
            list.repopulate("zgony.csv");

            int testAge = 45;
            System.out.println("Najczestsze przyczyny zgonow dla wieku " + testAge + ":");
            List<DeathCauseStatistic> top = list.mostDeadlyDiseases(testAge, 5);
            for (DeathCauseStatistic s : top) {
                System.out.println(s.getIcd10Code() + " -> " + s.getAgeBracketDeaths(testAge));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}