import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockMain extends JFrame {
    private ClockDisplay clock;
    private JLabel timeLabel;

    public ClockMain() {
        // Inisialisasi frame dan clock
        clock = new ClockDisplay();
        timeLabel = new JLabel(clock.getTime(), JLabel.CENTER);

        // Mengatur tampilan frame
        setTitle("Clock Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set font agar lebih besar dan lebih jelas
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 32));

        // Menambahkan label ke frame
        add(timeLabel, BorderLayout.CENTER);

        // Membuat timer untuk mengupdate waktu setiap 1 detik
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.timeTick(); // Menambah 1 menit
                timeLabel.setText(clock.getTime()); // Update tampilan jam
            }
        });

        timer.start(); // Mulai timer
    }

    public static void main(String[] args) {
        // Menjalankan GUI pada thread terpisah
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClockMain().setVisible(true);
            }
        });
    }
}
