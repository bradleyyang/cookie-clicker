// Cookie Clicker Game (Simple version)
// Input: Prompt for player name
// Processing: Process buttons clicked, player name entered, mouse clicks
// Output: Display menu screen with buttons and images, rules screen with text and images, winners screen with names of winners, and game screen with cookie images and cookie count

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.Timer;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class CookieClicker implements ActionListener, MouseListener{
    private JFrame frame;

    // Menu panel
    private JPanel menuPanel;
    private JButton rulesButton, playButton, winnersButton, quitMenuButton;
    private JTextField playerNameTextBox;
    private String playerNameTextString;
    private ImageIcon backgroundCookie;
    private JLabel backgroundPic, menuTitle, playerNameLabel, permPlayerName;

    // Rules panel
    private JPanel rulesPanel;
    private JButton backButtonRules;
    private JLabel rulesTitle, rule1, rule2, rule3, rule4, cookieIconLabel1, cookieIconLabel2, cookieIconLabel3;
    private JLabel factoryIconLabel1, factoryIconLabel2, farmIconLabel1, farmIconLabel2, storeIconLabel;
    private ImageIcon cookieIcon, factoryIcon, farmIcon, storeIcon;

    // Winners panel
    private JPanel winnersPanel, winnersPanel2;
    private JLabel winnersTitle, tempWinner;
    private JButton backButtonWinners;
    private JScrollPane scrollPane;

    // Game panel
    private JPanel gamePanel;
    private JButton backGameButton, cookieButton, cursorPerk, grandmaPerk, farmPerk, factoryPerk;
    private ImageIcon cookieIconLarge, storeIconLarge, cursorPerkIcon, grandmaPerkIcon, farmPerkIcon, factoryPerkIcon;
    private JLabel cookieCountLabel, storeLargeLabel, gifLabel, cursorCount, grandmaCount, farmCount, factoryCount;
    private JLabel cursorCountImage, grandmaCountImage, farmCountImage, factoryCountImage, itemName, itemCost, itemDesc;
    private int cookieCount = 0, cursorInt = 0, grandmaInt = 0, farmInt = 0, factoryInt = 0;
    private int cursorNum = 0, grandmaNum = 0, farmNum = 0, factoryNum = 0;
    private Icon cookieGif;
    private Timer timer;
    private TimerTask task;

    // Win panel
    private JPanel winPanel;
    private ImageIcon winScreen;
    private JButton quitGameWinScreen, replayButton;
    private JLabel winnerLabel, winnerNameLabel, winScreenLabel;
    
    public CookieClicker() {
        // Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setSize(1000, 600);

        // Images for menu
        backgroundCookie = new ImageIcon("cookieMenu.png");
        backgroundPic = new JLabel();
        backgroundPic.setIcon(backgroundCookie);
        backgroundPic.setBounds(0, 0, 1000, 600);

        // Menu Labels 
        menuTitle = new JLabel("COOKIE CLICKER");
        menuTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        menuTitle.setBounds(330, 10, 500, 60);
        menuTitle.setForeground(new Color(139, 69, 19));

        playerNameLabel = new JLabel("PLAYER NAME");
        playerNameLabel.setBounds(395, 230, 230, 40);
        playerNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        playerNameLabel.setForeground(new Color(51, 0, 102));

        permPlayerName = new JLabel("", SwingConstants.CENTER);
        permPlayerName.setBounds(0, 280, 1000, 40);
        permPlayerName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        permPlayerName.setForeground(new Color(255,105,180));

        // Menu Buttons
        quitMenuButton = new JButton("QUIT");
        quitMenuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        quitMenuButton.setBounds(10, 10, 100, 50);
        quitMenuButton.addActionListener(this);

        playButton = new JButton("PLAY");
        playButton.setBounds(455, 340, 100, 40);
        playButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        playButton.addActionListener(this);

        rulesButton = new JButton("RULES");
        rulesButton.setBounds(375, 400, 100, 40);
        rulesButton.addActionListener(this);
        rulesButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        winnersButton = new JButton("WINNERS");
        winnersButton.setBounds(505, 400, 130, 40);
        winnersButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        winnersButton.addActionListener(this);

        // Textfields for menu
        playerNameTextBox = new JTextField();
        playerNameTextBox.setBounds(365, 280, 280, 40);
        playerNameTextBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        playerNameTextBox.setBorder(new LineBorder(Color.BLACK,2));

        // Frame
        frame = new JFrame();
        frame.setTitle("Cookie Clicker");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Adding components to menu panel
        menuPanel.add(menuTitle);
        menuPanel.add(rulesButton);
        menuPanel.add(winnersButton);
        menuPanel.add(playerNameLabel);
        menuPanel.add(playButton);
        menuPanel.add(playerNameTextBox);
        menuPanel.add(quitMenuButton);
        menuPanel.add(backgroundPic);

        //////////////////////////////////////////////////

        // Rules panel
        rulesPanel = new JPanel();
        rulesPanel.setSize(1000, 600);
        rulesPanel.setLayout(null);

        // Images for rules panel
        cookieIcon = new ImageIcon("cookieIcon.png"); 
        factoryIcon = new ImageIcon("factoryIcon.png");
        farmIcon = new ImageIcon("farmIcon.png");
        storeIcon = new ImageIcon("storeIcon.png");

        cookieIconLabel1 = new JLabel();
        cookieIconLabel1.setIcon(cookieIcon);
        cookieIconLabel1.setBounds(400, 80, 100, 100);

        cookieIconLabel2 = new JLabel();
        cookieIconLabel2.setIcon(cookieIcon);
        cookieIconLabel2.setBounds(425, 180, 100, 100);

        cookieIconLabel3 = new JLabel();
        cookieIconLabel3.setIcon(cookieIcon);
        cookieIconLabel3.setBounds(690, 380, 100, 100);

        factoryIconLabel1 = new JLabel();      
        factoryIconLabel1.setIcon(factoryIcon);
        factoryIconLabel1.setBounds(380, 290, 60, 60); 

        factoryIconLabel2 = new JLabel();
        factoryIconLabel2.setIcon(factoryIcon);
        factoryIconLabel2.setBounds(320, 390, 60, 60);

        farmIconLabel1 = new JLabel();
        farmIconLabel1.setIcon(farmIcon);
        farmIconLabel1.setBounds(290, 295, 60, 60);

        farmIconLabel2 = new JLabel();
        farmIconLabel2.setIcon(farmIcon);
        farmIconLabel2.setBounds(230, 395, 60, 60);

        storeIconLabel = new JLabel();
        storeIconLabel.setIcon(storeIcon);
        storeIconLabel.setBounds(780, 295, 70, 70);

        // Buttons for rules panel
        backButtonRules = new JButton("BACK");
        backButtonRules.setBounds(10, 10, 100, 50);
        backButtonRules.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        backButtonRules.addActionListener(this);

        // Labels for rules panel
        rulesTitle = new JLabel("RULES");
        rulesTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        rulesTitle.setBounds(435, 10, 200, 70);

        rule1 = new JLabel("Click the\t\t\t\t\t\t\t\t\t\t\tto make a cookie");
        rule1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        rule1.setBounds(280, 100, 600, 50);

        rule2 = new JLabel("Reach 1 billion\t\t\t\t\t\t\t\t\t\t\t\tto win the game!");
        rule2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        rule2.setBounds(225, 200, 600, 50);

        rule3 = new JLabel("Buy items (\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t) from the store menu");
        rule3.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        rule3.setBounds(120, 300, 700, 50);

        rule4 = new JLabel("help you make more");
        rule4.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        rule4.setBounds(410, 400, 400, 50);

        // Adding components to rules panel
        rulesPanel.add(backButtonRules);
        rulesPanel.add(rulesTitle);
        rulesPanel.add(rule1);
        rulesPanel.add(rule2);
        rulesPanel.add(rule3);
        rulesPanel.add(rule4);
        rulesPanel.add(cookieIconLabel1);
        rulesPanel.add(cookieIconLabel2);
        rulesPanel.add(cookieIconLabel3);
        rulesPanel.add(factoryIconLabel1);
        rulesPanel.add(factoryIconLabel2);
        rulesPanel.add(farmIconLabel1);
        rulesPanel.add(farmIconLabel2);
        rulesPanel.add(storeIconLabel);

        //////////////////////////////////////////////////

        // Game panel
        gamePanel = new JPanel();
        gamePanel.setSize(1000, 600);
        gamePanel.setLayout(null);
        gamePanel.setBackground(new Color(220, 232, 240));

        // Timer for game panel
        timer = new Timer();
        task = new TimerTask()  {  
            public void run()  {  
                cookieCount += cursorInt + grandmaInt + farmInt + factoryInt;
                cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
                if (cookieCount >= 1000000000) {
                    winnerNameLabel.setText(playerNameTextString);
                    winPanel();
                    try {
                        FileWriter myWriter = new FileWriter("winners.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
                        bufferedWriter.write(playerNameTextString + "\n");
                        bufferedWriter.close();
                    } catch (IOException e) {}
                    timer.cancel();
                }
            }  
        };  
        timer.scheduleAtFixedRate(task, 100, 1000);

        // GIFS for game panel
        cookieGif = new ImageIcon(this.getClass().getResource("cookieGIF.gif"));
        gifLabel = new JLabel(cookieGif);
        gifLabel.setBounds(350, 0, 300, 300);

        // Images for game panel
        cookieIconLarge = new ImageIcon("cookieIconLarge.png");
        storeIconLarge = new ImageIcon("storeIconLarge.png");
        cursorPerkIcon = new ImageIcon("cursorIcon.png");
        grandmaPerkIcon = new ImageIcon("grandmaIcon.png");
        farmPerkIcon = new ImageIcon("farmPerkIcon.png");
        factoryPerkIcon = new ImageIcon("factoryPerkIcon.png");

        // Buttons for game panel
        backGameButton = new JButton("BACK");
        backGameButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        backGameButton.setBounds(10, 10, 100, 50);
        backGameButton.addActionListener(this);

        cookieButton = new JButton();
        cookieButton.setIcon(cookieIconLarge);
        cookieButton.setBounds(50, 130, 240, 240);
        cookieButton.setBorderPainted(false);
        cookieButton.setContentAreaFilled(false); 
        cookieButton.setOpaque(true);
        cookieButton.setBackground(new Color(220, 232, 240));
        cookieButton.addActionListener(this);

        cursorPerk = new JButton("CURSOR", cursorPerkIcon);
        cursorPerk.setBounds(700, 165, 210, 90);
        cursorPerk.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        grandmaPerk = new JButton("GRANDMA", grandmaPerkIcon);
        grandmaPerk.setBounds(700, 265, 210, 90);
        grandmaPerk.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        farmPerk = new JButton("FARM", farmPerkIcon);
        farmPerk.setBounds(700, 365, 210, 90);
        farmPerk.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        factoryPerk = new JButton("FACTORY", factoryPerkIcon);
        factoryPerk.setBounds(700, 465, 210, 90);
        factoryPerk.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        cursorPerk.addActionListener(this);
        grandmaPerk.addActionListener(this);
        farmPerk.addActionListener(this);
        factoryPerk.addActionListener(this);
        cursorPerk.addMouseListener(this);
        grandmaPerk.addMouseListener(this);
        farmPerk.addMouseListener(this);
        factoryPerk.addMouseListener(this);

        // Labels for game panel
        cookieCountLabel = new JLabel(cookieCount + " cookies", SwingConstants.CENTER);
        cookieCountLabel.setBounds(0, 70, 340, 40);
        cookieCountLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        storeLargeLabel = new JLabel();
        storeLargeLabel.setIcon(storeIconLarge);
        storeLargeLabel.setBounds(730, 10, 150, 150);

        cursorCount = new JLabel("0", SwingConstants.CENTER);
        cursorCount.setBounds(350, 310, 100, 20);
        cursorCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        grandmaCount = new JLabel("0", SwingConstants.CENTER);
        grandmaCount.setBounds(540, 310, 100, 20);
        grandmaCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        farmCount = new JLabel("0", SwingConstants.CENTER);
        farmCount.setBounds(350, 440, 100, 20);
        farmCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        factoryCount = new JLabel("0", SwingConstants.CENTER);
        factoryCount.setBounds(540, 440, 100, 20);
        factoryCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        cursorCountImage = new JLabel();
        cursorCountImage.setIcon(cursorPerkIcon);
        cursorCountImage.setBounds(370, 340, 80, 80);

        grandmaCountImage = new JLabel();
        grandmaCountImage.setIcon(grandmaPerkIcon);
        grandmaCountImage.setBounds(550, 340, 80, 80);

        farmCountImage = new JLabel();
        farmCountImage.setIcon(farmPerkIcon);
        farmCountImage.setBounds(370, 470, 80, 80);

        factoryCountImage = new JLabel();
        factoryCountImage.setIcon(factoryPerkIcon);
        factoryCountImage.setBounds(550, 470, 80, 80);

        itemName = new JLabel("", SwingConstants.CENTER);
        itemName.setBounds(0, 390, 340, 30);
        itemName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        itemName.setForeground(new Color(255, 128, 0));

        itemCost = new JLabel("", SwingConstants.CENTER);
        itemCost.setBounds(0, 440, 340, 30);
        itemCost.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        itemDesc = new JLabel("", SwingConstants.CENTER);
        itemDesc.setBounds(0, 490, 340, 30);
        itemDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        // Adding components to game panel
        gamePanel.add(backGameButton);
        gamePanel.add(cookieButton);
        gamePanel.add(cookieCountLabel);
        gamePanel.add(storeLargeLabel);
        gamePanel.add(cursorPerk);
        gamePanel.add(grandmaPerk);
        gamePanel.add(farmPerk);
        gamePanel.add(factoryPerk);
        gamePanel.add(gifLabel);
        gamePanel.add(cursorCount);
        gamePanel.add(grandmaCount);
        gamePanel.add(farmCount);
        gamePanel.add(factoryCount);
        gamePanel.add(cursorCountImage);
        gamePanel.add(grandmaCountImage);
        gamePanel.add(farmCountImage);
        gamePanel.add(factoryCountImage);
        gamePanel.add(itemName);
        gamePanel.add(itemCost);
        gamePanel.add(itemDesc);

        ///////////////////////////////////////////////////////////////////

        // Win panel
        winPanel = new JPanel();
        winPanel.setSize(1000, 600);
        winPanel.setLayout(null);

        // Background image for win panel
        winScreen = new ImageIcon("winScreenCookie.jpg");

        // Labels for win panel
        winScreenLabel = new JLabel();
        winScreenLabel.setIcon(winScreen);
        winScreenLabel.setSize(1000, 600);

        winnerLabel = new JLabel("You Win The Game!", SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Zapfino", Font.BOLD, 60));
        winnerLabel.setBounds(0, 70, 1000, 150);
        winnerLabel.setForeground(new Color(102, 255, 178));

        winnerNameLabel = new JLabel(playerNameTextString, SwingConstants.CENTER);
        winnerNameLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
        winnerNameLabel.setBounds(0, 205, 1000, 100);
        winnerNameLabel.setForeground(new Color(0, 153, 153));

        // Buttons for win panel
        quitGameWinScreen = new JButton("QUIT GAME");
        quitGameWinScreen.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        quitGameWinScreen.setBounds(400, 350, 200, 40);
        quitGameWinScreen.addActionListener(this);

        replayButton = new JButton("NEW GAME");
        replayButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        replayButton.setBounds(400, 450, 200, 40);
        replayButton.addActionListener(this);

        // Adding components to win panel
        winPanel.add(quitGameWinScreen);
        winPanel.add(replayButton);
        winPanel.add(winnerLabel);
        winPanel.add(winnerNameLabel);
        winPanel.add(winScreenLabel);
        
        ///////////////////////////////////////////////////////////////////

        // Winners panel
        winnersPanel = new JPanel();
        winnersPanel.setPreferredSize(new Dimension(1000, 2500));
        winnersPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0)));
        winnersPanel.setLayout(null);

        // Labels for winners panel
        winnersTitle = new JLabel("History of Winners");
        winnersTitle.setFont(new Font("Zapfino", Font.BOLD, 50));
        winnersTitle.setForeground(new Color(255, 215, 0));
        winnersTitle.setBounds(200, 30, 800, 80);

        // Buttons for winners panel
        backButtonWinners = new JButton("BACK");
        backButtonWinners.setBounds(10, 10, 100, 50);
        backButtonWinners.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        backButtonWinners.addActionListener(this);

        // Winners panel 2
        winnersPanel2 = new JPanel();
        winnersPanel2.setBounds(0, 140, 1000, 2500);
        winnersPanel2.setLayout(new BoxLayout(winnersPanel2, BoxLayout.Y_AXIS));

        // Adding components to winners panel 2
        readWinnersList();

        // Scrollpane for winners panel
        scrollPane = new JScrollPane(winnersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adding components to winners panel
        winnersPanel.add(winnersTitle);
        winnersPanel.add(backButtonWinners);
        winnersPanel.add(winnersPanel2);

        //////////////////////////////////////////////////////////////////

        // Set visibility of frame and adding components to frame
        menuPanel.setVisible(true);
        rulesPanel.setVisible(false);
        gamePanel.setVisible(false);
        winPanel.setVisible(false);
        scrollPane.setVisible(false);

        frame.add(menuPanel);
        frame.add(rulesPanel);
        frame.add(gamePanel);
        frame.add(winPanel);
        frame.add(scrollPane);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new CookieClicker();
        playMusic();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rulesButton)
            rulesPanel();
        else if (e.getSource() == winnersButton)
            winnersPanel();
        else if (e.getSource() == quitMenuButton)
            System.exit(0);
        else if (e.getSource() == backButtonRules)
            menuPanel();
        else if (e.getSource() == backButtonWinners)
            menuPanel();
        else if (e.getSource() == playButton) {
            playerNameTextString = playerNameTextBox.getText();
            if (playerNameTextString.length() > 0 && playerNameTextString.length() < 30 && !playerNameTextString.equals("ENTER A NAME")) {
                permPlayerName.setText(playerNameTextString);
                menuPanel.remove(playerNameTextBox);
                menuPanel.remove(backgroundPic);
                menuPanel.add(permPlayerName);
                menuPanel.add(backgroundPic);
                playButton.setText("RESUME");
                playButton.setBounds(445, 340, 110, 40);
                gamePanel();
            } else {
                playerNameTextBox.setText("ENTER A NAME");
            }
        } else if (e.getSource() == backGameButton) {
            menuPanel();
        } else if (e.getSource() == cookieButton) {
            cookieCount++;
            cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
        } else if (e.getSource() == cursorPerk && cookieCount >= 25) {
            cursorInt++;
            cursorCount.setText(Integer.toString(++cursorNum));
            cookieCount -= 25;
            cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
        } else if (e.getSource() == grandmaPerk && cookieCount >= 1000) {
            grandmaInt += 50;
            grandmaCount.setText(Integer.toString(++grandmaNum));
            cookieCount -= 1000;
            cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
        } else if (e.getSource() == farmPerk && cookieCount >= 75000) {
            farmInt += 5000;
            farmCount.setText(Integer.toString(++farmNum));
            cookieCount -= 75000;
            cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
        } else if (e.getSource() == factoryPerk && cookieCount >= 2000000) {
            factoryInt += 200000;
            factoryCount.setText(Integer.toString(++factoryNum));
            cookieCount -= 2000000;
            cookieCountLabel.setText(String.format("%,d cookies", cookieCount));
        } else if (e.getSource() == quitGameWinScreen){
            System.exit(0);
        } else if (e.getSource() == replayButton){
            new CookieClicker();
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == cursorPerk){
            itemName.setText("CURSOR");
            itemCost.setText("Costs 25 Cookies");
            itemDesc.setText("Gain 1 Cookie/Second");
        } else if (e.getSource() == grandmaPerk) {
            itemName.setText("GRANDMA");
            itemCost.setText("Costs 1,000 Cookies");
            itemDesc.setText("Gain 50 Cookies/Second");
        } else if (e.getSource() == farmPerk) {
            itemName.setText("FARM");
            itemCost.setText("Costs 75,000 Cookies");
            itemDesc.setText("Gain 5,000 Cookies/Second");
        } else if (e.getSource() == factoryPerk) {
            itemName.setText("FACTORY");
            itemCost.setText("Costs 2,000,000 Cookies");
            itemDesc.setText("Gain 200,000 Cookies/Second");
        }
    }

    public void mouseExited(MouseEvent e) {
        itemName.setText("");
        itemCost.setText("");
        itemDesc.setText("");
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}

    public void menuPanel() {
        // Turning off panels
        rulesPanel.setVisible(false);
        scrollPane.setVisible(false);
        gamePanel.setVisible(false);
        winPanel.setVisible(false);

        // Turning on panels
        menuPanel.setVisible(true);
    }

    public void rulesPanel() {
        // Turning off panels
        menuPanel.setVisible(false);
        scrollPane.setVisible(false);
        gamePanel.setVisible(false);
        winPanel.setVisible(false);

        // Turning on panels
        rulesPanel.setVisible(true);
    }

    public void winnersPanel() {
        // Turning off panels
        rulesPanel.setVisible(false);
        menuPanel.setVisible(false);
        gamePanel.setVisible(false);
        winPanel.setVisible(false);
        
        // Turning on panels
        scrollPane.setVisible(true);
    }
     
    public void gamePanel() {
        // Turning off panels
        rulesPanel.setVisible(false);
        scrollPane.setVisible(false);
        menuPanel.setVisible(false);
        winPanel.setVisible(false);

        // Turning on panels
        gamePanel.setVisible(true);
    }

    public void winPanel() {
        // Turning off panels
        rulesPanel.setVisible(false);
        scrollPane.setVisible(false);
        menuPanel.setVisible(false);
        gamePanel.setVisible(false);

        // Turning on panels
        winPanel.setVisible(true);
    }

    public static void playMusic() {
        try {
            File musicFile = new File("Kawaii!.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            audioClip.start();
        } catch (Exception e) {}
    }

    public void readWinnersList() {
        // Labels for winners panel 2
        try {
            FileReader myReader = new FileReader("winners.txt");
            BufferedReader bufferedReader = new BufferedReader(myReader);
            String lineString;
            while ((lineString = bufferedReader.readLine()) != null) {
                tempWinner = new JLabel(lineString);
                tempWinner.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
                tempWinner.setAlignmentX(Component.CENTER_ALIGNMENT);
                winnersPanel2.add(tempWinner);
                winnersPanel2.add(Box.createRigidArea(new Dimension(0, 25)));
            }
            bufferedReader.close();
        } catch (Exception e) {}
    }
}
