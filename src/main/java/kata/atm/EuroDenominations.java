package kata.atm;

import java.util.List;

import static java.util.Arrays.asList;

public class EuroDenominations extends Denominations {
    public static final Denomination FIVE_EURO = new Denomination(5);
    public static final Denomination TEN_EURO = new Denomination(10);
    public static final Denomination TWENTY_EURO = new Denomination(20);
    public static final Denomination FIFTY_EURO = new Denomination(50);

    @Override
    protected List<Denomination> values() {
        return asList(FIVE_EURO, TEN_EURO, TWENTY_EURO, FIFTY_EURO);
    }
}
