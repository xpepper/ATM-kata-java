package kata.atm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DenominationTest {

    @Test
    void equality() {
        assertThat(new Denomination(5)).isEqualTo(new Denomination(5));
        assertThat(new Denomination(10)).isNotEqualTo(new Denomination(5));
    }
}