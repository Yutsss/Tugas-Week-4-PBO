public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;

    public ClockDisplay() {
        hours = new NumberDisplay(24);  // Jam dalam format 24 jam
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
    }

    public ClockDisplay(int hour, int minute, int second) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute, second);
    }

    public void timeTick() {
        seconds.increment(); // Tambah detik
        if (seconds.getValue() == 0) {
            minutes.increment();  // Tambah menit jika detik kembali ke 0
            if (minutes.getValue() == 0) {
                hours.increment();  // Tambah jam jika menit kembali ke 0
            }
        }
    }

    public String getTime() {
        return hours.getDisplayValue() + ":" + minutes.getDisplayValue() + ":" + seconds.getDisplayValue();
    }

    public void setTime(int hour, int minute, int second) {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
    }
}
