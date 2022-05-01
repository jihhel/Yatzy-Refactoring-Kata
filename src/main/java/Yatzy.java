public class Yatzy {

    private static int nbOccurrencesInRoll(Roll h, int value) {
        return h.dices.foldLeft(0, (acc, d) -> d == value ? acc + 1 : acc);
    }

    private static int nbthOfAKind(Roll r, int nbSimilar, int nbGroups) {
        return r.countOccurrences()
                .filter((dice, nbOcc) -> nbOcc >= nbSimilar)
                .keySet()
                .toList()
                .sorted()
                .reverse()
                .take(nbGroups)
                .sum()
                .intValue() * nbSimilar;
    }

    public static int chance(Roll h) {
        return h.dices.reduce(Integer::sum);
    }

    public static int yatzy(Roll r)
    {
        return r.dices.distinct().length() == 1 ? 50 : 0;
    }

    public static int ones(Roll h) {
        return nbOccurrencesInRoll(h, 1) * 1;
    }

    public static int twos(Roll h) {
        return nbOccurrencesInRoll(h, 2) * 2;
    }

    public static int threes(Roll h) {
        return nbOccurrencesInRoll(h, 3) * 3;
    }
    public static int fours(Roll r) {
        return nbOccurrencesInRoll(r, 4) * 4;
    }

    public static int fives(Roll r) {
        return nbOccurrencesInRoll(r, 5) * 5;
    }

    public static int sixes(Roll r) {
        return nbOccurrencesInRoll(r, 6) * 6;
    }

    public static int score_pair(Roll r) {
        return nbthOfAKind(r, 2, 1);
    }

    public static int two_pair(Roll r) {
        return nbthOfAKind(r, 2, 2);
    }

    public static int four_of_a_kind(Roll r) {
        return nbthOfAKind(r, 4, 1);
    }

    public static int three_of_a_kind(Roll r) {
        return nbthOfAKind(r, 3, 1);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



