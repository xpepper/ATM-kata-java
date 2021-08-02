package kata.atm;

import java.util.List;

public class EuroDenominations extends Denominations {
    @Override
    public List<Denomination> all() {
        return Denomination.all();
    }
}
