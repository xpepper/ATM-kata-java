package kata.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    public static final int FIVE_EURO = 5;
    private AutomatedTellerMachine atm;

    @BeforeEach
    void setUp() {
        atm = new AutomatedTellerMachine();
    }

    @Test
    void initially_has_no_5_euro_banknotes() {
        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(0);
    }

    @Test
    void has_one_5_euro_banknote_after_loading_it() {
        atm.loadBills(FIVE_EURO, 1);

        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(1);
    }

}
