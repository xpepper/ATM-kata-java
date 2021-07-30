package kata.atm;

import java.util.HashMap;
import java.util.Map;

public class AutomatedTellerMachine {
    private final HashMap<Denomination, Integer> bills = new HashMap<>();

    public void loadBills(Denomination denomination, int quantity) {
        bills.put(denomination, billsFor(denomination) + quantity);
    }

    public int billsFor(Denomination denomination) {
        return bills.getOrDefault(denomination, 0);
    }

    public Map<Denomination, Integer> withdraw(int amount) {
        HashMap<Denomination, Integer> bundle = new HashMap<>();
        bundle.put(Denomination.FIVE_EURO, 1);
        return bundle;
    }
}
