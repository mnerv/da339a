package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIView extends View {
    private JFrame frame;
    private JPanel panel;

    private JPanel gridPanel, btnPanel;

    private JButton newGameBtn;

    public GUIView() {
        frame = new JFrame();
        changeUI();

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        newGameBtn = new JButton("New Game");
        btnPanel.add(newGameBtn);

        gridPanel = new JPanel();
        gridPanel.setBackground(Color.BLUE);
        gridPanel.setPreferredSize(new Dimension(500, 500));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());

        panel.add(btnPanel, BorderLayout.PAGE_START);
        panel.add(gridPanel, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);
        frame.pack();
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        frame.setTitle(this.title);
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }

    @Override
    public void update() {}

    private void changeUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

    private void onButtonClicked(int id) {
        var btn = (JButton) gridPanel.getComponent(id);
        btn.setText("0");
        btn.setEnabled(false);
    }

    @Override
    public void initGrid() {
        gridPanel.setLayout(new GridLayout(row, col));

        for (int i = 0; i < row * col; i++) {
            final int id = i;

            var btn = new JButton();
            btn.setPreferredSize(new Dimension(10, 10));
            btn.addActionListener(e -> onButtonClicked(id));

            gridPanel.add(btn);
        }
    }
}
