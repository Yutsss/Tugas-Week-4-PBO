public class ClockDisplay {
  private NumberDisplay hours;
  private NumberDisplay minutes;

  public ClockDisplay() {
    hours = new NumberDisplay(24); // Jam dalam format 24 jam
    minutes = new NumberDisplay(60);
  }

  public ClockDisplay(int hour, int minute) {
    hours = new NumberDisplay(24);
    minutes = new NumberDisplay(60);
    setTime(hour, minute);
  }

  public void timeTick() {
    minutes.increment();
    if (minutes.getValue() == 0) { // Jika menit kembali ke 0, jam bertambah
      hours.increment();
    }
  }

  public String getTime() {
    return hours.getDisplayValue() + ":" + minutes.getDisplayValue();
  }

  public void setTime(int hour, int minute) {
    hours.setValue(hour);
    minutes.setValue(minute);
  }
}
