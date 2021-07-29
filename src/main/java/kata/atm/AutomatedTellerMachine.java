package kata.atm;

import java.util.HashMap;

public class AutomatedTellerMachine {
    private final HashMap<Denomination, Integer> bills = new HashMap<>();

    public void loadBills(Denomination denomination, int quantity) {
        bills.put(denomination, quantity);
    }

    public int billsFor(Denomination denomination) {
        return bills.getOrDefault(denomination, 0);
    }
}
