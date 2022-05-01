import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

public class Roll {

    public final List<Integer> dices;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = List.of(d1, d2, d3, d4, d5);
    }

    public Roll(List<Integer> dices) {
        this.dices = dices;
    }

    @Override
    public String toString() {
        return dices.mkString("{",",","}");
    }

    public Map<Integer, Integer> countOccurrences() {
        return dices.foldLeft(HashMap.empty(), (map, dice) -> {
           return map.put(dice, map.get(dice).getOrElse(0) + 1);
        });
    }
}