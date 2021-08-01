package kata.atm;

import java.util.HashMap;

public class Withdrawal {
    HashMap<Denomination, Integer> bundle = new HashMap<>();

    public Integer banknotesAmountFor(Denomination denomination) {
        return bundle.getOrDefault(denomination, 0);
    }

    public void add(Denomination denomination, int quantity) {
        bundle.put(denomination, banknotesAmountFor(denomination) + quantity);
    }

    @SuppressWarnings("Convert2MethodRef")
    public int value() {
        return bundle.keySet().stream()
                .mapToInt(denomination -> valueFor(denomination))
                .sum();
    }

    private int valueFor(Denomination denomination) {
        return banknotesAmountFor(denomination) * denomination.value;
    }
}
