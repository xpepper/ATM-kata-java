package kata.atm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public abstract class Denominations implements Iterable<Denomination> {
    protected abstract List<Denomination> values();

    @Override
    public Iterator<Denomination> iterator() {
        return all().iterator();
    }

    @Override
    public void forEach(Consumer<? super Denomination> action) {
        all().forEach(action);
    }

    @Override
    public Spliterator<Denomination> spliterator() {
        return all().spliterator();
    }

    private List<Denomination> all() {
        return values().stream()
                .sorted(byHighestValueFirst())
                .collect(toList());
    }

    private Comparator<Denomination> byHighestValueFirst() {
        return (denomination, otherDenomination) -> otherDenomination.value - denomination.value;
    }
}
