package views;

import controls.BackupFiles;
import controls.Logger;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Backup");
        setSize(800,500);
        setLocation(400,300);
        // почитать
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setJMenuBar(initJMenuBar());
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JButton button1 = initButton();
        JPanel bottomPanel = new JPanel(new FlowLayout());
        cont.add(bottomPanel, BorderLayout.NORTH);
        bottomPanel.add(button1);
        cont.add(new JScrollPane(initTextArea()), BorderLayout.CENTER);


        setVisible(true);
    }

    private JButton initButton() {
        JButton button = new JButton("Start backup");
        button.addActionListener(e -> {
            // String orDir = BackupFiles.ordir.getAbsolutePath();
            //String copyDir = BackupFiles.copydir.getAbsolutePath();
            BackupFiles bf = new BackupFiles();
            bf.copyFiles();
        });
        return button;
    }

    private JTextArea initTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        Logger logger = Logger.getLogger();
        textArea.setText(logger.getTextLoger());
        return textArea;
    }

    private JMenuBar initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menu = new JMenu("Settings");
        jMenuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("set");
        menu.add(menuItem);


        return jMenuBar;
    }
}
