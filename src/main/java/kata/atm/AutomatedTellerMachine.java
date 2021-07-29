package kata.atm;

import java.util.HashMap;

public class AutomatedTellerMachine {
    private final HashMap<Integer, Integer> bills = new HashMap<>();

    public int billsFor(int denomination) {
        return bills.getOrDefault(denomination, 0);
    }

    public void loadBills(int denomination, int quantity) {
        bills.put(denomination, quantity);
    }
}
