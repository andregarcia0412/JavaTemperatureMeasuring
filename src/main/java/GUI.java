import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
    private JFrame frame;
    private JComboBox comboBox;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private Arduino a = new Arduino();

    GUI(){
        frame = new JFrame();
        comboBox = new JComboBox();
        for(int i = 0; i < a.getCommPorts().length; i++){
            comboBox.addItem(a.getCommPorts()[i].getSystemPortName());
        }
        comboBox.setMaximumSize(new Dimension(150, comboBox.getPreferredSize().height));
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            a.setUserPort(selected);
        });

        button = new JButton("Iniciar");
        button.setMaximumSize(new Dimension(150, comboBox.getPreferredSize().height));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            new Thread(()-> {
                try{
                    while(true){
                        String[] arduinoData = a.readArduino().split(",");

                        SwingUtilities.invokeLater(() -> {
                            if(!(arduinoData[0].equals("nan") || arduinoData[1].equals("nan")))
                                label.setText("Temperatura: " + arduinoData[0] + " °C" + " Umidade: " + arduinoData[1] + "%");
                        });
                    }
                } catch (Exception er){
                    er.printStackTrace();
                }
            }).start();
        });

        label = new JLabel("");
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50,150,100,150));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);
        panel.add(Box.createVerticalStrut(50));
        panel.add(button);
        panel.add(Box.createVerticalStrut(20));
        panel.add(comboBox);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                a.closePort();
                frame.dispose();
            }
        });
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Temperature Measuring");
        frame.setVisible(true);
    }
}
