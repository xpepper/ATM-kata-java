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

    public Withdrawal withdraw(int amount) {
        Withdrawal withdrawal = new Withdrawal();
        if (billsFor(FIVE_EURO) > 0) {
            int notesQuantity = amount / FIVE_EURO.value;
            loadBills(FIVE_EURO, -notesQuantity);
            withdrawal.add(FIVE_EURO, notesQuantity);
        }
        return withdrawal;
    }
}
