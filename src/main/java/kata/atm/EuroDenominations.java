package kata.atm;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class EuroDenominations extends Denominations {
    public static final Denomination FIVE_EURO = new Denomination(5);
    public static final Denomination TEN_EURO = new Denomination(10);
    public static final Denomination TWENTY_EURO = new Denomination(20);
    public static final Denomination FIFTY_EURO = new Denomination(50);

    private static final List<Denomination> DENOMINATIONS = asList(FIVE_EURO, TEN_EURO, TWENTY_EURO, FIFTY_EURO);

    @Override
    public List<Denomination> all() {
        return DENOMINATIONS.stream()
                .sorted(byHighestValueFirst())
                .collect(toList());
    }

    private Comparator<Denomination> byHighestValueFirst() {
        return (denomination, otherDenomination) -> otherDenomination.value - denomination.value;
    }
}
