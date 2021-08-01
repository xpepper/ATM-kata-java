package kata.atm;

import static kata.atm.Denomination.FIVE_EURO;

public class AutomatedTellerMachine {
    private final Bundle bundle = new Bundle();

    public void loadBills(Denomination denomination, int quantity) {
        bundle.add(denomination, quantity);
    }

    public int billsFor(Denomination denomination) {
        return bundle.banknotesAmountFor(denomination);
    }

    public Bundle withdraw(int amount) {
        Bundle withdrawal = new Bundle();
        while (billsFor(FIVE_EURO) > 0 && withdrawal.value() < amount) {
            withdrawal.add(FIVE_EURO, 1);
            bundle.add(FIVE_EURO, -1);
        }
        if (withdrawal.value() < amount)
            throw new IllegalStateException("Not enough money, this ATM needs servicing");

        return withdrawal;
    }
}
