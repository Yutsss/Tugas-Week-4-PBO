import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockMain extends JFrame {
    private ClockDisplay clock;
    private JLabel timeLabel;

    public ClockMain() {
        // Inisialisasi clock dan label
        clock = new ClockDisplay();
        timeLabel = new JLabel(clock.getTime(), JLabel.CENTER);

        // Mengatur tampilan GUI
        setTitle("Clock Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Atur font dan ukuran label
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 32));

        // Tambahkan label ke frame
        add(timeLabel, BorderLayout.CENTER);

        // Membuat timer untuk update waktu setiap detik
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.timeTick();  // Tambah 1 detik
                timeLabel.setText(clock.getTime());  // Perbarui label dengan waktu baru
            }
        });

        timer.start();  // Mulai timer
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
