package kata.atm;

import java.util.HashMap;

public class Bundle {
    HashMap<Denomination, Integer> bundle = new HashMap<>();

    public Integer banknotesAmountFor(Denomination denomination) {
        return bundle.getOrDefault(denomination, 0);
    }

    public void add(Denomination denomination, int quantity) {
        bundle.put(denomination, quantity);
    }
}
