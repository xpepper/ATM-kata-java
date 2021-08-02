package kata.atm;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Denomination {
    public static final Denomination FIVE_EURO = new Denomination(5);
    public static final Denomination TEN_EURO = new Denomination(10);
    public static final Denomination TWENTY_EURO = new Denomination(20);
    public static final Denomination FIFTY_EURO = new Denomination(50);

    public final int value;

    Denomination(int value) {
        this.value = value;
    }

    public static List<Denomination> all() {
        return Denomination.values().stream()
                .sorted(byHighestValueFirst())
                .collect(toList());
    }

    private static List<Denomination> values() {
        return asList(FIVE_EURO, TEN_EURO, TWENTY_EURO, FIFTY_EURO);
    }

    private static Comparator<Denomination> byHighestValueFirst() {
        return (denomination, otherDenomination) -> otherDenomination.value - denomination.value;
    }
}
