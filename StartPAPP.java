import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/**
 * @author Paweł Czernicki(github.com/PCzernicki)
 */
public class StartPAPP extends JFrame implements ActionListener
{
    private final JButton btn;
    private final JButton btn2;
    private final JButton btn3;
    private final JButton btn4;
    public StartPAPP() {
        setTitle("Select PingAPP(V1.2)");
        setIconImage(new ImageIcon("PingAPP/images/Icon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        setSize(450, 75);
        btn = new JButton("PingAPP-PL");
        btn.setActionCommand("PAPP1");
        btn.addActionListener(this);
        panel.add(btn);
        btn2 = new JButton("PingAPP-ES");
        btn2.addActionListener(this);
        btn2.setActionCommand("PAPP2");
        panel.add(btn2);
        btn3 = new JButton("PingAPP-SK");
        btn3.setActionCommand("PAPP3");
        btn3.addActionListener(this);
        panel.add(btn3);
        setResizable(false);
        add(panel);
        btn4 = new JButton("AP Checker");
        btn4.setActionCommand("PAPP4");
        btn4.addActionListener(this);
        panel.add(btn4);
        btn.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    btn.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    btn2.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    btn3.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    btn4.doClick();
                }
            }
        });
        TrayIcon trayIcon;
        SystemTray tray;
        tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("PingAPP/images/Icon.png");
        ActionListener exitListener = e -> {
            System.out.println("Exiting....");
            System.exit(0);
        };
        PopupMenu popup = new PopupMenu();
        MenuItem defaultItem = new MenuItem("Open");
        defaultItem.addActionListener(e -> {
            setVisible(true);
            setExtendedState(NORMAL);
        });
        popup.add(defaultItem);
        defaultItem = new MenuItem("PingAPP->V.1 (PL-IT)");
        defaultItem.addActionListener(e -> RunPAPP(1));
        popup.add(defaultItem);
        defaultItem = new MenuItem("PingAPP->V.2 (ES-AT)");
        defaultItem.addActionListener(e -> RunPAPP(2));
        popup.add(defaultItem);
        defaultItem = new MenuItem("PingAPP->V.3 (SK)");
        defaultItem.addActionListener(e -> RunPAPP(3));
        popup.add(defaultItem);
        defaultItem = new MenuItem("APChecker");
        defaultItem.addActionListener(e -> RunPAPP(4));
        popup.add(defaultItem);
        defaultItem = new MenuItem("Exit");
        defaultItem.addActionListener(exitListener);
        popup.add(defaultItem);
        trayIcon = new TrayIcon(image, "PingAPP(V1.2)", popup);
        trayIcon.setImageAutoSize(true);
        addWindowStateListener(e -> {
            if (e.getNewState() == ICONIFIED) {
                try {
                    tray.add(trayIcon);
                    setVisible(false);
                    System.out.println("added to SystemTray");
                } catch (AWTException ex) {
                    System.out.println("unable to add to tray");
                }
            }
            if (e.getNewState() == 7) {
                try {
                    tray.add(trayIcon);
                    setVisible(false);
                    System.out.println("added to SystemTray");
                } catch (AWTException ex) {
                    System.out.println("unable to add to system tray");
                }
            }
            if (e.getNewState() == MAXIMIZED_BOTH) {
                tray.remove(trayIcon);
                setVisible(true);
                System.out.println("Tray icon removed");
            }
            if (e.getNewState() == NORMAL) {
                tray.remove(trayIcon);
                setVisible(true);
                System.out.println("Tray icon removed");
            }
        });
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    tray.remove(trayIcon);
                    setVisible(true);
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("PingAPP/images/Icon.png"));
        setVisible(true);
        btn.addActionListener(e -> {
            try {
                tray.add(trayIcon);
                setVisible(false);

            } catch (Exception e11) {
                e11.printStackTrace();
            }
        });
        btn2.addActionListener(e -> {
            try {
                tray.add(trayIcon);
                setVisible(false);

            } catch (Exception e11) {
                e11.printStackTrace();
            }
        });
        btn3.addActionListener(e -> {
            try {
                tray.add(trayIcon);
                setVisible(false);

            } catch (Exception e11) {
                e11.printStackTrace();
            }
        });
        btn4.addActionListener(e -> {
            try {
                tray.add(trayIcon);
                setVisible(false);

            } catch (Exception e11) {
                e11.printStackTrace();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        if(cmd.equals("PAPP1"))
        {
            RunPAPP(1);
            }
        if(cmd.equals("PAPP2"))
        {
            RunPAPP(2);
        }
        if(cmd.equals("PAPP3"))
        {
            RunPAPP(3);
        }
        if(cmd.equals("PAPP4"))
        {
            RunPAPP(4);
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            String[] whitelist = {"pczernicki"};
            if(Arrays.asList(whitelist).contains(System.getProperty("user.name"))){
                new StartPAPP().setVisible(true);
                }
            else{
                JLabel label = new JLabel("Password:");
                JPasswordField jpf = new JPasswordField();
                JOptionPane.showConfirmDialog(null,
                        new Object[]{label, jpf}, "Password required",
                        JOptionPane.OK_CANCEL_OPTION);
                if (jpf.getText().equals("pw")){
                    new StartPAPP().setVisible(true);}}
            System.out.println();
        });
    }
    private void RunPAPP(int x){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            if(x==1){
                new PEPCOPingAPP().setVisible(true);
        }
            if(x==2){
                new PEPCOPingAPP2().setVisible(true);
            }
            if (x==3){
                new PingAPPSK().setVisible(true);
            }
            if (x==4){
                new APChecker().setVisible(true);
            }
        });}
}
