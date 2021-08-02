package kata.atm;

import java.util.Objects;
import java.util.StringJoiner;

public class Denomination {
    public final int value;

    Denomination(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Denomination)) return false;
        Denomination that = (Denomination) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Denomination.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
