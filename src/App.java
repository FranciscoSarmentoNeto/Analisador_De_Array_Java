import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    static JFrame frame;
    static JTextField[] arrayFields;
    static JTextField xField;
    static JTextArea resultArea;

    public static void main(String[] args) {
        frame = new JFrame("Análise de Array");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        arrayFields = new JTextField[10];
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel((i + 1) + "º valor:");
            constraints.gridx = 0;
            constraints.gridy = i;
            panel.add(label, constraints);

            arrayFields[i] = new JTextField(5);
            constraints.gridx = 1;
            panel.add(arrayFields[i], constraints);
        }

        JLabel xLabel = new JLabel("Valor para análise:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(xLabel, constraints);

        xField = new JTextField(5);
        constraints.gridx = 1;
        panel.add(xField, constraints);

        JButton analyzeButton = new JButton("Analisar");
        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        panel.add(analyzeButton, constraints);

        resultArea = new JTextArea(10, 30);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analisarArray();
            }
        });
    }

    private static void analisarArray() {
        try {
            int[] array = new int[10];
            for (int i = 0; i < 10; i++) {
                array[i] = Integer.parseInt(arrayFields[i].getText());
            }

            int x = Integer.parseInt(xField.getText());

            String resultado = Analise_De_Array.verificarOrdemdoArray(array) + "\n" +
                               Analise_De_Array.verificarValoresDoArray(array, x);
            resultArea.setText(resultado);

        } catch (NumberFormatException e) {
            resultArea.setText("Por favor, insira números válidos.");
        }
    }
}
