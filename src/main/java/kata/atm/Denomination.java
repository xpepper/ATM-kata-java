package kata.atm;

import java.util.Arrays;
import java.util.List;

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
        return Arrays.asList(FIFTY_EURO, TWENTY_EURO, TEN_EURO, FIVE_EURO);
    }
}
