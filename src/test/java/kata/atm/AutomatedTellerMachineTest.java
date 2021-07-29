package kata.atm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    @Test
    void initially_has_no_banknotes() {
        AutomatedTellerMachine atm = new AutomatedTellerMachine();
        assertThat(atm.billsFor(5)).isEqualTo(0);
    }
}
