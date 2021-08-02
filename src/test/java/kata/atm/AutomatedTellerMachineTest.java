package kata.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static kata.atm.EuroDenominations.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutomatedTellerMachineTest {

    private AutomatedTellerMachine atm;

    @BeforeEach
    void setUp() {
        atm = new AutomatedTellerMachine(new EuroDenominations());
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

    @Test
    void loads_bills_keeping_track_of_the_already_existing_bills() {
        atm.loadBills(FIVE_EURO, 1);
        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(1);

        atm.loadBills(FIVE_EURO, 2);
        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(1 + 2);
    }

    @Test
    void offers_cash_withdrawal_with_a_bundle_of_just_five_euros() {
        atm.loadBills(FIVE_EURO, 2);

        Bundle withdraw = atm.withdraw(10);

        assertThat(withdraw.banknotesAmountFor(FIVE_EURO)).isEqualTo(2);
        assertThat(withdraw.value()).isEqualTo(10);
        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(0);
    }

    @Test
    void raises_an_error_condition_if_the_notes_are_not_enough_to_complete_the_withdrawal() {
        atm.loadBills(FIVE_EURO, 2);

        assertThatThrownBy(() -> atm.withdraw(15))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Not enough money, this ATM needs servicing");
    }

    @Test
    void gives_priority_to_the_higher_value_denominations_first_before_using_the_smaller_denominations() {
        atm.loadBills(FIVE_EURO, 2);
        atm.loadBills(TEN_EURO, 2);
        atm.loadBills(TWENTY_EURO, 2);
        atm.loadBills(FIFTY_EURO, 2);

        Bundle withdraw = atm.withdraw(85);

        assertThat(withdraw.value()).isEqualTo(85);
        assertThat(withdraw.banknotesAmountFor(FIFTY_EURO)).isEqualTo(1);
        assertThat(withdraw.banknotesAmountFor(TWENTY_EURO)).isEqualTo(1);
        assertThat(withdraw.banknotesAmountFor(TEN_EURO)).isEqualTo(1);
        assertThat(withdraw.banknotesAmountFor(FIVE_EURO)).isEqualTo(1);
    }

    @Test
    void is_left_as_it_was_before_when_withdrawal_fails_for_an_odd_amount() {
        atm.loadBills(FIVE_EURO, 3);

        assertThatThrownBy(() -> atm.withdraw(11))
                .isInstanceOf(IllegalStateException.class);

        assertThat(atm.billsFor(FIVE_EURO)).isEqualTo(3);
    }

}
