package kata.atm;

import java.util.HashMap;

public class Bundle {
    private final HashMap<Denomination, Integer> bundle = new HashMap<>();
    private final Denominations denominations;

    public Bundle(Denominations denominations) {
        this.denominations = denominations;
    }

    public Integer banknotesAmountFor(Denomination denomination) {
        return bundle.getOrDefault(denomination, 0);
    }

    public void add(Denomination denomination, int quantity) {
        bundle.put(denomination, banknotesAmountFor(denomination) + quantity);
    }

    public void remove(Denomination denomination, int quantity) {
        add(denomination, -quantity);
    }

    public void restoreFrom(Bundle bundle) {
        for (Denomination denomination : denominations.all()) {
            add(denomination, bundle.banknotesAmountFor(denomination));
        }
    }

    public boolean lessThen(int amount) {
        return value() < amount;
    }

    @SuppressWarnings("Convert2MethodRef")
    int value() {
        return bundle.keySet().stream()
                .mapToInt(denomination -> valueFor(denomination))
                .sum();
    }

    private int valueFor(Denomination denomination) {
        return banknotesAmountFor(denomination) * denomination.value;
    }
}
