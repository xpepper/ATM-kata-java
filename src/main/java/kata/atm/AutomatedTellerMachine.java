package kata.atm;

import java.util.HashMap;

import static kata.atm.Denomination.FIVE_EURO;

public class AutomatedTellerMachine {
    private final HashMap<Denomination, Integer> bills = new HashMap<>();

    public void loadBills(Denomination denomination, int quantity) {
        bills.put(denomination, billsFor(denomination) + quantity);
    }

    public int billsFor(Denomination denomination) {
        return bills.getOrDefault(denomination, 0);
    }

    public Bundle withdraw(int amount) {
        Bundle bundle = new Bundle();
        if (billsFor(FIVE_EURO) > 0) {
            int notesQuantity = amount / FIVE_EURO.value;
            loadBills(FIVE_EURO, -notesQuantity);
            bundle.add(FIVE_EURO, notesQuantity);
        }
        return bundle;
    }
}
