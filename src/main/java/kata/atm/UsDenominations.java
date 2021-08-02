package kata.atm;

import java.util.List;

import static java.util.Arrays.asList;

public class UsDenominations extends Denominations {
    public static final Denomination FIVE_DOLLARS = new Denomination(5);
    public static final Denomination TEN_DOLLARS = new Denomination(10);
    public static final Denomination TWENTY_DOLLARS = new Denomination(20);
    public static final Denomination FIFTY_DOLLARS = new Denomination(50);
    public static final Denomination HUNDRED_DOLLARS = new Denomination(100);

    @Override
    protected List<Denomination> values() {
        return asList(FIVE_DOLLARS, TEN_DOLLARS, TWENTY_DOLLARS, FIFTY_DOLLARS, HUNDRED_DOLLARS);
    }
}
