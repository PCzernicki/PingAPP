
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
   @author Paweł Czernicki(github.com/PCzernicki)
 */
public class PEPCOPingAPP2 extends javax.swing.JFrame {
    boolean M1,M2,M3,M4,M5,M6,M7,M8,M9,M10;
    String dirToOpenBOS,dirToOpenPOS1,dirToOpenPOS2,dirToOpenSCO01,dirToOpenSCO02,dirToOpenSCO03,dirToOpenSCO04,dirToOpenSCO05,dirToOpenSCO06;

    public PEPCOPingAPP2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        StopButton = new javax.swing.JToggleButton();
        StartButton = new javax.swing.JToggleButton();
        CountryBox = new javax.swing.JComboBox<>();
        CountryLabel = new javax.swing.JLabel();
        StoreNRLabel = new javax.swing.JLabel();
        StoreNR = new javax.swing.JTextField();
        ConnectBOS = new javax.swing.JButton();
        BOSLabel = new javax.swing.JLabel();
        PBarBOS = new javax.swing.JProgressBar();
        IPBOS = new javax.swing.JTextField();
        ConnectPOS1 = new javax.swing.JButton();
        ConnectPOS2 = new javax.swing.JButton();
        ConnectPOS3 = new javax.swing.JButton();
        ConnectPOS4 = new javax.swing.JButton();
        POS1Label = new javax.swing.JLabel();
        POS2Label = new javax.swing.JLabel();
        POS3Label = new javax.swing.JLabel();
        POS4Label = new javax.swing.JLabel();
        MXQIcon = new javax.swing.JLabel();
        PrinterLabel = new javax.swing.JLabel();
        PBarPOS1 = new javax.swing.JProgressBar();
        PBarPOS2 = new javax.swing.JProgressBar();
        PBarPOS3 = new javax.swing.JProgressBar();
        PBarPOS4 = new javax.swing.JProgressBar();
        IPPOS1 = new javax.swing.JTextField();
        IPPOS2 = new javax.swing.JTextField();
        IPPOS3 = new javax.swing.JTextField();
        IPPOS4 = new javax.swing.JTextField();
        PBarPrinter = new javax.swing.JProgressBar();
        IPPrinter = new javax.swing.JTextField();
        GWLabel = new javax.swing.JLabel();
        PBarGW = new javax.swing.JProgressBar();
        IPGW = new javax.swing.JTextField();
        GWLabel2 = new javax.swing.JLabel();
        EFT1Label = new javax.swing.JLabel();
        EFT2Label = new javax.swing.JLabel();
        EFT3Label = new javax.swing.JLabel();
        EFT4Label = new javax.swing.JLabel();
        EFT1Label2 = new javax.swing.JLabel();
        EFT2Label2 = new javax.swing.JLabel();
        EFT3Label2 = new javax.swing.JLabel();
        EFT4Label2 = new javax.swing.JLabel();
        PBarEFT1 = new javax.swing.JProgressBar();
        PBarEFT2 = new javax.swing.JProgressBar();
        PBarEFT3 = new javax.swing.JProgressBar();
        PBarEFT4 = new javax.swing.JProgressBar();
        IPEFT1 = new javax.swing.JTextField();
        IPEFT2 = new javax.swing.JTextField();
        IPEFT3 = new javax.swing.JTextField();
        IPEFT4 = new javax.swing.JTextField();
        MXQLabel = new javax.swing.JLabel();
        PBarMXQ = new javax.swing.JProgressBar();
        IPMXQ = new javax.swing.JTextField();
        AuthorLabel = new javax.swing.JLabel();
        ConnectPrinter = new javax.swing.JButton();
        ConnectPOS5 = new javax.swing.JButton();
        ConnectPOS6 = new javax.swing.JButton();
        ConnectPOS7 = new javax.swing.JButton();
        ConnectPOS8 = new javax.swing.JButton();
        POS5Label = new javax.swing.JLabel();
        POS6Label = new javax.swing.JLabel();
        POS7Label = new javax.swing.JLabel();
        POS8Label = new javax.swing.JLabel();
        PBarPOS5 = new javax.swing.JProgressBar();
        PBarPOS6 = new javax.swing.JProgressBar();
        PBarPOS7 = new javax.swing.JProgressBar();
        PBarPOS8 = new javax.swing.JProgressBar();
        IPPOS5 = new javax.swing.JTextField();
        IPPOS6 = new javax.swing.JTextField();
        IPPOS7 = new javax.swing.JTextField();
        IPPOS8 = new javax.swing.JTextField();
        EFT5Label = new javax.swing.JLabel();
        EFT6Label = new javax.swing.JLabel();
        EFT7Label = new javax.swing.JLabel();
        EFT8Label = new javax.swing.JLabel();
        PBarEFT5 = new javax.swing.JProgressBar();
        PBarEFT6 = new javax.swing.JProgressBar();
        PBarEFT7 = new javax.swing.JProgressBar();
        PBarEFT8 = new javax.swing.JProgressBar();
        PBarEFT8 = new javax.swing.JProgressBar();
        IPEFT5 = new javax.swing.JTextField();
        IPEFT6 = new javax.swing.JTextField();
        IPEFT7 = new javax.swing.JTextField();
        IPEFT8 = new javax.swing.JTextField();
        EFT5Label2 = new javax.swing.JLabel();
        EFT6Label2 = new javax.swing.JLabel();
        EFT7Label2 = new javax.swing.JLabel();
        EFT8Label2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(362, 730));
        getContentPane().setLayout(null);
        setIconImage(new ImageIcon("PingAPP/images/Icon.png").getImage());
        setTitle("PEPCO PingApp -> ES-AT (V1.2)");
        StoreNRLabel.setText("Enter store number:");
        StoreNR.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
                if(!(c >= '0' && c <= '9'||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)){
                    String test = StoreNR.getText();
                    StoreNR.setText(test.replaceAll("[^0-9]", ""));
                }}
        });
        StoreNR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (StoreNR.getText().length() > 7)
                    e.consume();
            }
        });
        StoreNR.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //watch for key strokes
                StartButton.setEnabled(StoreNR.getText().length() == 4||StoreNR.getText().length()==6);
            }
        });
        PEPCOPingAPP2.Clicklistener click = new PEPCOPingAPP2.Clicklistener();
        StartButton.addActionListener(click);
        StopButton.addActionListener(click);

        ConnectBOS.setEnabled(false);
        ConnectPOS1.setEnabled(false);
        ConnectPOS2.setEnabled(false);
        ConnectPOS3.setEnabled(false);
        ConnectPOS4.setEnabled(false);
        ConnectPOS5.setEnabled(false);
        ConnectPOS6.setEnabled(false);
        ConnectPOS7.setEnabled(false);
        ConnectPOS8.setEnabled(false);
        ConnectPrinter.setEnabled(false);
        StopButton.setEnabled(false);
        StartButton.setEnabled(false);
        StoreNR.setToolTipText("");
        StoreNR.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    StartButton.doClick();
                }
            }
        });
        CountryBox.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    StartButton.doClick();
                }
            }
        });
        IPBOS.setEditable(false);
        IPPOS1.setEditable(false);
        IPPOS2.setEditable(false);
        IPPOS3.setEditable(false);
        IPPOS4.setEditable(false);
        IPPOS5.setEditable(false);
        IPPOS6.setEditable(false);
        IPPOS7.setEditable(false);
        IPPOS8.setEditable(false);
        IPGW.setEditable(false);
        IPEFT1.setEditable(false);
        IPEFT2.setEditable(false);
        IPEFT3.setEditable(false);
        IPEFT4.setEditable(false);
        IPEFT5.setEditable(false);
        IPEFT6.setEditable(false);
        IPEFT7.setEditable(false);
        IPEFT8.setEditable(false);
        IPPrinter.setEditable(false);
        IPMXQ.setEditable(false);

        ConnectBOS.addActionListener(arg0 -> {
            VNC(ConnectBOS,IPBOS.getText());
        });
        ConnectPOS1.addActionListener(arg0 -> {
            VNC(ConnectPOS1,IPPOS1.getText());
        });
        ConnectPOS2.addActionListener(arg0 -> {
            VNC(ConnectPOS2,IPPOS2.getText());
        });
        ConnectPOS3.addActionListener(arg0 -> {
            VNC(ConnectPOS3,IPPOS3.getText());
        });
        ConnectPOS4.addActionListener(arg0 -> {
            VNC(ConnectPOS4,IPPOS4.getText());
        });
        ConnectPOS5.addActionListener(arg0 -> {
            VNC(ConnectPOS5,IPPOS5.getText());
        });
        ConnectPOS6.addActionListener(arg0 -> {
            VNC(ConnectPOS6,IPPOS6.getText());
        });
        ConnectPOS7.addActionListener(arg0 -> {
            VNC(ConnectPOS7,IPPOS7.getText());
        });
        ConnectPOS8.addActionListener(arg0 -> {
            VNC(ConnectPOS8,IPPOS8.getText());
        });
        ConnectPrinter.addActionListener(arg0 -> {

            try {
                String s = IPPrinter.getText();
                URI uri= new URI("http://"+s);

                java.awt.Desktop.getDesktop().browse(uri);


            }

            catch (Exception e) {
                e.printStackTrace();
            }

        });
        PEPCOPingAPP2.KeyMaster KeyEvnt = new PEPCOPingAPP2.KeyMaster();
        ConnectBOS.addKeyListener(KeyEvnt);
        ConnectPOS1.addKeyListener(KeyEvnt);
        ConnectPOS2.addKeyListener(KeyEvnt);
        ConnectPOS3.addKeyListener(KeyEvnt);
        ConnectPOS4.addKeyListener(KeyEvnt);
        ConnectPOS5.addKeyListener(KeyEvnt);
        ConnectPOS6.addKeyListener(KeyEvnt);
        ConnectPOS7.addKeyListener(KeyEvnt);
        ConnectPOS8.addKeyListener(KeyEvnt);
        ConnectPrinter.addKeyListener(KeyEvnt);
        IPBOS.addKeyListener(KeyEvnt);
        IPPOS1.addKeyListener(KeyEvnt);
        IPPOS2.addKeyListener(KeyEvnt);
        IPPOS3.addKeyListener(KeyEvnt);
        IPPOS4.addKeyListener(KeyEvnt);
        IPPOS5.addKeyListener(KeyEvnt);
        IPPOS6.addKeyListener(KeyEvnt);
        IPPOS7.addKeyListener(KeyEvnt);
        IPPOS8.addKeyListener(KeyEvnt);
        IPPrinter.addKeyListener(KeyEvnt);
        IPGW.addKeyListener(KeyEvnt);
        IPEFT1.addKeyListener(KeyEvnt);
        IPEFT2.addKeyListener(KeyEvnt);
        IPEFT3.addKeyListener(KeyEvnt);
        IPEFT4.addKeyListener(KeyEvnt);
        IPEFT5.addKeyListener(KeyEvnt);
        IPEFT6.addKeyListener(KeyEvnt);
        IPEFT7.addKeyListener(KeyEvnt);
        IPEFT8.addKeyListener(KeyEvnt);
        IPMXQ.addKeyListener(KeyEvnt);
        StopButton.addKeyListener(KeyEvnt);
        StopButton.setToolTipText("Click here to stop pinging! Tip: ESC also works!");
        StopButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/stopbuttonicon.png")); // NOI18N
        StopButton.setAlignmentY(0.0F);
        StopButton.setBorderPainted(false);
        getContentPane().add(StopButton);
        StopButton.setBounds(300, 10, 40, 40);

        StartButton.setToolTipText("Click here to start pinging! Tip: ENTER also works!");
        StartButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/startbuttonicon.png")); // NOI18N
        StartButton.setAlignmentY(0.0F);
        StartButton.setBorderPainted(false);
        StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StartButton.setFocusCycleRoot(true);
        getContentPane().add(StartButton);
        StartButton.setBounds(250, 10, 40, 40);

        CountryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Spain","Austria"}));
        CountryBox.setToolTipText("Choose country of the store");
        getContentPane().add(CountryBox);
        CountryBox.setBounds(150, 30, 90, 25);
        CountryBox.getAccessibleContext().setAccessibleDescription("");

        CountryLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CountryLabel.setForeground(new java.awt.Color(255, 255, 255));
        CountryLabel.setText("Choose Country");
        getContentPane().add(CountryLabel);
        CountryLabel.setBounds(150, 10, 100, 20);

        StoreNRLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StoreNRLabel.setForeground(new java.awt.Color(255, 255, 255));
        StoreNRLabel.setText("Store NR:");
        getContentPane().add(StoreNRLabel);
        StoreNRLabel.setBounds(10, 20, 60, 30);

        StoreNR.setToolTipText("Put here 4 or 6 digits of the store number");
        getContentPane().add(StoreNR);
        StoreNR.setBounds(75, 20, 70, 30);

        ConnectBOS.setIcon(new javax.swing.ImageIcon("PingAPP/images/bosicon.png")); // NOI18N
        ConnectBOS.setToolTipText("Click here to connect BOS via VNC. Tip: F1 also works!");
        ConnectBOS.setBorderPainted(false);
        ConnectBOS.setContentAreaFilled(false);
        getContentPane().add(ConnectBOS);
        ConnectBOS.setBounds(10, 60, 40, 40);
        BOSLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                Short(dirToOpenBOS);
            }
        });
        POS1Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e1)
            {
                Short(dirToOpenPOS1);
            }

        });
        POS2Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e2)
            {
                Short(dirToOpenPOS2);
            }
        });
        POS3Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e3)
            {
                Short(dirToOpenSCO01);
            }
        });
        POS4Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenSCO02);
            }
        });
        POS5Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenSCO03);
            }
        });
        POS6Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenSCO04);
            }
        });
        POS7Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenSCO05);
            }
        });
        POS8Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenSCO06);
            }
        });
        PBarBOS.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e5)
            {
                Ping(IPBOS.getText());
            }
        });
        PBarPOS1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e6)
            {
                Ping(IPPOS1.getText());
            }
        });
        PBarPOS2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e7)
            {
                Ping(IPPOS2.getText());
            }
        });
        PBarPOS3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e8)
            {
                Ping(IPPOS3.getText());
            }
        });
        PBarPOS4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e9)
            {
                Ping(IPPOS4.getText());
            }
        });
        PBarPOS5.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e6)
            {
                Ping(IPPOS5.getText());
            }
        });
        PBarPOS6.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e7)
            {
                Ping(IPPOS6.getText());
            }
        });
        PBarPOS7.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e8)
            {
                Ping(IPPOS7.getText());
            }
        });
        PBarPOS8.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e9)
            {
                Ping(IPPOS8.getText());
            }
        });
        PBarPrinter.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e10)
            {Ping(IPPrinter.getText());
            }
        });
        PBarGW.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e11)
            {
                Ping(IPGW.getText());
            }
        });
        PBarEFT1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e12)
            {
                Ping(IPEFT1.getText());
            }
        });
        PBarEFT2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e13)
            {
                Ping(IPEFT2.getText());
            }
        });
        PBarEFT3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e14)
            {
                Ping(IPEFT3.getText());
            }
        });
        PBarEFT4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e15) {
                Ping(IPEFT4.getText());
            }
        });
        PBarEFT5.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e12)
            {
                Ping(IPEFT5.getText());
            }
        });
        PBarEFT6.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e13)
            {
                Ping(IPEFT6.getText());
            }
        });
        PBarEFT7.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e14)
            {
                Ping(IPEFT7.getText());
            }
        });
        PBarEFT8.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e15) {
                Ping(IPEFT8.getText());
            }
        });
        PBarMXQ.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e16)
            {
                Ping(IPMXQ.getText());}
        });
        AuthorLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e17)
            {
                if (Desktop.isDesktopSupported()) {
                    Desktop d = Desktop.getDesktop();
                    if (d.isSupported(Desktop.Action.MAIL)) {
                        try {
                            d.mail(new URI("mailto:pczernicki@pepco.eu?subject=Problem%20With%20PingAPP&body=Hi!%0AThere%20is%20a%20problem%20with%20PingAPP(ES-AT):%20"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        BOSLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BOSLabel.setForeground(new java.awt.Color(255, 255, 255));
        BOSLabel.setText("   BOS");
        getContentPane().add(BOSLabel);
        BOSLabel.setBounds(10, 100, 34, 14);
        getContentPane().add(PBarBOS);
        PBarBOS.setBounds(60, 60, 100, 20);
        getContentPane().add(IPBOS);
        IPBOS.setBounds(60, 80, 100, 23);

        ConnectPOS1.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS1.setToolTipText("Click here to connect POS1 via VNC. Tip: F2 also works!");
        ConnectPOS1.setBorderPainted(false);
        ConnectPOS1.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS1);
        ConnectPOS1.setBounds(10, 120, 40, 40);

        ConnectPOS2.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS2.setToolTipText("Click here to connect POS2 via VNC. Tip: F3 also works!");
        ConnectPOS2.setBorderPainted(false);
        ConnectPOS2.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS2);
        ConnectPOS2.setBounds(10, 180, 40, 40);

        ConnectPOS3.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS3.setToolTipText("Click here to connect SCO1 via VNC. Tip: F4 also works!");
        ConnectPOS3.setBorderPainted(false);
        ConnectPOS3.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS3);
        ConnectPOS3.setBounds(10, 240, 40, 40);

        ConnectPOS4.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS4.setToolTipText("Click here to connect SCO2 via VNC. Tip: F5 also works!");
        ConnectPOS4.setBorderPainted(false);
        ConnectPOS4.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS4);
        ConnectPOS4.setBounds(10, 300, 40, 40);

        POS1Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS1Label.setForeground(new java.awt.Color(255, 255, 255));
        POS1Label.setText("  POS1");
        POS1Label.setToolTipText("");
        getContentPane().add(POS1Label);
        POS1Label.setBounds(10, 160, 40, 14);

        POS2Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS2Label.setForeground(new java.awt.Color(255, 255, 255));
        POS2Label.setText("  POS2");
        POS2Label.setToolTipText("");
        getContentPane().add(POS2Label);
        POS2Label.setBounds(10, 220, 40, 14);

        POS3Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS3Label.setForeground(new java.awt.Color(255, 255, 255));
        POS3Label.setText("  SCO1");
        POS3Label.setToolTipText("");
        getContentPane().add(POS3Label);
        POS3Label.setBounds(10, 280, 40, 14);

        POS4Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS4Label.setForeground(new java.awt.Color(255, 255, 255));
        POS4Label.setText("  SCO2");
        POS4Label.setToolTipText("");
        getContentPane().add(POS4Label);
        POS4Label.setBounds(10, 340, 40, 14);

        MXQIcon.setIcon(new javax.swing.ImageIcon("PingAPP/images/mxqicon.png")); // NOI18N
        getContentPane().add(MXQIcon);
        MXQIcon.setBounds(190, 600, 40, 40);

        PrinterLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PrinterLabel.setForeground(new java.awt.Color(255, 255, 255));
        PrinterLabel.setText("Printer");
        getContentPane().add(PrinterLabel);
        PrinterLabel.setBounds(10, 640, 40, 14);
        getContentPane().add(PBarPOS1);
        PBarPOS1.setBounds(60, 120, 100, 20);
        getContentPane().add(PBarPOS2);
        PBarPOS2.setBounds(60, 180, 100, 20);
        getContentPane().add(PBarPOS3);
        PBarPOS3.setBounds(60, 240, 100, 20);
        getContentPane().add(PBarPOS4);
        PBarPOS4.setBounds(60, 300, 100, 20);

        getContentPane().add(IPPOS1);
        IPPOS1.setBounds(60, 140, 100, 23);

        getContentPane().add(IPPOS2);
        IPPOS2.setBounds(60, 200, 100, 23);

        getContentPane().add(IPPOS3);
        IPPOS3.setBounds(60, 260, 100, 23);

        getContentPane().add(IPPOS4);
        IPPOS4.setBounds(60, 320, 100, 23);
        getContentPane().add(PBarPrinter);
        PBarPrinter.setBounds(60, 600, 100, 20);

        getContentPane().add(IPPrinter);
        IPPrinter.setBounds(60, 620, 100, 23);

        GWLabel.setIcon(new javax.swing.ImageIcon("PingAPP/images/gwicon.png")); // NOI18N
        GWLabel.setToolTipText("");
        getContentPane().add(GWLabel);
        GWLabel.setBounds(190, 60, 40, 40);
        getContentPane().add(PBarGW);
        PBarGW.setBounds(240, 60, 100, 20);

        getContentPane().add(IPGW);
        IPGW.setBounds(240, 80, 100, 23);

        GWLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        GWLabel2.setForeground(new java.awt.Color(255, 255, 255));
        GWLabel2.setText("GW");
        getContentPane().add(GWLabel2);
        GWLabel2.setBounds(200, 100, 20, 10);

        EFT1Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT1Label.setText("jLabel1");
        getContentPane().add(EFT1Label);
        EFT1Label.setBounds(190, 120, 40, 40);

        EFT2Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT2Label.setText("jLabel1");
        getContentPane().add(EFT2Label);
        EFT2Label.setBounds(190, 180, 40, 40);

        EFT3Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT3Label.setText("jLabel1");
        getContentPane().add(EFT3Label);
        EFT3Label.setBounds(190, 240, 40, 40);

        EFT4Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT4Label.setText("jLabel1");
        getContentPane().add(EFT4Label);
        EFT4Label.setBounds(190, 300, 40, 40);

        EFT1Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT1Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT1Label2.setText("  EFT1");
        EFT1Label2.setToolTipText("");
        getContentPane().add(EFT1Label2);
        EFT1Label2.setBounds(190, 160, 40, 14);

        EFT2Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT2Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT2Label2.setText("  EFT2");
        EFT2Label2.setToolTipText("");
        getContentPane().add(EFT2Label2);
        EFT2Label2.setBounds(190, 220, 40, 14);

        EFT3Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT3Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT3Label2.setText(" S_EFT1");
        EFT3Label2.setToolTipText("");
        getContentPane().add(EFT3Label2);
        EFT3Label2.setBounds(190, 280, 50, 14);

        EFT4Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT4Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT4Label2.setText(" S_EFT2");
        EFT4Label2.setToolTipText("");
        getContentPane().add(EFT4Label2);
        EFT4Label2.setBounds(190, 340, 50, 14);
        getContentPane().add(PBarEFT1);
        PBarEFT1.setBounds(240, 120, 100, 20);
        getContentPane().add(PBarEFT2);
        PBarEFT2.setBounds(240, 180, 100, 20);
        getContentPane().add(PBarEFT3);
        PBarEFT3.setBounds(240, 240, 100, 20);
        getContentPane().add(PBarEFT4);
        PBarEFT4.setBounds(240, 300, 100, 20);

        getContentPane().add(IPEFT1);
        IPEFT1.setBounds(240, 140, 100, 23);

        getContentPane().add(IPEFT2);
        IPEFT2.setBounds(240, 200, 100, 23);

        getContentPane().add(IPEFT3);
        IPEFT3.setBounds(240, 260, 100, 23);

        getContentPane().add(IPEFT4);
        IPEFT4.setBounds(240, 320, 100, 23);

        MXQLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MXQLabel.setForeground(new java.awt.Color(255, 255, 255));
        MXQLabel.setText("MusicBox");
        MXQLabel.setToolTipText("");
        getContentPane().add(MXQLabel);
        MXQLabel.setBounds(180, 640, 60, 14);
        getContentPane().add(PBarMXQ);
        PBarMXQ.setBounds(240, 600, 100, 20);

        getContentPane().add(IPMXQ);
        IPMXQ.setBounds(240, 620, 100, 23);

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuthorLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuthorLabel.setText("pczernicki@pepco.eu");
        getContentPane().add(AuthorLabel);
        AuthorLabel.setBounds(170, 660, 170, 20);

        ConnectPrinter.setIcon(new javax.swing.ImageIcon("PingAPP/images/Printericon.png")); // NOI18N
        ConnectPrinter.setToolTipText("Click here to enter printer website. Tip: F10 also works!");
        ConnectPrinter.setBorderPainted(false);
        ConnectPrinter.setContentAreaFilled(false);
        getContentPane().add(ConnectPrinter);
        ConnectPrinter.setBounds(10, 600, 40, 40);

        ConnectPOS5.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS5.setToolTipText("Click here to connect SCO3 via VNC. Tip: F6 also works!");
        ConnectPOS5.setBorderPainted(false);
        ConnectPOS5.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS5);
        ConnectPOS5.setBounds(10, 360, 40, 40);

        ConnectPOS6.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS6.setToolTipText("Click here to connect SCO4 via VNC. Tip: F7 also works!");
        ConnectPOS6.setBorderPainted(false);
        ConnectPOS6.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS6);
        ConnectPOS6.setBounds(10, 420, 40, 40);

        ConnectPOS7.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS7.setToolTipText("Click here to connect SCO5 via VNC. Tip: F8 also works!");
        ConnectPOS7.setBorderPainted(false);
        ConnectPOS7.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS7);
        ConnectPOS7.setBounds(10, 480, 40, 40);

        ConnectPOS8.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS8.setToolTipText("Click here to connect SCO6 via VNC. Tip: F9 also works!");
        ConnectPOS8.setBorderPainted(false);
        ConnectPOS8.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS8);
        ConnectPOS8.setBounds(10, 540, 40, 40);

        POS5Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS5Label.setForeground(new java.awt.Color(255, 255, 255));
        POS5Label.setText("  SCO3");
        POS5Label.setToolTipText("");
        getContentPane().add(POS5Label);
        POS5Label.setBounds(10, 400, 40, 14);

        POS6Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS6Label.setForeground(new java.awt.Color(255, 255, 255));
        POS6Label.setText("  SCO4");
        POS6Label.setToolTipText("");
        getContentPane().add(POS6Label);
        POS6Label.setBounds(10, 460, 40, 14);

        POS7Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS7Label.setForeground(new java.awt.Color(255, 255, 255));
        POS7Label.setText("  SCO5");
        POS7Label.setToolTipText("");
        getContentPane().add(POS7Label);
        POS7Label.setBounds(10, 520, 40, 14);

        POS8Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS8Label.setForeground(new java.awt.Color(255, 255, 255));
        POS8Label.setText("  SCO6");
        POS8Label.setToolTipText("");
        getContentPane().add(POS8Label);
        POS8Label.setBounds(10, 580, 40, 14);
        getContentPane().add(PBarPOS5);
        PBarPOS5.setBounds(60, 360, 100, 20);
        getContentPane().add(PBarPOS6);
        PBarPOS6.setBounds(60, 420, 100, 20);
        getContentPane().add(PBarPOS7);
        PBarPOS7.setBounds(60, 480, 100, 20);
        getContentPane().add(PBarPOS8);
        PBarPOS8.setBounds(60, 540, 100, 20);

        IPPOS5.setToolTipText("");
        getContentPane().add(IPPOS5);
        IPPOS5.setBounds(60, 380, 100, 23);

        IPPOS6.setToolTipText("");
        getContentPane().add(IPPOS6);
        IPPOS6.setBounds(60, 440, 100, 23);

        IPPOS7.setToolTipText("");
        getContentPane().add(IPPOS7);
        IPPOS7.setBounds(60, 500, 100, 23);

        IPPOS8.setToolTipText("");
        getContentPane().add(IPPOS8);
        IPPOS8.setBounds(60, 560, 100, 23);

        EFT5Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT5Label.setText("jLabel1");
        getContentPane().add(EFT5Label);
        EFT5Label.setBounds(190, 360, 40, 40);

        EFT6Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT6Label.setText("jLabel1");
        getContentPane().add(EFT6Label);
        EFT6Label.setBounds(190, 420, 40, 40);

        EFT7Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT7Label.setText("jLabel1");
        getContentPane().add(EFT7Label);
        EFT7Label.setBounds(190, 480, 40, 40);

        EFT8Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        EFT8Label.setText("jLabel1");
        getContentPane().add(EFT8Label);
        EFT8Label.setBounds(190, 540, 40, 40);
        getContentPane().add(PBarEFT5);
        PBarEFT5.setBounds(240, 360, 100, 20);
        getContentPane().add(PBarEFT6);
        PBarEFT6.setBounds(240, 420, 100, 20);
        getContentPane().add(PBarEFT7);
        PBarEFT7.setBounds(240, 480, 100, 20);
        getContentPane().add(PBarEFT8);
        PBarEFT8.setBounds(240, 540, 100, 20);

        getContentPane().add(IPEFT5);
        IPEFT5.setBounds(240, 380, 100, 23);

        getContentPane().add(IPEFT6);
        IPEFT6.setBounds(240, 440, 100, 23);

        getContentPane().add(IPEFT7);
        IPEFT7.setBounds(240, 500, 100, 23);

        getContentPane().add(IPEFT8);
        IPEFT8.setBounds(240, 560, 100, 23);

        EFT5Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT5Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT5Label2.setText("S_EFT3");
        EFT5Label2.setToolTipText("");
        getContentPane().add(EFT5Label2);
        EFT5Label2.setBounds(190, 400, 50, 14);

        EFT6Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT6Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT6Label2.setText(" S_EFT4");
        EFT6Label2.setToolTipText("");
        getContentPane().add(EFT6Label2);
        EFT6Label2.setBounds(190, 460, 50, 14);

        EFT7Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT7Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT7Label2.setText("S_EFT5");
        EFT7Label2.setToolTipText("");
        getContentPane().add(EFT7Label2);
        EFT7Label2.setBounds(190, 520, 50, 14);

        EFT8Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT8Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT8Label2.setText("S_EFT6");
        EFT8Label2.setToolTipText("");
        getContentPane().add(EFT8Label2);
        EFT8Label2.setBounds(190, 580, 50, 14);
        Background.setIcon(new javax.swing.ImageIcon("PingAPP/images/logoolong.png")); // NOI18N

        Background.setAlignmentY(0.0F);
        Background.setMaximumSize(new java.awt.Dimension(350, 650));
        Background.setMinimumSize(new java.awt.Dimension(350, 650));
        getContentPane().add(Background);
        Background.setBounds(0, -80, 350, 870);

        pack();
    }// </editor-fold>
    PEPCOPingAPP2.P1 w1 = new PEPCOPingAPP2.P1();
    PEPCOPingAPP2.P2 w2 = new PEPCOPingAPP2.P2();
    PEPCOPingAPP2.P3 w3 = new PEPCOPingAPP2.P3();
    PEPCOPingAPP2.P4 w4 = new PEPCOPingAPP2.P4();
    PEPCOPingAPP2.P5 w5 = new PEPCOPingAPP2.P5();
    PEPCOPingAPP2.P6 w6 = new PEPCOPingAPP2.P6();
    PEPCOPingAPP2.P7 w7 = new PEPCOPingAPP2.P7();
    PEPCOPingAPP2.P8 w8 = new PEPCOPingAPP2.P8();
    PEPCOPingAPP2.P9 w9 = new PEPCOPingAPP2.P9();
    PEPCOPingAPP2.P10 w10 = new PEPCOPingAPP2.P10();
    public class P1 extends SwingWorker<Object, Integer> {

        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M1){
                    i=0;
                    x=0;
                    M1=false;}
                InetAddress inet = InetAddress.getByName(IPBOS.getText());
                InetAddress inet1 = InetAddress.getByName(IPGW.getText());
                if (inet.isReachable(1000)) {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarBOS.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarBOS.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarBOS.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarBOS.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));

                    PBarGW.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarGW.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));

                    PBarGW.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarGW.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M1){
                    i=0;
                    x=0;
                    M1=false;}

            }return null;
        }}//BOS + GW
    public class P2 extends SwingWorker<Object, Integer> {

        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {

                int x=i;
                i = i * 10;
                if(M2){
                    i=0;
                    x=0;
                    M2=false;}

                InetAddress inet = InetAddress.getByName(IPPOS1.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT1.getText());
                if (inet.isReachable(1000)) {
                    if(M2){
                        i=0;
                        x=0;
                        M2=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS1.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M2){
                        i=0;
                        x=0;
                        M2=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS1.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M2){
                        i=0;
                        x=0;
                        M2=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT1.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if (M2) {
                        i = 0;
                        x = 0;
                        M2 = false;
                    }
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT1.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M2){
                    i=0;
                    x=0;
                    M2=false;}
            }return null;
        }}//POS1+EFT1
    public class P3 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M3){
                    i=0;
                    x=0;
                    M3=false;}
                InetAddress inet = InetAddress.getByName(IPPOS2.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT2.getText());
                if (inet.isReachable(1000)) {
                    if(M3){
                        i=0;
                        x=0;
                        M3=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS2.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M3){
                        i=0;
                        x=0;
                        M3=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS2.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M3){
                        i=0;
                        x=0;
                        M3=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT2.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M3){
                        i=0;
                        x=0;
                        M3=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT2.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M3){
                    i=0;
                    x=0;
                    M3=false;}
            }return null;
        }}//POS2+EFT2
    public class P4 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M1){
                    i=0;
                    x=0;
                    M1=false;}
                InetAddress inet = InetAddress.getByName(IPPOS3.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT3.getText());
                if (inet.isReachable(1000)) {
                    if(M4){
                        i=0;
                        x=0;
                        M4=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS3.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M4){
                        i=0;
                        x=0;
                        M4=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS3.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M4){
                        i=0;
                        x=0;
                        M4=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT3.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M4){
                        i=0;
                        x=0;
                        M4=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT3.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M4){
                    i=0;
                    x=0;
                    M4=false;}
            }return null;
        }}//POS3+EFT3
    public class P5 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M5){
                    i=0;
                    x=0;
                    M5=false;}
                InetAddress inet = InetAddress.getByName(IPPOS4.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT4.getText());
                if (inet.isReachable(1000)) {
                    if(M5){
                        i=0;
                        x=0;
                        M5=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS4.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M5){
                        i=0;
                        x=0;
                        M5=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS4.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M5){
                        i=0;
                        x=0;
                        M5=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT4.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M5){
                        i=0;
                        x=0;
                        M5=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT4.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M5){
                    i=0;
                    x=0;
                    M5=false;}
            }return null;
        }}//POS4+EFT4
    public class P6 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M6){
                    i=0;
                    x=0;
                    M6=false;}
                InetAddress inet = InetAddress.getByName(IPPOS5.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT5.getText());
                if (inet.isReachable(1000)) {
                    if(M6){
                        i=0;
                        x=0;
                        M6=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS5.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS5.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M6){
                        i=0;
                        x=0;
                        M6=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS5.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS5.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M6){
                        i=0;
                        x=0;
                        M6=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT5.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT5.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M6){
                        i=0;
                        x=0;
                        M6=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT5.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT5.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M6){
                    i=0;
                    x=0;
                    M6=false;}
            }return null;
        }}//POS5+EFT5
    public class P7 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M7){
                    i=0;
                    x=0;
                    M7=false;}
                InetAddress inet = InetAddress.getByName(IPPOS6.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT6.getText());
                if (inet.isReachable(1000)) {
                    if(M7){
                        i=0;
                        x=0;
                        M7=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS6.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS6.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M7){
                        i=0;
                        x=0;
                        M7=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS6.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS6.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M7){
                        i=0;
                        x=0;
                        M7=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT6.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT6.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M7){
                        i=0;
                        x=0;
                        M7=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT6.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT6.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M7){
                    i=0;
                    x=0;
                    M7=false;}
            }return null;
        }}//POS6+EFT6
    public class P8 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M8){
                    i=0;
                    x=0;
                    M8=false;}
                InetAddress inet = InetAddress.getByName(IPPOS7.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT7.getText());
                if (inet.isReachable(1000)) {
                    if(M8){
                        i=0;
                        x=0;
                        M8=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS7.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS7.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M8){
                        i=0;
                        x=0;
                        M8=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS7.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS7.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M8){
                        i=0;
                        x=0;
                        M8=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT7.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT7.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M8){
                        i=0;
                        x=0;
                        M8=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT7.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT7.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M8){
                    i=0;
                    x=0;
                    M8=false;}
            }return null;
        }}//POS7+EFT7
    public class P9 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M9){
                    i=0;
                    x=0;
                    M9=false;}
                InetAddress inet = InetAddress.getByName(IPPOS8.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT8.getText());
                if (inet.isReachable(1000)) {
                    if(M9){
                        i=0;
                        x=0;
                        M9=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPOS8.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS8.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M9){
                        i=0;
                        x=0;
                        M9=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPOS8.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS8.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M9){
                        i=0;
                        x=0;
                        M9=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarEFT8.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT8.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M9){
                        i=0;
                        x=0;
                        M9=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarEFT8.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT8.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M9){
                    i=0;
                    x=0;
                    M9=false;}
            }return null;
        }}//POS8+EFT8
    public class P10 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(M10){
                    i=0;
                    x=0;
                    M10=false;}
                InetAddress inet = InetAddress.getByName(IPPrinter.getText());
                InetAddress inet1 = InetAddress.getByName(IPMXQ.getText());
                if (inet.isReachable(1000)) {
                    if(M10){
                        i=0;
                        x=0;
                        M10=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarPrinter.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPrinter.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M10){
                        i=0;
                        x=0;
                        M10=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarPrinter.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPrinter.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(M10){
                        i=0;
                        x=0;
                        M10=false;}
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.green));
                    PBarMXQ.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarMXQ.putClientProperty("Nimbus.Overrides", defaults1);
                    Thread.sleep(1000);
                } else {
                    if(M10){
                        i=0;
                        x=0;
                        M10=false;}
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new PEPCOPingAPP2.MyPainter(Color.red));
                    PBarMXQ.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarMXQ.putClientProperty("Nimbus.Overrides", defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(M10){
                    i=0;
                    x=0;
                    M10=false;}
            }return null;
        }}//Printer+MXQ
    public class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == StartButton) {
                ConnectBOS.setEnabled(true);
                ConnectPOS1.setEnabled(true);
                ConnectPOS2.setEnabled(true);
                ConnectPOS3.setEnabled(true);
                ConnectPOS4.setEnabled(true);
                ConnectPOS5.setEnabled(true);
                ConnectPOS6.setEnabled(true);
                ConnectPOS7.setEnabled(true);
                ConnectPOS8.setEnabled(true);
                ConnectPrinter.setEnabled(true);
                StopButton.setEnabled(true);
                StartButton.setEnabled(false);
                StoreNR.setEnabled(false);
                CountryBox.setEnabled(false);
                StopButton.setSelected(false);
                //////////////////////////////////////////////////////////////testy ipipip
                InetAddress ip1 = null;
                String ChosenCountry = CountryBox.getSelectedItem().toString();
                String temp = null;
                String StoreP2 = StoreNR.getText().toString();
                String StoreP1 = null;
                if (StoreP2.length()==6){
                    switch (ChosenCountry) {
                    case "Spain":
                        temp = "ES";
                        StoreP1 = "";
                        break;
                    case "Austria":
                        temp = "AT";
                        StoreP1 = "";
                        break;
                    default:
                        System.out.println("error");
                }}else{
                switch (ChosenCountry) {
                    case "Spain":
                        temp = "ES";
                        StoreP1 = "24";
                        break;
                    case "Austria":
                        temp = "AT";
                        StoreP1 = "25";
                        break;
                    default:
                        System.out.println("error");
                }
                }
                try {
                    ip1 = InetAddress.getByName(temp+StoreP1+StoreP2+"POS01");
                    //ip1 = InetAddress.getByName("Metin2.pl");

                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                    StopButton.doClick();
                    StoreNR.setText("");
                    JOptionPane.showMessageDialog(null, "DNS Problem!");

                }
                String[] values = null;
                String address = ((InetAddress) ip1).getHostAddress();
                values = address.split("\\.");
                IPBOS.setText(values[0] + "." + values[1] + "." + values[2] + ".29");
                IPPOS1.setText(values[0] + "." + values[1] + "." + values[2] + ".2");
                IPGW.setText(values[0] + "." + values[1] + "." + values[2] + ".1");
                IPPOS1.setText(values[0] + "." + values[1] + "." + values[2] + ".2");
                IPPOS2.setText(values[0] + "." + values[1] + "." + values[2] + ".3");
                IPPOS3.setText(values[0] + "." + values[1] + "." + values[2] + ".22");
                IPPOS4.setText(values[0] + "." + values[1] + "." + values[2] + ".23");
                IPPOS5.setText(values[0] + "." + values[1] + "." + values[2] + ".24");
                IPPOS6.setText(values[0] + "." + values[1] + "." + values[2] + ".25");
                IPPOS7.setText(values[0] + "." + values[1] + "." + values[2] + ".26");
                IPPOS8.setText(values[0] + "." + values[1] + "." + values[2] + ".27");
                IPEFT1.setText(values[0] + "." + values[1] + "." + values[2] + ".66");
                IPEFT2.setText(values[0] + "." + values[1] + "." + values[2] + ".67");
                IPEFT3.setText(values[0] + "." + values[1] + "." + values[2] + ".86");
                IPEFT4.setText(values[0] + "." + values[1] + "." + values[2] + ".87");
                IPEFT5.setText(values[0] + "." + values[1] + "." + values[2] + ".88");
                IPEFT6.setText(values[0] + "." + values[1] + "." + values[2] + ".89");
                IPEFT7.setText(values[0] + "." + values[1] + "." + values[2] + ".90");
                IPEFT8.setText(values[0] + "." + values[1] + "." + values[2] + ".91");
                IPMXQ.setText(values[0] + "." + values[1] + "." + values[2] + ".130");
                IPPrinter.setText(values[0] + "." + values[1] + "." + values[2] + ".30");
                M1 = true;
                M2 = true;
                M3 = true;
                M4 = true;
                M5 = true;
                M6 = true;
                M7 = true;
                M8 = true;
                M9 = true;
                M10 = true;

                w1.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarBOS.setValue(progress);
                            PBarGW.setValue(progress);
                        }
                    }

                });
                w2.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS1.setValue(progress);
                            PBarEFT1.setValue(progress);
                        }
                    }

                });
                w3.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS2.setValue(progress);
                            PBarEFT2.setValue(progress);
                        }
                    }

                });
                w4.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS3.setValue(progress);
                            PBarEFT3.setValue(progress);
                        }
                    }

                });
                w5.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS4.setValue(progress);
                            PBarEFT4.setValue(progress);
                        }
                    }

                });
                w6.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS5.setValue(progress);
                            PBarEFT5.setValue(progress);
                        }
                    }

                });
                w7.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS6.setValue(progress);
                            PBarEFT6.setValue(progress);
                        }
                    }

                });
                w8.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS7.setValue(progress);
                            PBarEFT7.setValue(progress);
                        }
                    }

                });
                w9.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS8.setValue(progress);
                            PBarEFT8.setValue(progress);
                        }
                    }

                });
                w10.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPrinter.setValue(progress);
                            PBarMXQ.setValue(progress);
                        }
                    }

                });
                w1.execute();
                w2.execute();
                w3.execute();
                w4.execute();
                w5.execute();
                w6.execute();
                w7.execute();
                w8.execute();
                w9.execute();
                w10.execute();

                String finalStoreP = StoreP1;
                String finalTemp = temp;
                dirToOpenBOS = ("\\\\"+finalTemp + finalStoreP+StoreP2+"BOS01\\c$");
                dirToOpenPOS1 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"POS01\\c$");
                dirToOpenPOS2 = ("\\\\"+finalTemp+finalStoreP+StoreP2+"POS02\\c$");
                dirToOpenSCO01 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO01\\c$");
                dirToOpenSCO02 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO02\\c$");
                dirToOpenSCO03 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO03\\c$");
                dirToOpenSCO04 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO04\\c$");
                dirToOpenSCO05 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO05\\c$");
                dirToOpenSCO06 = ("\\\\"+finalTemp + finalStoreP+StoreP2+"SCO06\\c$");
            }

            ///////////////////////////////////////////////////////////////////////
            if (e.getSource() == StopButton) {
                ConnectBOS.setEnabled(false);
                ConnectPOS1.setEnabled(false);
                ConnectPOS2.setEnabled(false);
                ConnectPOS3.setEnabled(false);
                ConnectPOS4.setEnabled(false);
                ConnectPOS5.setEnabled(false);
                ConnectPOS6.setEnabled(false);
                ConnectPOS7.setEnabled(false);
                ConnectPOS8.setEnabled(false);
                ConnectPrinter.setEnabled(false);
                StopButton.setEnabled(false);
                StartButton.setEnabled(true);
                StoreNR.setEnabled(true);
                CountryBox.setEnabled(true);
                StartButton.setSelected(false);
                StoreNR.selectAll();
                StoreNR.requestFocus();
                PBarBOS.setValue(0);
                PBarPOS1.setValue(0);
                PBarPOS2.setValue(0);
                PBarPOS3.setValue(0);
                PBarPOS4.setValue(0);
                PBarPOS5.setValue(0);
                PBarPOS6.setValue(0);
                PBarPOS7.setValue(0);
                PBarPOS8.setValue(0);
                PBarPrinter.setValue(0);
                PBarGW.setValue(0);
                PBarEFT1.setValue(0);
                PBarEFT2.setValue(0);
                PBarEFT3.setValue(0);
                PBarEFT4.setValue(0);
                PBarEFT5.setValue(0);
                PBarEFT6.setValue(0);
                PBarEFT7.setValue(0);
                PBarEFT8.setValue(0);
                PBarMXQ.setValue(0);
                w1.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarBOS.setValue(0);
                            PBarGW.setValue(0);
                        }
                    }

                });
                w2.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS1.setValue(0);
                            PBarEFT1.setValue(0);
                        }
                    }

                });
                w3.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS2.setValue(0);
                            PBarEFT2.setValue(0);
                        }
                    }

                });
                w4.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS3.setValue(0);
                            PBarEFT3.setValue(0);
                        }
                    }

                });
                w5.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS4.setValue(0);
                            PBarEFT4.setValue(0);
                        }
                    }

                });
                w6.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS5.setValue(0);
                            PBarEFT5.setValue(0);
                        }
                    }

                });
                w7.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS6.setValue(0);
                            PBarEFT6.setValue(0);
                        }
                    }

                });
                w8.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS7.setValue(0);
                            PBarEFT7.setValue(0);
                        }
                    }

                });
                w9.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS8.setValue(0);
                            PBarEFT8.setValue(0);
                        }
                    }

                });
                w10.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPrinter.setValue(0);
                            PBarMXQ.setValue(0);
                        }
                    }

                });
                w1.execute();
                w2.execute();
                w3.execute();
                w4.execute();
                w5.execute();
                w6.execute();
                w7.execute();
                w8.execute();
                w9.execute();
                w10.execute();
            }
        }
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PEPCOPingAPP2().setVisible(true);
            }
        });
    }
    class MyPainter implements Painter<JProgressBar> {

        private final Color color;

        public MyPainter(Color c1) {
            this.color = c1;
        }
        @Override
        public void paint(Graphics2D gd, JProgressBar t, int width, int height) {
            gd.setColor(color);
            gd.fillRect(2, 3, width-5, height-5);
        }
    }
    public class KeyMaster implements KeyListener {
        public KeyMaster() {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                StopButton.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F1) {
                ConnectBOS.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F2) {
                ConnectPOS1.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F3) {
                ConnectPOS2.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F4) {
                ConnectPOS3.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F5) {
                ConnectPOS4.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F6) {
                ConnectPOS5.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F7) {
                ConnectPOS6.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F8) {
                ConnectPOS7.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_F9) {
                ConnectPOS8.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F10) {
                ConnectPrinter.doClick();}
            if(e.getKeyCode()==KeyEvent.VK_F11) {
                try {

                    URI zabbix= new URI("http://zabbix.pepco.ad");
                    java.awt.Desktop.getDesktop().browse(zabbix);


                }

                catch (Exception e7) {
                    e7.printStackTrace();
                }}
            if(e.getKeyCode()==KeyEvent.VK_F12) {
                try {

                    URI WLC= new URI("http://10.2.5.49");
                    java.awt.Desktop.getDesktop().browse(WLC);


                }

                catch (Exception e8) {
                    e8.printStackTrace();
                }
        }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    public void Short(String x){
        if (!StartButton.isEnabled()&&StopButton.isEnabled()) {
            try {
                Runtime.getRuntime().exec("cmd /c \"net use " + x + " /user:tpservice \"Pepco2016su\" \"");
                Thread.sleep(1000);
                Runtime.getRuntime().exec("cmd /c \"start " + x + "\"");
            } catch (Exception a0) {
                JOptionPane.showMessageDialog(null, "Lack of permissions.");
            }
        }
    }
    public void Ping(String x){
        if(!StartButton.isEnabled()&&StopButton.isEnabled()){
            try {
                Runtime.getRuntime().exec("cmd /c start cmd /k \"ping " + x + " -t\"");
            } catch (Exception a1) {
                JOptionPane.showMessageDialog(null, "Something went wrong.");
            }}
    }
    public void VNC(JButton x, String y){
        try {
            x.setEnabled(false);
            java.awt.Desktop.getDesktop().open(
                    new java.io.File("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\RealVNC\\VNC Viewer 4\\Run VNC Viewer.lnk"));
            Robot r=new Robot();
            String s = y;
            r.delay(250);
            for (int i = 0; i < s.length(); i++)
            {
                char res = s.charAt(i);
                r.keyPress(res);
                r.keyRelease(res);
            }
            r.delay(30);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (IOException|AWTException e) {
            e.printStackTrace();
        }
        x.setEnabled(true);
    }


    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel BOSLabel;
    private javax.swing.JLabel Background;
    private javax.swing.JButton ConnectBOS;
    private javax.swing.JButton ConnectPOS1;
    private javax.swing.JButton ConnectPOS2;
    private javax.swing.JButton ConnectPOS3;
    private javax.swing.JButton ConnectPOS4;
    private javax.swing.JButton ConnectPOS5;
    private javax.swing.JButton ConnectPOS6;
    private javax.swing.JButton ConnectPOS7;
    private javax.swing.JButton ConnectPOS8;
    private javax.swing.JButton ConnectPrinter;
    private javax.swing.JComboBox<String> CountryBox;
    private javax.swing.JLabel CountryLabel;
    private javax.swing.JLabel EFT1Label;
    private javax.swing.JLabel EFT1Label2;
    private javax.swing.JLabel EFT2Label;
    private javax.swing.JLabel EFT2Label2;
    private javax.swing.JLabel EFT3Label;
    private javax.swing.JLabel EFT3Label2;
    private javax.swing.JLabel EFT4Label;
    private javax.swing.JLabel EFT4Label2;
    private javax.swing.JLabel EFT5Label;
    private javax.swing.JLabel EFT5Label2;
    private javax.swing.JLabel EFT6Label;
    private javax.swing.JLabel EFT6Label2;
    private javax.swing.JLabel EFT7Label;
    private javax.swing.JLabel EFT7Label2;
    private javax.swing.JLabel EFT8Label;
    private javax.swing.JLabel EFT8Label2;
    private javax.swing.JLabel GWLabel;
    private javax.swing.JLabel GWLabel2;
    private javax.swing.JTextField IPBOS;
    private javax.swing.JTextField IPEFT1;
    private javax.swing.JTextField IPEFT2;
    private javax.swing.JTextField IPEFT3;
    private javax.swing.JTextField IPEFT4;
    private javax.swing.JTextField IPEFT5;
    private javax.swing.JTextField IPEFT6;
    private javax.swing.JTextField IPEFT7;
    private javax.swing.JTextField IPEFT8;
    private javax.swing.JTextField IPGW;
    private javax.swing.JTextField IPMXQ;
    private javax.swing.JTextField IPPOS1;
    private javax.swing.JTextField IPPOS2;
    private javax.swing.JTextField IPPOS3;
    private javax.swing.JTextField IPPOS4;
    private javax.swing.JTextField IPPOS5;
    private javax.swing.JTextField IPPOS6;
    private javax.swing.JTextField IPPOS7;
    private javax.swing.JTextField IPPOS8;
    private javax.swing.JTextField IPPrinter;
    private javax.swing.JLabel MXQIcon;
    private javax.swing.JLabel MXQLabel;
    private javax.swing.JProgressBar PBarBOS;
    private javax.swing.JProgressBar PBarEFT1;
    private javax.swing.JProgressBar PBarEFT2;
    private javax.swing.JProgressBar PBarEFT3;
    private javax.swing.JProgressBar PBarEFT4;
    private javax.swing.JProgressBar PBarEFT5;
    private javax.swing.JProgressBar PBarEFT6;
    private javax.swing.JProgressBar PBarEFT7;
    private javax.swing.JProgressBar PBarEFT8;
    private javax.swing.JProgressBar PBarGW;
    private javax.swing.JProgressBar PBarMXQ;
    private javax.swing.JProgressBar PBarPOS1;
    private javax.swing.JProgressBar PBarPOS2;
    private javax.swing.JProgressBar PBarPOS3;
    private javax.swing.JProgressBar PBarPOS4;
    private javax.swing.JProgressBar PBarPOS5;
    private javax.swing.JProgressBar PBarPOS6;
    private javax.swing.JProgressBar PBarPOS7;
    private javax.swing.JProgressBar PBarPOS8;
    private javax.swing.JProgressBar PBarPrinter;
    private javax.swing.JLabel POS1Label;
    private javax.swing.JLabel POS2Label;
    private javax.swing.JLabel POS3Label;
    private javax.swing.JLabel POS4Label;
    private javax.swing.JLabel POS5Label;
    private javax.swing.JLabel POS6Label;
    private javax.swing.JLabel POS7Label;
    private javax.swing.JLabel POS8Label;
    private javax.swing.JLabel PrinterLabel;
    private javax.swing.JToggleButton StartButton;
    private javax.swing.JToggleButton StopButton;
    private javax.swing.JTextField StoreNR;
    private javax.swing.JLabel StoreNRLabel;
}
