package kata.atm;

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
        int reminder = amount;
        for (Denomination denomination : Denomination.all()) {
            while (billsFor(denomination) > 0 && withdrawal.value() < amount && reminder >= denomination.value) {
                reminder -= denomination.value;
                withdrawal.add(denomination, 1);
                bundle.add(denomination, -1);
            }
        }
        if (withdrawal.value() < amount)
            throw new IllegalStateException("Not enough money, this ATM needs servicing");

        return withdrawal;
    }

}
