package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIView extends View {
    final int GRID_SIZE_PIXELS = 450;

    private String HIT_SPRITE = "╳";
    private String MISSED_SPRITE = "●";

    private JFrame frame;
    private JPanel panel;

    private JPanel gridPanel, btnPanel;
    private JButton newGameBtn, showScoreBtn;
    private GUIScoreView scoreView;

    public GUIView() {
        frame = new JFrame();
        changeLook();

        scoreView = new GUIScoreView(this);

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(e -> onNewGameBtn());
        showScoreBtn = new JButton("Leaderboard");
        showScoreBtn.addActionListener(e -> onShowScoreBtn());

        btnPanel.add(newGameBtn);
        btnPanel.add(showScoreBtn);

        gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(GRID_SIZE_PIXELS, GRID_SIZE_PIXELS));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());

        panel.add(btnPanel, BorderLayout.PAGE_START);
        panel.add(gridPanel, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    @Override
    public boolean confirmMessage(String title, String message) {
        return JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION) == 0;
    }

    @Override
    public void infoMessage(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void errMessage(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String inputDialog(String title, String label) {
        return JOptionPane.showInputDialog(frame, label, title, JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void initGrid() {
        gridPanel.setLayout(new GridLayout(row, col));

        Font font = new Font("Arial", Font.PLAIN, 42);

        for (int i = 0; i < row * col; i++) {
            final int id = i;

            var btn = new JButton();
            // btn.setFont(font);
            btn.addActionListener(e -> onButtonClicked(id));

            gridPanel.add(btn);
        }
    }

    @Override
    public void showScoreBoard() {
        showScoreBoard();
    }

    void changeToGameview() {
        frame.setContentPane(panel);
        frame.pack();
    }

    void changeToScoreView() {
        frame.setContentPane(scoreView.getPanel());
        frame.pack();
    }

    private void onNewGameBtn() {
        String name = inputDialog("Enter your name", "Name:");
        if (name != null && !name.isBlank())
            resetGrid();
    }

    private void onShowScoreBtn() {
        System.out.println("Show LeaderBoard");

        changeToScoreView();

        // confirmMessage("Confirm", "Please confirm");
        // infoMessage("Information", "Here lies information");
        // errMessage("Error", "Here lies error message");
        // inputDialog("Input", "Input here:");
    }

    private void onButtonClicked(int id) {
        frame.requestFocusInWindow(); // Pull the focus onto the window instead of the next button

        var btn = (JButton) gridPanel.getComponent(id);

        if (controller.shoot(id))
            btn.setText(HIT_SPRITE);
        else
            btn.setText(MISSED_SPRITE);

        btn.setEnabled(false);

        if (controller.isAllShipDestroyed()) {
            disableGrid();
            infoMessage("All ship destroyed!", "Good job!");
        }
    }

    private void disableGrid() {
        for (int i = 0; i < gridPanel.getComponentCount(); i++) {
            var btn = (JButton) gridPanel.getComponent(i);
            btn.setEnabled(false);
        }
    }

    private void resetGrid() {
        for (int i = 0; i < row * col; i++) {
            var btn = (JButton) gridPanel.getComponent(i);
            btn.setEnabled(true);
            btn.setText("");
        }

        controller.resetBoard();
    }

    private void changeLook() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }
}
