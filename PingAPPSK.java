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
 * @author Paweł Czernicki(github.com/PCzernicki)
 */
public class PingAPPSK extends javax.swing.JFrame {
    boolean MOne, MTwo, MThree, MFour, MFive, MSix;//MSeven,MEight,Mnine,MTen never used
    String dirToOpenBOS,dirToOpenPOS1,dirToOpenPOS2,dirToOpenPOS3,dirToOpenPOS4;

    public PingAPPSK() {
        initComponents();
    }
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
        AP1Icon = new javax.swing.JLabel();
        AP2Icon = new javax.swing.JLabel();
        PBarAP1 = new javax.swing.JProgressBar();
        PBarAP2 = new javax.swing.JProgressBar();
        IPAP1 = new javax.swing.JTextField();
        IPAP2 = new javax.swing.JTextField();
        AP1Label = new javax.swing.JLabel();
        AP2Label = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        ConnectPrinter = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(360, 480));
        getContentPane().setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon("PingAPP/images/Icon.png").getImage());
        setTitle("PEPCO PingApp -> SK (V1.2)");
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
        PingAPPSK.Clicklistener click = new PingAPPSK.Clicklistener();
        StartButton.addActionListener(click);
        StopButton.addActionListener(click);

        ConnectBOS.setEnabled(false);
        ConnectPOS1.setEnabled(false);
        ConnectPOS2.setEnabled(false);
        ConnectPOS3.setEnabled(false);
        ConnectPOS4.setEnabled(false);
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
        IPGW.setEditable(false);
        IPEFT1.setEditable(false);
        IPEFT2.setEditable(false);
        IPEFT3.setEditable(false);
        IPEFT4.setEditable(false);
        IPPrinter.setEditable(false);
        IPMXQ.setEditable(false);
        IPAP1.setEditable(false);
        IPAP2.setEditable(false);

        ConnectBOS.addActionListener(arg0 -> {
            VNC(ConnectBOS, IPBOS.getText());
        });
        ConnectPOS1.addActionListener(arg0 -> {
            VNC(ConnectPOS1, IPPOS1.getText());
        });
        ConnectPOS2.addActionListener(arg0 -> {
            VNC(ConnectPOS2, IPPOS2.getText());
        });
        ConnectPOS3.addActionListener(arg0 -> {
            VNC(ConnectPOS3, IPPOS3.getText());
        });
        ConnectPOS4.addActionListener(arg0 -> {
            VNC(ConnectPOS4, IPPOS4.getText());
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
        KeyMaster KeyEvnt = new KeyMaster();
        ConnectBOS.addKeyListener(KeyEvnt);
        ConnectPOS1.addKeyListener(KeyEvnt);
        ConnectPOS2.addKeyListener(KeyEvnt);
        ConnectPOS3.addKeyListener(KeyEvnt);
        ConnectPOS4.addKeyListener(KeyEvnt);
        ConnectPrinter.addKeyListener(KeyEvnt);
        IPBOS.addKeyListener(KeyEvnt);
        IPPOS1.addKeyListener(KeyEvnt);
        IPPOS2.addKeyListener(KeyEvnt);
        IPPOS3.addKeyListener(KeyEvnt);
        IPPOS4.addKeyListener(KeyEvnt);
        IPPrinter.addKeyListener(KeyEvnt);
        IPGW.addKeyListener(KeyEvnt);
        IPEFT1.addKeyListener(KeyEvnt);
        IPEFT2.addKeyListener(KeyEvnt);
        IPEFT3.addKeyListener(KeyEvnt);
        IPEFT4.addKeyListener(KeyEvnt);
        IPMXQ.addKeyListener(KeyEvnt);
        StopButton.addKeyListener(KeyEvnt);
        StopButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/stopbuttonicon.png")); // NOI18N
        StopButton.setToolTipText("Click here to stop pinging! Tip: ESC also works!");
        StopButton.setActionCommand("");
        StopButton.setAlignmentY(0.0F);
        StopButton.setBorderPainted(false);
        getContentPane().add(StopButton);
        StopButton.setBounds(300, 10, 40, 40);
        StartButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/startbuttonicon.png")); // NOI18N
        StartButton.setToolTipText("Click here to start pinging! Tip: ENTER also works!");
        StartButton.setAlignmentY(0.0F);
        StartButton.setBorderPainted(false);
        StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StartButton.setFocusCycleRoot(true);
        getContentPane().add(StartButton);
        StartButton.setBounds(250, 10, 40, 40);
        CountryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poland", "Romania", "Serbia", "Slovenia", "Slovakia", "Latvia", "Lithuania", "Italy", "Hungary", "Croatia", "Estonia", "Czech Republic", "Bulgaria"}));
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
            public void mouseClicked(MouseEvent e0) {
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
                Short(dirToOpenPOS3);
            }
        });
        POS4Label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e4)
            {
                Short(dirToOpenPOS4);
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
        PBarPrinter.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e10)
            {
                Ping(IPPrinter.getText());
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
                            d.mail(new URI("mailto:pczernicki@pepco.eu?subject=Problem%20With%20PingAPP&body=Hi!%0AThere%20is%20a%20problem%20with%20PingAPP(SK):%20"));
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
        ConnectPOS3.setToolTipText("Click here to connect POS3 via VNC. Tip: F4 also works!");
        ConnectPOS3.setBorderPainted(false);
        ConnectPOS3.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS3);
        ConnectPOS3.setBounds(10, 240, 40, 40);
        ConnectPOS4.setIcon(new javax.swing.ImageIcon("PingAPP/images/posicon.png")); // NOI18N
        ConnectPOS4.setToolTipText("Click here to connect POS4 via VNC. Tip: F5 also works!");
        ConnectPOS4.setBorderPainted(false);
        ConnectPOS4.setContentAreaFilled(false);
        getContentPane().add(ConnectPOS4);
        ConnectPOS4.setBounds(10, 300, 40, 40);
        POS1Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS1Label.setForeground(new java.awt.Color(255, 255, 255));
        POS1Label.setText("  POS1");
        getContentPane().add(POS1Label);
        POS1Label.setBounds(10, 160, 40, 14);
        POS2Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS2Label.setForeground(new java.awt.Color(255, 255, 255));
        POS2Label.setText("  POS2");
        getContentPane().add(POS2Label);
        POS2Label.setBounds(10, 220, 40, 14);
        POS3Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS3Label.setForeground(new java.awt.Color(255, 255, 255));
        POS3Label.setText("  POS3");
        getContentPane().add(POS3Label);
        POS3Label.setBounds(10, 280, 40, 14);
        POS4Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POS4Label.setForeground(new java.awt.Color(255, 255, 255));
        POS4Label.setText("  POS4");
        getContentPane().add(POS4Label);
        POS4Label.setBounds(10, 340, 40, 14);
        MXQIcon.setIcon(new javax.swing.ImageIcon("PingAPP/images/mxqicon.png")); // NOI18N
        getContentPane().add(MXQIcon);
        MXQIcon.setBounds(190, 360, 40, 40);
        PrinterLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PrinterLabel.setForeground(new java.awt.Color(255, 255, 255));
        PrinterLabel.setText("Printer");
        getContentPane().add(PrinterLabel);
        PrinterLabel.setBounds(10, 400, 40, 14);
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
        PBarPrinter.setBounds(60, 360, 100, 20);
        getContentPane().add(IPPrinter);
        IPPrinter.setBounds(60, 380, 100, 23);
        GWLabel.setIcon(new javax.swing.ImageIcon("PingAPP/images/gwicon.png")); // NOI18N
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
        getContentPane().add(EFT1Label);
        EFT1Label.setBounds(190, 120, 40, 40);
        EFT2Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        getContentPane().add(EFT2Label);
        EFT2Label.setBounds(190, 180, 40, 40);
        EFT3Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        getContentPane().add(EFT3Label);
        EFT3Label.setBounds(190, 240, 40, 40);
        EFT4Label.setIcon(new javax.swing.ImageIcon("PingAPP/images/efticon.png")); // NOI18N
        getContentPane().add(EFT4Label);
        EFT4Label.setBounds(190, 300, 40, 40);
        EFT1Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT1Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT1Label2.setText("  FIS1");
        getContentPane().add(EFT1Label2);
        EFT1Label2.setBounds(190, 160, 40, 14);
        EFT2Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT2Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT2Label2.setText("  FIS2");
        getContentPane().add(EFT2Label2);
        EFT2Label2.setBounds(190, 220, 40, 14);
        EFT3Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT3Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT3Label2.setText("  FIS3");
        getContentPane().add(EFT3Label2);
        EFT3Label2.setBounds(190, 280, 40, 14);
        EFT4Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EFT4Label2.setForeground(new java.awt.Color(255, 255, 255));
        EFT4Label2.setText("  FIS4");
        getContentPane().add(EFT4Label2);
        EFT4Label2.setBounds(190, 340, 40, 14);
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
        getContentPane().add(MXQLabel);
        MXQLabel.setBounds(180, 400, 60, 14);
        getContentPane().add(PBarMXQ);
        PBarMXQ.setBounds(240, 360, 100, 20);
        getContentPane().add(IPMXQ);
        IPMXQ.setBounds(240, 380, 100, 23);
        AuthorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuthorLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuthorLabel.setText("pczernicki@pepco.eu");
        getContentPane().add(AuthorLabel);
        AuthorLabel.setBounds(170, 415, 170, 20);
        ConnectPrinter.setIcon(new javax.swing.ImageIcon("PingAPP/images/printericon.png")); // NOI18N
        ConnectPrinter.setToolTipText("Click here to enter printer website. Tip: F6 also works!");
        ConnectPrinter.setBorderPainted(false);
        ConnectPrinter.setContentAreaFilled(false);
        getContentPane().add(ConnectPrinter);
        ConnectPrinter.setBounds(10, 360, 40, 40);
        Background.setIcon(new javax.swing.ImageIcon("PingAPP/images/logoo.PNG")); // NOI18N
        Background.setAlignmentY(0.0F);
        Background.setMaximumSize(new java.awt.Dimension(350, 443));
        Background.setMinimumSize(new java.awt.Dimension(350, 443));
        getContentPane().add(Background);
        Background.setBounds(0, 0, 350, 443);
        pack();
    }// </editor-fold>
    PingAPPSK.P1 wone = new PingAPPSK.P1();//SwingWorker1
    PingAPPSK.P2 wtwo = new PingAPPSK.P2();//SwingWorker2
    PingAPPSK.P3 wthree = new PingAPPSK.P3();//SwingWorker3
    PingAPPSK.P4 wfour = new PingAPPSK.P4();//SwingWorker4
    PingAPPSK.P5 wfive = new PingAPPSK.P5();//SwingWorker5
    PingAPPSK.P6 wsix = new PingAPPSK.P6();//SwingWorker6
    //PEPCOPingAPP.P8 w8 = new PEPCOPingAPP.P8(); <- NOT USED
    //PEPCOPingAPP.P9 w9 = new PEPCOPingAPP.P9(); <- NOT USED
    //PEPCOPingAPP.P10 w10 = new PEPCOPingAPP.P10(); <- NOT USED
    public class P1 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                if(MOne){
                    i=0;
                    x=0;
                    MOne =false;
                }
                setProgress(i);
                InetAddress inet = InetAddress.getByName(IPBOS.getText());
                InetAddress inet1 = InetAddress.getByName(IPGW.getText());
                if (inet.isReachable(1000)) {
                    if(MOne){
                        i=0;
                        x=0;
                        MOne =false;
                    }
                    UIDefaults Defaults1 = new UIDefaults();
                    Defaults1.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarBOS.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarBOS.putClientProperty("Nimbus.Overrides", Defaults1);
                    Thread.sleep(1000);
                } else {
                    if(MOne){
                        i=0;
                        x=0;
                        MOne =false;}
                    UIDefaults Defaults2 = new UIDefaults();
                    Defaults2.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarBOS.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarBOS.putClientProperty("Nimbus.Overrides", Defaults2);
                }
                if (inet1.isReachable(1000)) {
                    if(MOne){
                        i=0;
                        x=0;
                        MOne =false;
                    }
                    UIDefaults Defaults1 = new UIDefaults();
                    Defaults1.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarGW.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarGW.putClientProperty("Nimbus.Overrides", Defaults1);
                    Thread.sleep(1000);
                } else {
                    if(MOne){
                        i=0;
                        x=0;
                        MOne =false;
                    }
                    UIDefaults Defaults2 = new UIDefaults();
                    Defaults2.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarGW.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarGW.putClientProperty("Nimbus.Overrides", Defaults2);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(MOne){
                    i=0;
                    x=0;
                    MOne =false;}
            }return null;
        }}//BOS + GW
    public class P2 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                setProgress(i);
                if(MTwo){
                    i=0;
                    x=0;
                    MTwo =false;
                }
                InetAddress inet = InetAddress.getByName(IPPOS1.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT1.getText());
                if (inet.isReachable(1000)) {
                    if(MTwo){
                        i=0;
                        x=0;
                        MTwo =false;
                    }
                    UIDefaults Defaults3 = new UIDefaults();
                    Defaults3.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults3.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarPOS1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS1.putClientProperty("Nimbus.Overrides", Defaults3);
                    Thread.sleep(1000);
                } else {
                    if(MTwo){
                        i=0;
                        x=0;
                        MTwo =false;
                    }
                    UIDefaults Defaults4 = new UIDefaults();
                    Defaults4.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults4.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarPOS1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS1.putClientProperty("Nimbus.Overrides", Defaults4);
                }
                if (inet1.isReachable(1000)) {
                    if(MTwo){
                        i=0;
                        x=0;
                        MTwo =false;
                    }
                    UIDefaults Defaults3 = new UIDefaults();
                    Defaults3.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults3.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarEFT1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT1.putClientProperty("Nimbus.Overrides", Defaults3);
                    Thread.sleep(1000);
                } else {
                    if(MTwo){
                        i=0;
                        x=0;
                        MTwo =false;}
                    UIDefaults Defaults4 = new UIDefaults();
                    Defaults4.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults4.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarEFT1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT1.putClientProperty("Nimbus.Overrides", Defaults4);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;
                }
                if(MTwo){
                    i=0;
                    x=0;
                    MTwo =false;
                }
            }return null;
        }}//POS1 + EFT1
    public class P3 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                setProgress(i);
                if(MThree){
                    i=0;
                    x=0;
                    MThree =false;}
                InetAddress inet = InetAddress.getByName(IPPOS2.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT2.getText());
                if (inet.isReachable(1000)) {
                    if(MThree){
                        i=0;
                        x=0;
                        MThree =false;}
                    UIDefaults Defaults5 = new UIDefaults();
                    Defaults5.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults5.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarPOS2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS2.putClientProperty("Nimbus.Overrides", Defaults5);
                    Thread.sleep(1000);
                } else {
                    if(MThree){
                        i=0;
                        x=0;
                        MThree =false;}
                    UIDefaults Defaults6 = new UIDefaults();
                    Defaults6.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults6.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarPOS2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS2.putClientProperty("Nimbus.Overrides", Defaults6);
                }
                if (inet1.isReachable(1000)) {
                    if(MThree){
                        i=0;
                        x=0;
                        MThree =false;}
                    UIDefaults Defaults5 = new UIDefaults();
                    Defaults5.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults5.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarEFT2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT2.putClientProperty("Nimbus.Overrides", Defaults5);
                    Thread.sleep(1000);
                } else {
                    if(MThree){
                        i=0;
                        x=0;
                        MThree =false;}
                    UIDefaults Defaults6 = new UIDefaults();
                    Defaults6.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults6.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarEFT2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT2.putClientProperty("Nimbus.Overrides", Defaults6);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(MThree){
                    i=0;
                    x=0;
                    MThree =false;}
            }return null;
        }}//POS2 + EFT2
    public class P4 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                setProgress(i);
                if(MFour){
                    i=0;
                    x=0;
                    MFour =false;}
                InetAddress inet = InetAddress.getByName(IPPOS3.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT3.getText());
                if (inet.isReachable(1000)) {
                    if(MFour){
                        i=0;
                        x=0;
                        MFour =false;}
                    //g=true;
                    UIDefaults Defaults7 = new UIDefaults();
                    Defaults7.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults7.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarPOS3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS3.putClientProperty("Nimbus.Overrides", Defaults7);
                    Thread.sleep(1000);
                } else {
                    if(MFour){
                        i=0;
                        x=0;
                        MFour =false;}
                    //g=false;
                    UIDefaults Defaults8 = new UIDefaults();
                    Defaults8.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults8.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarPOS3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS3.putClientProperty("Nimbus.Overrides", Defaults8);
                }
                if (inet1.isReachable(1000)) {
                    if(MFour){
                        i=0;
                        x=0;
                        MFour =false;}
                    //h=true;
                    UIDefaults Defaults7 = new UIDefaults();
                    Defaults7.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults7.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarEFT3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT3.putClientProperty("Nimbus.Overrides", Defaults7);
                    Thread.sleep(1000);
                } else {
                    if(MFour){
                        i=0;
                        x=0;
                        MFour =false;}
                    UIDefaults Defaults8 = new UIDefaults();
                    Defaults8.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults8.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarEFT3.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT3.putClientProperty("Nimbus.Overrides", Defaults8);
                    //h=false;
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(MFour){
                    i=0;
                    x=0;
                    MFour =false;}
            }return null;
        }}//POS3 + EFT3
    public class P5 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                setProgress(i);
                if(MFive){
                    i=0;
                    x=0;
                    MFive =false;}
                InetAddress inet = InetAddress.getByName(IPPOS4.getText());
                InetAddress inet1 = InetAddress.getByName(IPEFT4.getText());
                if (inet.isReachable(1000)) {
                    if(MFive){
                        i=0;
                        x=0;
                        MFive =false;
                    }
                    UIDefaults Defaults9 = new UIDefaults();
                    Defaults9.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults9.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarPOS4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS4.putClientProperty("Nimbus.Overrides", Defaults9);
                    Thread.sleep(1000);
                } else {
                    if(MFive){
                        i=0;
                        x=0;
                        MFive =false;
                    }
                    UIDefaults Defaults10 = new UIDefaults();
                    Defaults10.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults10.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarPOS4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPOS4.putClientProperty("Nimbus.Overrides", Defaults10);
                }
                if (inet1.isReachable(1000)) {
                    if(MFive){
                        i=0;
                        x=0;
                        MFive =false;
                    }
                    UIDefaults Defaults9 = new UIDefaults();
                    Defaults9.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults9.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarEFT4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT4.putClientProperty("Nimbus.Overrides", Defaults9);
                    Thread.sleep(1000);
                } else {
                    if(MFive){
                        i=0;
                        x=0;
                        MFive =false;}
                    UIDefaults Defaults10 = new UIDefaults();
                    Defaults10.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults10.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarEFT4.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarEFT4.putClientProperty("Nimbus.Overrides", Defaults10);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(MFive){
                    i=0;
                    x=0;
                    MFive =false;}
            }return null;
        }}//EFT3 + EFT4
    public class P6 extends SwingWorker<Object, Integer> {
        @Override
        protected Object doInBackground() throws Exception {
            boolean l=false, m=false;
            for (int i = 0; i <= 10; i++) {
                int x=i;
                i = i * 10;
                setProgress(i);
                if(MSix){
                    i=0;
                    x=0;
                    MSix =false;}
                InetAddress inet = InetAddress.getByName(IPPrinter.getText());
                InetAddress inet1 = InetAddress.getByName(IPMXQ.getText());
                if (inet.isReachable(1000)) {
                    if(MSix){
                        i=0;
                        x=0;
                        MSix =false;}
                    UIDefaults Defaults11 = new UIDefaults();
                    Defaults11.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults11.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarPrinter.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPrinter.putClientProperty("Nimbus.Overrides", Defaults11);
                    Thread.sleep(1000);
                } else {
                    if(MSix){
                        i=0;
                        x=0;
                        MSix =false;}
                    UIDefaults Defaults12 = new UIDefaults();
                    Defaults12.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults12.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarPrinter.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarPrinter.putClientProperty("Nimbus.Overrides", Defaults12);
                }
                if (inet1.isReachable(1000)) {
                    if(MSix){
                        i=0;
                        x=0;
                        MSix =false;}
                    UIDefaults Defaults11 = new UIDefaults();
                    Defaults11.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.green));
                    Defaults11.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.green));
                    PBarMXQ.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarMXQ.putClientProperty("Nimbus.Overrides", Defaults11);
                    Thread.sleep(1000);
                } else {
                    if (MSix) {
                        i = 0;
                        x = 0;
                        MSix = false;
                    }
                    UIDefaults Defaults12 = new UIDefaults();
                    Defaults12.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.red));
                    Defaults12.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.red));
                    PBarMXQ.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarMXQ.putClientProperty("Nimbus.Overrides", Defaults12);
                }
                i = x;
                if (x == 10) {
                    i = 0;
                    x = 0;}
                if(MSix){
                    i=0;
                    x=0;
                    MSix =false;}
            }return null;
        }}//PRINTER + MXQ
    public class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == StartButton) {
                ConnectBOS.setEnabled(true);
                ConnectPOS1.setEnabled(true);
                ConnectPOS2.setEnabled(true);
                ConnectPOS3.setEnabled(true);
                ConnectPOS4.setEnabled(true);
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
                Integer StoreP2Int = Integer.valueOf(StoreP2);
                String StoreP1 = null;
                if (StoreP2.length()==6){
                    switch (ChosenCountry) {
                        case "Poland":
                            temp = "PL";
                            StoreP1 = "";
                            break;
                        case "Romania":
                            temp = "RO";
                            StoreP1 = "";
                            break;
                        case "Serbia":
                            temp = "RS";
                            StoreP1 = "";
                            break;
                        case "Slovenia":
                            temp = "SI";
                            StoreP1 = "";
                            break;
                        case "Slovakia":
                            temp = "SK";
                            StoreP1 = "";
                            break;
                        case "Latvia":
                            temp = "LV";
                            StoreP1 = "";
                            break;
                        case "Lithuania":
                            temp = "LT";
                            StoreP1 = "";
                            break;
                        case "Italy":
                            temp = "IT";
                            StoreP1 = "";
                            break;
                        case "Hungary":
                            temp = "HU";
                            StoreP1 = "";
                            break;
                        case "Croatia":
                            temp = "HR";
                            StoreP1 = "";
                            break;
                        case "Estonia":
                            temp = "EE";
                            StoreP1 = "";
                            break;
                        case "Czech Republic":
                            temp = "CZ";
                            StoreP1 = "";
                            break;
                        case "Bulgaria":
                            temp = "BG";
                            StoreP1 = "";
                            break;
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
                    }
                }
                else{
                    switch (ChosenCountry) {
                        case "Poland":
                            temp = "PL";

                            if (StoreP2Int > 0 && StoreP2Int < 861) {
                                StoreP1 = "11";
                            } else {
                                StoreP1 = "00";
                            }
                            break;
                        case "Romania":
                            temp = "RO";

                            if (StoreP2Int > 4000) {
                                StoreP1 = "14";
                            } else if (StoreP2Int < 3000) {
                                StoreP1 = "14";
                            } else {
                                StoreP1 = "00";
                            }
                            break;
                        case "Serbia":
                            temp = "RS";
                            StoreP1 = "23";
                            break;
                        case "Slovenia":
                            temp = "SI";
                            StoreP1 = "17";
                            break;
                        case "Slovakia":
                            temp = "SK";
                            if (StoreP2Int > 3000) {
                                StoreP1 = "12";
                            } else if (StoreP2Int < 1000) {
                                StoreP1 = "12";
                            } else {
                                StoreP1 = "00";
                            }
                            break;
                        case "Latvia":
                            temp = "LV";
                            StoreP1 = "19";
                            break;
                        case "Lithuania":
                            temp = "LT";
                            StoreP1 = "18";
                            break;
                        case "Italy":
                            temp = "IT";
                            StoreP1 = "22";
                            break;
                        case "Hungary":
                            temp = "HU";
                            if (StoreP2Int > 4000) {
                                StoreP1 = "15";
                            } else if (StoreP2Int < 1000) {
                                StoreP1 = "15";
                            } else {
                                StoreP1 = "00";
                            }
                            break;
                        case "Croatia":
                            temp = "HR";
                            StoreP1 = "16";
                            break;
                        case "Estonia":
                            temp = "EE";
                            StoreP1 = "20";
                            break;
                        case "Czech Republic":
                            temp = "CZ";
                            if (StoreP2Int > 3000) {
                                StoreP1 = "13";
                            } else if (StoreP2Int < 1000) {
                                StoreP1 = "13";
                            } else {
                                StoreP1 = "00";
                            }
                            break;
                        case "Bulgaria":
                            temp = "BG";
                            StoreP1 = "21";
                            break;
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
                    }}
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
                IPPOS2.setText(values[0] + "." + values[1] + "." + values[2] + ".3");
                IPPOS3.setText(values[0] + "." + values[1] + "." + values[2] + ".4");
                IPPOS4.setText(values[0] + "." + values[1] + "." + values[2] + ".5");
                IPEFT1.setText(values[0] + "." + values[1] + "." + values[2] + ".12");
                IPEFT2.setText(values[0] + "." + values[1] + "." + values[2] + ".13");
                IPEFT3.setText(values[0] + "." + values[1] + "." + values[2] + ".14");
                IPEFT4.setText(values[0] + "." + values[1] + "." + values[2] + ".15");
                IPMXQ.setText(values[0] + "." + values[1] + "." + values[2] + ".130");
                IPPrinter.setText(values[0] + "." + values[1] + "." + values[2] + ".30");
                MOne = true;
                MTwo = true;
                MThree = true;
                MFour = true;
                MFive = true;
                MSix = true;
                wone.addPropertyChangeListener(new PropertyChangeListener() {

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
                wtwo.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS1.setValue(progress);
                            PBarPOS2.setValue(progress);
                        }
                    }

                });
                wthree.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS3.setValue(progress);
                            PBarPOS4.setValue(progress);
                        }
                    }

                });
                wfour.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarEFT1.setValue(progress);
                            PBarEFT2.setValue(progress);
                        }
                    }

                });
                wfive.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarEFT3.setValue(progress);
                            PBarEFT4.setValue(progress);
                        }
                    }

                });
                wsix.addPropertyChangeListener(new PropertyChangeListener() {

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
                wone.execute();
                wtwo.execute();
                wthree.execute();
                wfour.execute();
                wfive.execute();
                wsix.execute();
                final String finalTemp = temp;
                final String finalStoreP = StoreP1;
                dirToOpenBOS = ("//"+finalTemp+finalStoreP+StoreP2+"BOS01\\c$");
                dirToOpenPOS1 = ("//"+finalTemp+finalStoreP+StoreP2+"POS01\\c$");
                dirToOpenPOS2 = ("//"+finalTemp+finalStoreP+StoreP2+"POS02\\c$");
                dirToOpenPOS3 = ("//"+finalTemp+finalStoreP+StoreP2+"POS03\\c$");
                dirToOpenPOS4 = ("//"+finalTemp+finalStoreP+StoreP2+"POS04\\c$");
            }//IfStartButtonisClicked
            if (e.getSource() == StopButton) {
                ConnectBOS.setEnabled(false);
                ConnectPOS1.setEnabled(false);
                ConnectPOS2.setEnabled(false);
                ConnectPOS3.setEnabled(false);
                ConnectPOS4.setEnabled(false);
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
                PBarPrinter.setValue(0);
                PBarGW.setValue(0);
                PBarEFT1.setValue(0);
                PBarEFT2.setValue(0);
                PBarEFT3.setValue(0);
                PBarEFT4.setValue(0);
                PBarMXQ.setValue(0);
                wone.addPropertyChangeListener(new PropertyChangeListener() {

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
                wtwo.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS1.setValue(0);
                            PBarPOS2.setValue(0);
                        }
                    }

                });
                wthree.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarPOS3.setValue(0);
                            PBarPOS4.setValue(0);
                        }
                    }

                });
                wfour.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarEFT1.setValue(0);
                            PBarEFT2.setValue(0);
                        }
                    }

                });
                wfive.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarEFT3.setValue(0);
                            PBarEFT4.setValue(0);
                        }
                    }

                });
                wsix.addPropertyChangeListener(new PropertyChangeListener() {

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
                wone.execute();
                wtwo.execute();
                wthree.execute();
                wfour.execute();
                wfive.execute();
                wsix.execute();
            }//IfStopButtonisClicked
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
            java.util.logging.Logger.getLogger(PEPCOPingAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PEPCOPingAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PingAPPSK().setVisible(true);
            }

        });}
    class MyPainter implements Painter<JProgressBar> {

        private final Color color;

        public MyPainter(Color c1) {
            this.color = c1;
        }
        @Override
        public void paint(Graphics2D gd, JProgressBar t, int width, int height) {
            gd.setColor(color);
            gd.fillRect(2, 3, width-4, height-5);
        }
    }//Painter overriding ProgressBars
    public class KeyMaster implements KeyListener {
        public KeyMaster() {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
                StopButton.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F1) {
                ConnectBOS.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F2) {
                ConnectPOS1.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F3) {
                ConnectPOS2.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F4) {
                ConnectPOS3.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F5) {
                ConnectPOS4.doClick();
            }
            if(e.getKeyCode()==KeyEvent.VK_F6) {
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
    }//Key listener for faster access
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
    private javax.swing.JLabel AP1Icon;
    private javax.swing.JLabel AP1Label;
    private javax.swing.JLabel AP2Icon;
    private javax.swing.JLabel AP2Label;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel BOSLabel;
    private javax.swing.JLabel Background;
    private javax.swing.JButton ConnectBOS;
    private javax.swing.JButton ConnectPOS1;
    private javax.swing.JButton ConnectPOS2;
    private javax.swing.JButton ConnectPOS3;
    private javax.swing.JButton ConnectPOS4;
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
    private javax.swing.JLabel GWLabel;
    private javax.swing.JLabel GWLabel2;
    private javax.swing.JTextField IPAP1;
    private javax.swing.JTextField IPAP2;
    private javax.swing.JTextField IPBOS;
    private javax.swing.JTextField IPEFT1;
    private javax.swing.JTextField IPEFT2;
    private javax.swing.JTextField IPEFT3;
    private javax.swing.JTextField IPEFT4;
    private javax.swing.JTextField IPGW;
    private javax.swing.JTextField IPMXQ;
    private javax.swing.JTextField IPPOS1;
    private javax.swing.JTextField IPPOS2;
    private javax.swing.JTextField IPPOS3;
    private javax.swing.JTextField IPPOS4;
    private javax.swing.JTextField IPPrinter;
    private javax.swing.JLabel MXQIcon;
    private javax.swing.JLabel MXQLabel;
    private javax.swing.JProgressBar PBarAP1;
    private javax.swing.JProgressBar PBarAP2;
    private javax.swing.JProgressBar PBarBOS;
    private javax.swing.JProgressBar PBarEFT1;
    private javax.swing.JProgressBar PBarEFT2;
    private javax.swing.JProgressBar PBarEFT3;
    private javax.swing.JProgressBar PBarEFT4;
    private javax.swing.JProgressBar PBarGW;
    private javax.swing.JProgressBar PBarMXQ;
    private javax.swing.JProgressBar PBarPOS1;
    private javax.swing.JProgressBar PBarPOS2;
    private javax.swing.JProgressBar PBarPOS3;
    private javax.swing.JProgressBar PBarPOS4;
    private javax.swing.JProgressBar PBarPrinter;
    private javax.swing.JLabel POS1Label;
    private javax.swing.JLabel POS2Label;
    private javax.swing.JLabel POS3Label;
    private javax.swing.JLabel POS4Label;
    private javax.swing.JLabel PrinterLabel;
    private javax.swing.JToggleButton StartButton;
    private javax.swing.JToggleButton StopButton;
    private javax.swing.JTextField StoreNR;
    private javax.swing.JLabel StoreNRLabel;
    private javax.swing.JButton ConnectPrinter;
}
