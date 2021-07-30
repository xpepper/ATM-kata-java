package kata.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    private AutomatedTellerMachine atm;

    @BeforeEach
    void setUp() {
        atm = new AutomatedTellerMachine();
    }

    @Test
    void initially_has_no_banknotes() {
        assertThat(atm.billsFor(Denomination.FIVE_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(Denomination.TEN_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(Denomination.TWENTY_EURO)).isEqualTo(0);
        assertThat(atm.billsFor(Denomination.FIFTY_EURO)).isEqualTo(0);
    }

    @Test
    void has_one_banknote_for_each_denomination_after_loading_it() {
        atm.loadBills(Denomination.FIVE_EURO, 1);
        atm.loadBills(Denomination.TEN_EURO, 1);
        atm.loadBills(Denomination.TWENTY_EURO, 1);
        atm.loadBills(Denomination.FIFTY_EURO, 1);

        assertThat(atm.billsFor(Denomination.FIVE_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(Denomination.TEN_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(Denomination.TWENTY_EURO)).isEqualTo(1);
        assertThat(atm.billsFor(Denomination.FIFTY_EURO)).isEqualTo(1);
    }

}
