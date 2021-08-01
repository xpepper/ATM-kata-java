package kata.atm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kata.atm.Denomination.FIVE_EURO;
import static kata.atm.Denomination.TEN_EURO;

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
        Arrays.asList(TEN_EURO, FIVE_EURO).forEach(denomination -> {
            while (billsFor(denomination) > 0 && withdrawal.value() < amount) {
                withdrawal.add(denomination, 1);
                bundle.add(denomination, -1);
            }
        });
        if (withdrawal.value() < amount)
            throw new IllegalStateException("Not enough money, this ATM needs servicing");

        return withdrawal;
    }
}
