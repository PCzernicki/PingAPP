/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Paweł Czernicki(github.com/PCzernicki)
 */
public class APChecker extends javax.swing.JFrame {
boolean M1;
    public APChecker() {
        initComponents();
    }
    private void initComponents() {
        StopButton = new javax.swing.JToggleButton();
        StartButton = new javax.swing.JToggleButton();
        CountryBox = new javax.swing.JComboBox<>();
        CountryLabel = new javax.swing.JLabel();
        StoreNRLabel = new javax.swing.JLabel();
        StoreNR = new javax.swing.JTextField();
        AP1Icon = new javax.swing.JButton();
        AP2Icon = new javax.swing.JLabel();
        PBarAP1 = new javax.swing.JProgressBar();
        PBarAP2 = new javax.swing.JProgressBar();
        IPAP1 = new javax.swing.JTextField();
        IPAP2 = new javax.swing.JTextField();
        AP1Label = new javax.swing.JLabel();
        AP2Label = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconImage(new ImageIcon("PingAPP/images/Icon.png").getImage());
        setTitle("PEPCO APChecker -> (V1.2)");
        setPreferredSize(new java.awt.Dimension(363, 175));
        getContentPane().setLayout(null);
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
        APChecker.Clicklistener click = new APChecker.Clicklistener();
        StartButton.addActionListener(click);
        StopButton.addActionListener(click);
        PBarAP1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e8)
            {
                Ping(IPAP1.getText());
            }
        });
        PBarAP2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e8)
            {
                Ping(IPAP2.getText());
            }
        });

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
        IPAP1.setEditable(false);
        IPAP2.setEditable(false);

        StopButton.setToolTipText("Click here to start pinging! Tip: ESC also works!");
        StopButton.setAlignmentY(0.0F);
        StopButton.setBorderPainted(false);
        getContentPane().add(StopButton);
        StopButton.setBounds(300, 10, 40, 40);
        StopButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/stopbuttonicon.png")); // NOI18N
        getContentPane().add(StopButton);
        StartButton.setToolTipText("Click here to start pinging! Tip: ENTER also works!");
        StartButton.setAlignmentY(0.0F);
        StartButton.setBorderPainted(false);
        StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StartButton.setFocusCycleRoot(true);
        getContentPane().add(StartButton);
        StartButton.setBounds(250, 10, 40, 40);
        StartButton.setIcon(new javax.swing.ImageIcon("PingAPP/images/startbuttonicon.png")); // NOI18N
        getContentPane().add(StartButton);
        APChecker.KeyMaster KeyEvnt = new APChecker.KeyMaster();
        AP1Icon.addKeyListener(KeyEvnt);
        CountryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poland", "Romania", "Serbia", "Slovenia", "Slovakia", "Latvia", "Lithuania", "Italy", "Hungary", "Croatia", "Estonia", "Czech Republic", "Bulgaria", "Spain", "Austria"}));
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

        AP1Icon.setIcon(new javax.swing.ImageIcon("PingAPP/images/apicon.png")); // NOI18N
        getContentPane().add(AP1Icon);
        AP1Icon.setBorderPainted(false);
        AP1Icon.setContentAreaFilled(false);
        AP1Icon.setBounds(10, 60, 40, 30);

        AP2Icon.setIcon(new javax.swing.ImageIcon("PingAPP/images/apicon.png")); // NOI18N
        getContentPane().add(AP2Icon);
        AP2Icon.setBounds(190, 60, 40, 30);
        getContentPane().add(PBarAP1);
        PBarAP1.setBounds(60, 60, 100, 20);
        getContentPane().add(PBarAP2);
        PBarAP2.setBounds(240, 60, 100, 20);

        IPAP1.setToolTipText("");
        getContentPane().add(IPAP1);
        IPAP1.setBounds(60, 80, 100, 25);

        IPAP2.setToolTipText("");
        getContentPane().add(IPAP2);
        IPAP2.setBounds(240, 80, 100, 25);

        AP1Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AP1Label.setForeground(new java.awt.Color(255, 255, 255));
        AP1Label.setText("  AP1");
        getContentPane().add(AP1Label);
        AP1Label.setBounds(10, 90, 30, 14);

        AP2Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AP2Label.setForeground(new java.awt.Color(255, 255, 255));
        AP2Label.setText("  AP2");
        getContentPane().add(AP2Label);
        AP2Label.setBounds(190, 90, 34, 14);

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuthorLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuthorLabel.setText("pczernicki@pepco.eu");
        getContentPane().add(AuthorLabel);
        AuthorLabel.setBounds(130, 110, 180, 20);

        Background.setIcon(new javax.swing.ImageIcon("PingAPP/images/logoo.png")); // NOI18N
        Background.setAlignmentY(0.0F);
        Background.setMaximumSize(new java.awt.Dimension(350, 450));
        Background.setMinimumSize(new java.awt.Dimension(350, 450));
        getContentPane().add(Background);
        Background.setBounds(0, 0, 350, 140);

        pack();
    }
    APChecker.P1 w1 = new APChecker.P1();
    String apone, aptwo;
    public class P1 extends SwingWorker<Object, Integer> {

        @Override
        protected Object doInBackground() throws Exception {
            boolean a0=false, a1=false;
            for (int i = 0; i <= 10; i++) {

                int x=i;
                i = i * 10;
                if(M1){
                    i=0;
                    x=0;
                    M1=false;}

                InetAddress inet = InetAddress.getByName(apone);
                InetAddress inet1 = InetAddress.getByName(aptwo);
                if (inet.isReachable(1000)) {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    a0=true;
                    Thread.sleep(1000);
                } else {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    a0=false;
                }
                if (inet1.isReachable(1000)) {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    a1=true;
                    Thread.sleep(1000);
                } else {
                    if(M1){
                        i=0;
                        x=0;
                        M1=false;}
                    a1=false;
                }
                if(a0){
                    setProgress(i);
                    UIDefaults defaults1 = new UIDefaults();
                    defaults1.put("ProgressBar[Enabled].foregroundPainter", new APChecker.MyPainter(Color.green));
                    defaults1.put("ProgressBar[Enabled+Finished].foregroundPainter", new APChecker.MyPainter(Color.green));

                    PBarAP1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarAP1.putClientProperty("Nimbus.Overrides", defaults1);
                }else{
                    setProgress(i);
                    UIDefaults defaults2 = new UIDefaults();
                    defaults2.put("ProgressBar[Enabled].foregroundPainter", new APChecker.MyPainter(Color.red));
                    defaults2.put("ProgressBar[Enabled+Finished].foregroundPainter", new APChecker.MyPainter(Color.red));

                    PBarAP1.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarAP1.putClientProperty("Nimbus.Overrides", defaults2);
                }
                if(a1){
                    setProgress(i);
                    UIDefaults defaults3 = new UIDefaults();
                    defaults3.put("ProgressBar[Enabled].foregroundPainter", new APChecker.MyPainter(Color.green));
                    defaults3.put("ProgressBar[Enabled+Finished].foregroundPainter", new APChecker.MyPainter(Color.green));

                    PBarAP2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarAP2.putClientProperty("Nimbus.Overrides", defaults3);
                }else{
                    setProgress(i);
                    UIDefaults defaults4 = new UIDefaults();
                    defaults4.put("ProgressBar[Enabled].foregroundPainter", new APChecker.MyPainter(Color.red));
                    defaults4.put("ProgressBar[Enabled+Finished].foregroundPainter", new APChecker.MyPainter(Color.red));

                    PBarAP2.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                    PBarAP2.putClientProperty("Nimbus.Overrides", defaults4);
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
        }}
    public class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == StartButton) {
                StopButton.setEnabled(true);
                StartButton.setEnabled(false);
                StoreNR.setEnabled(false);
                CountryBox.setEnabled(false);
                StopButton.setSelected(false);
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
                else{switch (ChosenCountry) {
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

                        if (StoreP2Int > 3000) {
                            StoreP1 = "14";
                        } else if (StoreP2Int < 1000) {
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
                M1 = true;
                String[] APki = new String[12];
                ArrayList<String> successfull = new ArrayList<String>();


                for(int i=0;i<12;i++){
                    APki[i]=values[0]+"."+values[1]+"."+values[2]+"."+(178+i);
                    String x=APki[i];
                    Thread thread = new Thread(() -> {
                        try{
                            InetAddress apk = InetAddress.getByName(x);
                            boolean reachable = apk.isReachable(2000);
                            System.out.println(reachable);
                            if (reachable){
                                successfull.add(x);
                            }
                        }catch(IOException e1){
                            e1.printStackTrace();
                        }
                    });
                thread.start();}
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                int u = successfull.size();
                Collections.sort(successfull);
                System.out.println(u);
                if(u>1){
                    IPAP1.setText(successfull.get(0));
                    apone= successfull.get(0);
                    aptwo= successfull.get(1);
                    IPAP2.setText(successfull.get(1));
                }else if(successfull.size()==1){
                    IPAP1.setText(successfull.get(0));
                    apone= successfull.get(0);
                    aptwo=values[0]+"."+values[1]+"."+values[2]+".146";
                    IPAP2.setText("Not available!");
                }else {
                    IPAP1.setText("Not available!");
                    aptwo=values[0]+"."+values[1]+"."+values[2]+".146";
                    apone=values[0]+"."+values[1]+"."+values[2]+".146";
                    IPAP2.setText("Not available!");
                }
                w1.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarAP1.setValue(progress);
                            PBarAP2.setValue(progress);
                        }
                    }

                });
                w1.execute();
            }
            if (e.getSource() == StopButton) {
                StopButton.setEnabled(false);
                StartButton.setEnabled(true);
                StoreNR.setEnabled(true);
                CountryBox.setEnabled(true);
                StartButton.setSelected(false);
                StoreNR.selectAll();
                StoreNR.requestFocus();
                PBarAP1.setValue(0);
                PBarAP2.setValue(0);
                w1.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            PBarAP1.setValue(0);
                            PBarAP2.setValue(0);
                        }
                    }

                });
                w1.execute();
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
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(APChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APChecker().setVisible(true);
            }
        });
    }
    public void Ping(String x){
        if(!StartButton.isEnabled()&&StopButton.isEnabled()){
            try {
                Runtime.getRuntime().exec("cmd /c start cmd /k \"ping " + x + " -t\"");
            } catch (Exception a1) {
                JOptionPane.showMessageDialog(null, "Something went wrong.");
            }}
    }
    public class KeyMaster implements KeyListener {
        public KeyMaster() {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
                StopButton.doClick();
            }}

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }//Key listener for faster access
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
    private javax.swing.JButton AP1Icon;
    private javax.swing.JLabel AP1Label;
    private javax.swing.JLabel AP2Icon;
    private javax.swing.JLabel AP2Label;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> CountryBox;
    private javax.swing.JLabel CountryLabel;
    private javax.swing.JTextField IPAP1;
    private javax.swing.JTextField IPAP2;
    private javax.swing.JProgressBar PBarAP1;
    private javax.swing.JProgressBar PBarAP2;
    private javax.swing.JToggleButton StartButton;
    private javax.swing.JToggleButton StopButton;
    private javax.swing.JTextField StoreNR;
    private javax.swing.JLabel StoreNRLabel;
}
