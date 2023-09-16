import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Spinner extends JFrame {
    static int width = 800;
    static int height = 600;
    private JSpinner spinner;
    private JLabel label;
    public Spinner()
    {
        super("Spinner");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Spinner.width, Spinner.height);
        this.setLocation(d.width / 2 - Spinner.width / 2, d.height / 2 - Spinner.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());

        spinner = new JSpinner();
        spinner.setFont(new Font("Serif", Font.PLAIN, 20));
        spinner.setValue(0);

        JButton button = new JButton("Ответить");
        button.setFont(new Font("Serif", Font.PLAIN, 20));

        label = new JLabel("Ответ:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));

        this.add(spinner, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 20, 20), 0, 0));
        this.add(button, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 20, 20), 0, 0));
        this.add(label, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(20, 20, 20, 20), 0, 0));

        this.pack();
        this.setVisible(true);

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner s = (JSpinner) e.getSource();
                if ((int) s.getValue() < 0) {
                    s.setValue(0);
                }
            }
        });

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Ответ: " + spinner.getValue());
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Spinner frame = new Spinner();
            }
        });
    }
}
