package kata.atm;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class Denominations {
    protected abstract List<Denomination> values();

    public List<Denomination> all() {
        return values().stream()
                .sorted(byHighestValueFirst())
                .collect(toList());
    }

    private Comparator<Denomination> byHighestValueFirst() {
        return (denomination, otherDenomination) -> otherDenomination.value - denomination.value;
    }
}
