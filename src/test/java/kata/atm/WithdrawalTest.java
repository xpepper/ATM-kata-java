package kata.atm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WithdrawalTest {

    @Test
    void has_a_value_based_on_its_banknotes_bundle() {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.add(Denomination.FIVE_EURO, 1);
        withdrawal.add(Denomination.TEN_EURO, 1);

        assertThat(withdrawal.value()).isEqualTo(15);
    }
}