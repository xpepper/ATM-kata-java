package kata.atm;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public enum Denomination {
    FIVE_EURO(5),
    TEN_EURO(10),
    TWENTY_EURO(20),
    FIFTY_EURO(50);

    public final int value;

    Denomination(int value) {
        this.value = value;
    }

    public static List<Denomination> all() {
        return stream(Denomination.values())
                .sorted(byHighestValueFirst())
                .collect(toList());
    }

    private static Comparator<Denomination> byHighestValueFirst() {
        return (denomination, otherDenomination) -> otherDenomination.value - denomination.value;
    }
}
