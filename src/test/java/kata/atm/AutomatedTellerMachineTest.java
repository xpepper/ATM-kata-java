package kata.atm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    public static final int FIVE_EURO = 5;

    @Test
    void initially_has_no_5_euro_banknotes() {
        AutomatedTellerMachine atm = new AutomatedTellerMachine();

        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(0);
    }

    @Test
    void has_one_5_euro_banknote_after_loading_it() {
        AutomatedTellerMachine atm = new AutomatedTellerMachine();
        atm.loadBills(FIVE_EURO, 1);

        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(1);
    }

}
