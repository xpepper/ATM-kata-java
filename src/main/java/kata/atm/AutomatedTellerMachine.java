package kata.atm;

import java.util.HashMap;
import java.util.Map;

import static kata.atm.Denomination.*;

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
        bundle.put(FIVE_EURO, amount / FIVE_EURO.value);
        return bundle;
    }
}
