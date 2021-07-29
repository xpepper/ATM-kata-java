package kata.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    public static final int FIVE_EURO = 5;
    public static final int TEN_EURO = 10;
    public static final int TWENTY_EURO = 20;
    public static final int FIFTY_EURO = 50;

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

    @Test
    void initially_has_no_banknotes() {
        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(TEN_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(TWENTY_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(FIFTY_EURO)).isEqualTo(0);
    }

    @Test
    void has_one_banknote_for_each_denomination_after_loading_it() {
        atm.loadBills(FIVE_EURO, 1);
        atm.loadBills(TEN_EURO, 1);
        atm.loadBills(TWENTY_EURO, 1);
        atm.loadBills(FIFTY_EURO, 1);

        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(TEN_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(TWENTY_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(FIFTY_EURO)).isEqualTo(1);
    }

}
