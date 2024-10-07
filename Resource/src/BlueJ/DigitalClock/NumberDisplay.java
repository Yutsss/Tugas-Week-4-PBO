public class NumberDisplay {
  private int limit;
  private int value;

  public NumberDisplay(int limit) {
    this.limit = limit;
    this.value = 0;
  }

  public int getValue() {
    return value;
  }

  public String getDisplayValue() {
    if (value < 10) {
      return "0" + value; // Menambahkan nol di depan angka jika kurang dari 10
    } else {
      return "" + value;
    }
  }

  public void increment() {
    value = (value + 1) % limit;
  }

  public void setValue(int newValue) {
    if (newValue >= 0 && newValue < limit) {
      value = newValue;
    }
  }
}
