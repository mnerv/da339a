package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIScoreView {
    private final int MAX_COLUMN = 53;

    private GUIView gui;

    private JPanel panel;
    private JPanel listPanel;

    private JLabel textLbl;

    private JPanel btnPanels;
    private JButton backBtn;

    private JLabel scoreLbl;

    private JTextArea textArea;

    public GUIScoreView(GUIView gui) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.gui = gui;

        listPanel = new JPanel();
        // listPanel.setLayout(new GridLayout(1, 1));
        listPanel.setLayout(new GridLayout(1, 1));
        listPanel.setPreferredSize(new Dimension(gui.GRID_SIZE_PIXELS, gui.GRID_SIZE_PIXELS));
        // listPanel.setBackground(Color.BLACK);

        textArea = new JTextArea();
        textArea.setEditable(false);

        String test = "Hello\n";

        for (int i = 0; i < 100; i++) {
            textArea.append(i + ". " + (i < 10 ? " " : "") + test);
        }

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        listPanel.add(scroll, BorderLayout.CENTER);

        scoreLbl = new JLabel();
        scoreLbl.setText("Hello\nHello");

        textLbl = new JLabel("High Score", JLabel.CENTER);
        textLbl.setFont(new Font(textLbl.getFont().getName(), textLbl.getFont().getStyle(), 21));

        btnPanels = new JPanel();
        btnPanels.setLayout(new FlowLayout());
        backBtn = new JButton("Back");
        backBtn.addActionListener(e -> onBackBtn());

        btnPanels.add(backBtn);

        panel.add(textLbl, BorderLayout.PAGE_START);
        panel.add(listPanel, BorderLayout.CENTER);
        panel.add(btnPanels, BorderLayout.PAGE_END);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void onBackBtn() {
        gui.changeToGameview();
    }
}
