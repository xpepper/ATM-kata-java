package kata.atm;

import org.junit.jupiter.api.Test;

import static kata.atm.Denomination.*;
import static kata.atm.Denomination.TWENTY_EURO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WithdrawalTest {

    @Test
    void has_a_value_based_on_its_banknotes_bundle() {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.add(FIVE_EURO, 1);
        withdrawal.add(TEN_EURO, 1);

        assertThat(withdrawal.value()).isEqualTo(15);
    }

    @Test
    void adding_twice_on_the_same_denomination_increses_the_withdrawal_value() {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.add(TWENTY_EURO, 1);
        withdrawal.add(TWENTY_EURO, 1);

        assertThat(withdrawal.value()).isEqualTo(40);
    }
}