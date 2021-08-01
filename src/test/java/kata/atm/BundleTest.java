package kata.atm;

import org.junit.jupiter.api.Test;

import static kata.atm.Denomination.*;
import static kata.atm.Denomination.TWENTY_EURO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BundleTest {

    @Test
    void has_a_value_based_on_its_banknotes_bundle() {
        Bundle bundle = new Bundle();
        bundle.add(FIVE_EURO, 1);
        bundle.add(TEN_EURO, 1);

        assertThat(bundle.value()).isEqualTo(15);
    }

    @Test
    void adding_twice_on_the_same_denomination_increases_the_withdrawal_value() {
        Bundle bundle = new Bundle();
        bundle.add(TWENTY_EURO, 1);
        bundle.add(TWENTY_EURO, 1);

        assertThat(bundle.value()).isEqualTo(40);
    }
}