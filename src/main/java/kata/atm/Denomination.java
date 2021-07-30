package kata.atm;

public enum Denomination {
    FIVE_EURO(5),
    TEN_EURO(10),
    TWENTY_EURO(20),
    FIFTY_EURO(50);

    public final int value;

    Denomination(int value) {
        this.value = value;
    }
}
