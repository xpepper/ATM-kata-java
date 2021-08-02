package kata.atm;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class UsDenominations extends Denominations {
    public static final Denomination FIVE_DOLLARS = new Denomination(5);
    public static final Denomination TEN_DOLLARS = new Denomination(10);
    public static final Denomination TWENTY_DOLLARS = new Denomination(20);
    public static final Denomination FIFTY_DOLLARS = new Denomination(50);
    public static final Denomination HUNDRED_DOLLARS = new Denomination(100);

    private static final List<Denomination> DENOMINATIONS = asList(
            FIVE_DOLLARS,
            TEN_DOLLARS,
            TWENTY_DOLLARS,
            FIFTY_DOLLARS,
            HUNDRED_DOLLARS);

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
