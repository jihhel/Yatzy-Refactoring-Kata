import io.vavr.collection.List;

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

    public static int smallStraight(Roll r)
    {
        List<Integer> sorted = r.dices.sorted();

        if (sorted.last() == 5 && sorted.distinct().length() == 5) {
            return 15;
        } else {
            return 0;
        }
    }

    public static int largeStraight(Roll r)
    {
        List<Integer> sorted = r.dices.sorted();

        if (sorted.head() == 2 && sorted.distinct().length() == 5) {
            return 20;
        } else {
            return 0;
        }
    }

    public static int fullHouse(Roll r) {
        List<Integer> sorted = r.dices.sorted();
        if (sorted.get(0).equals(sorted.get(2)) && sorted.get(3).equals(sorted.get(4))) {
            // triple then double
            return sorted.get(0) * 3 + sorted.get(4) * 2;
        } else if (sorted.get(0).equals(sorted.get(1)) && sorted.get(2).equals(sorted.get(4))) {
            // double then triple
            return sorted.get(0) * 2 + sorted.get(4) * 3;
        } else {
            return 0;
        }
    }
}



