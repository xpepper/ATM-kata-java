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
        while (billsFor(FIVE_EURO) > 0 && withdrawal.value() < amount) {
            loadBills(FIVE_EURO, -1);
            withdrawal.add(FIVE_EURO, 1);
        }
        if (withdrawal.value() < amount)
            throw new IllegalStateException("Not enough money, this ATM needs servicing");
        return withdrawal;
    }
}
