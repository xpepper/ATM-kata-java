package kata.atm;

public class AutomatedTellerMachine {
    private final Bundle bundle;
    private final Denominations denominations;

    public AutomatedTellerMachine(Denominations denominations) {
        this.denominations = denominations;
        bundle = new Bundle(denominations);
    }

    public void loadBills(Denomination denomination, int quantity) {
        bundle.add(denomination, quantity);
    }

    public int billsFor(Denomination denomination) {
        return bundle.banknotesAmountFor(denomination);
    }

    public Bundle withdraw(int amount) {
        Bundle withdrawal = new Bundle(denominations);
        int reminder = amount;
        for (Denomination denomination : denominations.all()) {
            while (hasBillsFor(denomination) && withdrawal.lessThen(amount) && reminder >= denomination.value) {
                reminder -= denomination.value;
                withdrawal.add(denomination, 1);
                bundle.remove(denomination, 1);
            }
        }
        if (withdrawal.lessThen(amount)) {
            bundle.restoreFrom(withdrawal);
            throw new IllegalStateException("Not enough money, this ATM needs servicing");
        }

        return withdrawal;
    }

    private boolean hasBillsFor(Denomination denomination) {
        return billsFor(denomination) > 0;
    }

}
