package nz.ac.aut.ense701.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameEventListener;
import nz.ac.aut.ense701.gameModel.GameState;
import nz.ac.aut.ense701.gameModel.MoveDirection;

/*
 * User interface form for Kiwi Island.
 * 
 * @author Moses
 * @version March 2017
 */

public class KiwiCountUI 
    extends javax.swing.JFrame 
    implements GameEventListener, ActionListener
{

    /**
     * Creates a GUI for the KiwiIsland game.
     */
    public KiwiCountUI() 
    {
        initComponents();
    }
    
    
    public void startGame(String mapFileLocation){
        
        this.game = new Game(mapFileLocation);
        setAsGameListener();
        initIslandGrid();
        update();
    }
    
    /**
     * This method is called by the game model every time something changes.
     * Trigger an update.
     */
    @Override
    public void gameStateChanged()
    {
        
        
        update();
        
        // check for "game over" or "game won"
        if ( game.getState() == GameState.LOST || game.getState() == GameState.TIME_OVER)
        {
                
            JOptionPane.showMessageDialog(
                    this, 
                    game.getLoseMessage(), "Game over!",
                    JOptionPane.INFORMATION_MESSAGE);
            
            //Remove all componets from the game panel and allow user to start new game the game
            pnlIsland.removeAll();
            jButtonStartGame.setEnabled(true);
            jButtonStopGame.setEnabled(false);
            
            stopTimer = true; //Stop the timer
        }
        else if ( game.getState() == GameState.WON )
        {
            JOptionPane.showMessageDialog(
                    this, 
                    game.getWinMessage(), "Game Won!",
                    JOptionPane.INFORMATION_MESSAGE);
            //Remove all componets from the game panel and restart the game
            pnlIsland.removeAll();
            jButtonStartGame.setEnabled(true);
            jButtonStopGame.setEnabled(false);
            stopTimer = true; //Stop the timer
            
        }
        else if (game.messageForPlayer())
        {
            JOptionPane.showMessageDialog(
                    this, 
                    game.getPlayerMessage(), "Important Information",
                    JOptionPane.INFORMATION_MESSAGE);   
        }
    }
    
     private void setAsGameListener()
    {
       game.addGameEventListener(this); 
    }
     
    /**
     * Updates the state of the UI based on the state of the game.
     */
    private void update()
    {
        // update the grid square panels
        Component[] components = pnlIsland.getComponents();
        for ( Component c : components )
        {
            // all components in the panel are GridSquarePanels,
            // so we can safely cast
            GridSquarePanel gsp = (GridSquarePanel) c;
            gsp.update();
        }
        
        // update player information
        int[] playerValues = game.getPlayerValues();
        txtPlayerName.setText(game.getPlayerName());
        progPlayerStamina.setMaximum(playerValues[Game.MAXSTAMINA_INDEX]);
        progPlayerStamina.setValue(playerValues[Game.STAMINA_INDEX]);
        progBackpackWeight.setMaximum(playerValues[Game.MAXWEIGHT_INDEX]);
        progBackpackWeight.setValue(playerValues[Game.WEIGHT_INDEX]);
        progBackpackSize.setMaximum(playerValues[Game.MAXSIZE_INDEX]);
        progBackpackSize.setValue(playerValues[Game.SIZE_INDEX]);
        
        //Update Kiwi and Predator information
        txtKiwisCounted.setText(Integer.toString(game.getKiwiCount()) );
        txtPredatorsLeft.setText(Integer.toString(game.getPredatorsRemaining()));
        
        // update inventory list
        listInventory.setListData(game.getPlayerInventory());
        listInventory.clearSelection();
        listInventory.setToolTipText(null);
        btnUse.setEnabled(false);
        btnDrop.setEnabled(false);
        
        // update list of visible objects
        listObjects.setListData(game.getOccupantsPlayerPosition());
        listObjects.clearSelection();
        listObjects.setToolTipText(null);
        btnCollect.setEnabled(false);
        btnCount.setEnabled(false);
        
        // update movement buttons
        btnMoveNorth.setEnabled(game.isPlayerMovePossible(MoveDirection.NORTH));
        btnMoveEast.setEnabled( game.isPlayerMovePossible(MoveDirection.EAST));
        btnMoveSouth.setEnabled(game.isPlayerMovePossible(MoveDirection.SOUTH));
        btnMoveWest.setEnabled( game.isPlayerMovePossible(MoveDirection.WEST));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        javax.swing.JPanel pnlContent = new javax.swing.JPanel();
        pnlIsland = new javax.swing.JPanel();
        javax.swing.JPanel pnlControls = new javax.swing.JPanel();
        javax.swing.JPanel pnlMovement = new javax.swing.JPanel();
        btnMoveNorth = new javax.swing.JButton();
        btnMoveSouth = new javax.swing.JButton();
        btnMoveEast = new javax.swing.JButton();
        btnMoveWest = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JPanel pnlInventory = new javax.swing.JPanel();
        javax.swing.JScrollPane scrlInventory = new javax.swing.JScrollPane();
        listInventory = new javax.swing.JList();
        btnDrop = new javax.swing.JButton();
        btnUse = new javax.swing.JButton();
        javax.swing.JPanel pnlPlayer = new javax.swing.JPanel();
        javax.swing.JPanel pnlPlayerData = new javax.swing.JPanel();
        javax.swing.JLabel lblPlayerName = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JLabel();
        javax.swing.JLabel lblPlayerStamina = new javax.swing.JLabel();
        progPlayerStamina = new javax.swing.JProgressBar();
        javax.swing.JLabel lblBackpackWeight = new javax.swing.JLabel();
        progBackpackWeight = new javax.swing.JProgressBar();
        javax.swing.JLabel lblBackpackSize = new javax.swing.JLabel();
        progBackpackSize = new javax.swing.JProgressBar();
        lblPredators = new javax.swing.JLabel();
        lblKiwisCounted = new javax.swing.JLabel();
        txtKiwisCounted = new javax.swing.JLabel();
        txtPredatorsLeft = new javax.swing.JLabel();
        javax.swing.JPanel pnlGameOptions = new javax.swing.JPanel();
        jMapImage1 = new javax.swing.JLabel();
        jMapImage2 = new javax.swing.JLabel();
        jMapImage3 = new javax.swing.JLabel();
        jMapRandom = new javax.swing.JLabel();
        jMapImage5 = new javax.swing.JLabel();
        jMapImage4 = new javax.swing.JLabel();
        jRadioWhangarei = new javax.swing.JRadioButton();
        jRadioMoehau = new javax.swing.JRadioButton();
        jRadioTongariro = new javax.swing.JRadioButton();
        jRadioOkarito = new javax.swing.JRadioButton();
        jRadioHaast = new javax.swing.JRadioButton();
        jRadioRand = new javax.swing.JRadioButton();
        jLabelSelectGameMode = new javax.swing.JLabel();
        jRadioBtnRelax = new javax.swing.JRadioButton();
        jRadioBtnChallenge = new javax.swing.JRadioButton();
        selectGameMap = new javax.swing.JLabel();
        jButtonStartGame = new javax.swing.JButton();
        jButtonStopGame = new javax.swing.JButton();
        javax.swing.JPanel pnlDescription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        javax.swing.JPanel pnlObjects = new javax.swing.JPanel();
        javax.swing.JScrollPane scrlObjects = new javax.swing.JScrollPane();
        listObjects = new javax.swing.JList();
        btnCollect = new javax.swing.JButton();
        btnCount = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonHelp = new javax.swing.JButton();
        gameProgressBar = new javax.swing.JProgressBar();
        jLabelGameTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kiwi Count");

        pnlContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlContent.setLayout(new java.awt.BorderLayout(10, 0));

        javax.swing.GroupLayout pnlIslandLayout = new javax.swing.GroupLayout(pnlIsland);
        pnlIsland.setLayout(pnlIslandLayout);
        pnlIslandLayout.setHorizontalGroup(
            pnlIslandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1172, Short.MAX_VALUE)
        );
        pnlIslandLayout.setVerticalGroup(
            pnlIslandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        pnlContent.add(pnlIsland, java.awt.BorderLayout.CENTER);

        pnlMovement.setBorder(javax.swing.BorderFactory.createTitledBorder("Movement"));
        pnlMovement.setLayout(new java.awt.GridBagLayout());

        btnMoveNorth.setText("N");
        btnMoveNorth.setFocusable(false);
        btnMoveNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveNorthActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMovement.add(btnMoveNorth, gridBagConstraints);

        btnMoveSouth.setText("S");
        btnMoveSouth.setFocusable(false);
        btnMoveSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveSouthActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMovement.add(btnMoveSouth, gridBagConstraints);

        btnMoveEast.setText("E");
        btnMoveEast.setFocusable(false);
        btnMoveEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveEastActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMovement.add(btnMoveEast, gridBagConstraints);

        btnMoveWest.setText("W");
        btnMoveWest.setFocusable(false);
        btnMoveWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveWestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMovement.add(btnMoveWest, gridBagConstraints);
        pnlMovement.add(jSeparator1, new java.awt.GridBagConstraints());
        pnlMovement.add(jSeparator2, new java.awt.GridBagConstraints());

        pnlInventory.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventory"));
        pnlInventory.setLayout(new java.awt.GridBagLayout());

        listInventory.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listInventory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listInventory.setVisibleRowCount(3);
        listInventory.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listInventoryValueChanged(evt);
            }
        });
        scrlInventory.setViewportView(listInventory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlInventory.add(scrlInventory, gridBagConstraints);

        btnDrop.setText("Drop");
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlInventory.add(btnDrop, gridBagConstraints);

        btnUse.setText("Use");
        btnUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlInventory.add(btnUse, gridBagConstraints);

        pnlPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Player"));
        pnlPlayer.setLayout(new java.awt.BorderLayout());

        pnlPlayerData.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlPlayerData.setLayout(new java.awt.GridBagLayout());

        lblPlayerName.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        pnlPlayerData.add(lblPlayerName, gridBagConstraints);

        txtPlayerName.setText("Player Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPlayerData.add(txtPlayerName, gridBagConstraints);

        lblPlayerStamina.setText("Stamina:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlPlayerData.add(lblPlayerStamina, gridBagConstraints);

        progPlayerStamina.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        pnlPlayerData.add(progPlayerStamina, gridBagConstraints);

        lblBackpackWeight.setText("Backpack Weight:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlPlayerData.add(lblBackpackWeight, gridBagConstraints);

        progBackpackWeight.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        pnlPlayerData.add(progBackpackWeight, gridBagConstraints);

        lblBackpackSize.setText("Backpack Size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlPlayerData.add(lblBackpackSize, gridBagConstraints);

        progBackpackSize.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        pnlPlayerData.add(progBackpackSize, gridBagConstraints);

        lblPredators.setText("Predators Left:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlPlayerData.add(lblPredators, gridBagConstraints);

        lblKiwisCounted.setText("Kiwis Counted :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlPlayerData.add(lblKiwisCounted, gridBagConstraints);

        txtKiwisCounted.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlPlayerData.add(txtKiwisCounted, gridBagConstraints);

        txtPredatorsLeft.setText("P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlPlayerData.add(txtPredatorsLeft, gridBagConstraints);

        pnlPlayer.add(pnlPlayerData, java.awt.BorderLayout.CENTER);

        pnlGameOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Options"));

        jMapImage1.setBackground(new java.awt.Color(255, 255, 255));
        jMapImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/Whangarei.png"))); // NOI18N

        jMapImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/Moehau.png"))); // NOI18N
        jMapImage2.setMaximumSize(new java.awt.Dimension(716, 333));

        jMapImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/Tongariro.png"))); // NOI18N

        jMapRandom.setText("    Random Map");

        jMapImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/Haast.png"))); // NOI18N

        jMapImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/Okarito.png"))); // NOI18N

        buttonGroup1.add(jRadioWhangarei);
        jRadioWhangarei.setText("Whangarei");
        jRadioWhangarei.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioWhangarei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWhangareiActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioMoehau);
        jRadioMoehau.setText("Moehau");
        jRadioMoehau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMoehauActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioTongariro);
        jRadioTongariro.setText("Tongariro");

        buttonGroup1.add(jRadioOkarito);
        jRadioOkarito.setText("Okarito");
        jRadioOkarito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioOkaritoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioHaast);
        jRadioHaast.setText("Haast");

        buttonGroup1.add(jRadioRand);
        jRadioRand.setSelected(true);
        jRadioRand.setText("Random");
        jRadioRand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRandActionPerformed(evt);
            }
        });

        jLabelSelectGameMode.setText("Select Game Mode");

        buttonGroup2.add(jRadioBtnRelax);
        jRadioBtnRelax.setSelected(true);
        jRadioBtnRelax.setLabel("Relax Mode");

        buttonGroup2.add(jRadioBtnChallenge);
        jRadioBtnChallenge.setText("Challenge Mode");

        selectGameMap.setText("Select Game Map");

        jButtonStartGame.setText("START GAME");
        jButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGameActionPerformed(evt);
            }
        });

        jButtonStopGame.setText("END GAME");
        jButtonStopGame.setEnabled(false);
        jButtonStopGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGameOptionsLayout = new javax.swing.GroupLayout(pnlGameOptions);
        pnlGameOptions.setLayout(pnlGameOptionsLayout);
        pnlGameOptionsLayout.setHorizontalGroup(
            pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonStartGame)
                            .addComponent(jRadioBtnRelax)))
                    .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jMapImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jMapImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMapImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioTongariro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioWhangarei)
                            .addComponent(jRadioMoehau))))
                .addGap(5, 5, 5)
                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMapRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMapImage5)
                                    .addComponent(jMapImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioOkarito)
                                    .addComponent(jRadioHaast)
                                    .addComponent(jRadioRand)))
                            .addComponent(jRadioBtnChallenge))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameOptionsLayout.createSequentialGroup()
                        .addComponent(jButtonStopGame)
                        .addGap(51, 51, 51))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameOptionsLayout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(selectGameMap)
                .addGap(156, 156, 156))
            .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabelSelectGameMode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGameOptionsLayout.setVerticalGroup(
            pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                .addComponent(selectGameMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioOkarito)
                            .addComponent(jMapImage4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMapImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioMoehau)
                                .addComponent(jRadioHaast)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMapRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioRand)
                            .addComponent(jRadioTongariro)))
                    .addGroup(pnlGameOptionsLayout.createSequentialGroup()
                        .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMapImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioWhangarei))
                        .addGap(18, 18, 18)
                        .addComponent(jMapImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMapImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabelSelectGameMode, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioBtnRelax)
                    .addComponent(jRadioBtnChallenge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGameOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStartGame)
                    .addComponent(jButtonStopGame)))
        );

        jLabelSelectGameMode.getAccessibleContext().setAccessibleDescription("");
        selectGameMap.getAccessibleContext().setAccessibleDescription("");

        pnlDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        pnlDescription.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTextPane1);

        pnlDescription.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlObjects.setBorder(javax.swing.BorderFactory.createTitledBorder("Objects"));
        java.awt.GridBagLayout pnlObjectsLayout = new java.awt.GridBagLayout();
        pnlObjectsLayout.columnWidths = new int[] {0, 5, 0};
        pnlObjectsLayout.rowHeights = new int[] {0, 5, 0};
        pnlObjects.setLayout(pnlObjectsLayout);

        listObjects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listObjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listObjects.setVisibleRowCount(3);
        listObjects.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listObjectsValueChanged(evt);
            }
        });
        scrlObjects.setViewportView(listObjects);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlObjects.add(scrlObjects, gridBagConstraints);

        btnCollect.setText("Collect");
        btnCollect.setToolTipText("");
        btnCollect.setMaximumSize(new java.awt.Dimension(61, 23));
        btnCollect.setMinimumSize(new java.awt.Dimension(61, 23));
        btnCollect.setPreferredSize(new java.awt.Dimension(61, 23));
        btnCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlObjects.add(btnCollect, gridBagConstraints);

        btnCount.setText("Count");
        btnCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlObjects.add(btnCount, gridBagConstraints);

        javax.swing.GroupLayout pnlControlsLayout = new javax.swing.GroupLayout(pnlControls);
        pnlControls.setLayout(pnlControlsLayout);
        pnlControlsLayout.setHorizontalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlControlsLayout.createSequentialGroup()
                        .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlControlsLayout.createSequentialGroup()
                                .addComponent(pnlInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlControlsLayout.createSequentialGroup()
                                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlMovement, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(pnlPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlGameOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlControlsLayout.setVerticalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlControlsLayout.createSequentialGroup()
                        .addComponent(pnlPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(pnlMovement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlGameOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlObjects, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );

        pnlGameOptions.getAccessibleContext().setAccessibleDescription("");

        pnlContent.add(pnlControls, java.awt.BorderLayout.EAST);

        jButtonHelp.setText("HELP");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        gameProgressBar.setStringPainted(true);

        jLabelGameTime.setText("Game Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 1081, Short.MAX_VALUE)
                .addComponent(jLabelGameTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gameProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(532, 532, 532)
                .addComponent(jButtonHelp))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGameTime)
                    .addComponent(jButtonHelp)
                    .addComponent(gameProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabelGameTime.getAccessibleContext().setAccessibleName("jLabelGameTime");

        pnlContent.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoveEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveEastActionPerformed
        game.playerMove(MoveDirection.EAST);
    }//GEN-LAST:event_btnMoveEastActionPerformed

    private void btnMoveNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveNorthActionPerformed
        game.playerMove(MoveDirection.NORTH);
    }//GEN-LAST:event_btnMoveNorthActionPerformed

    private void btnMoveSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveSouthActionPerformed
        game.playerMove(MoveDirection.SOUTH);
    }//GEN-LAST:event_btnMoveSouthActionPerformed

    private void btnMoveWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveWestActionPerformed
        game.playerMove(MoveDirection.WEST);
    }//GEN-LAST:event_btnMoveWestActionPerformed

    private void btnCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectActionPerformed
        Object obj = listObjects.getSelectedValue();
        game.collectItem(obj);
    }//GEN-LAST:event_btnCollectActionPerformed

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        game.dropItem(listInventory.getSelectedValue());
    }//GEN-LAST:event_btnDropActionPerformed

    private void listObjectsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listObjectsValueChanged
        Object occ = listObjects.getSelectedValue();
        if ( occ != null )
        {
            btnCollect.setEnabled(game.canCollect(occ));
            btnCount.setEnabled(game.canCount(occ));
            listObjects.setToolTipText(game.getOccupantDescription(occ));
        }
    }//GEN-LAST:event_listObjectsValueChanged

    private void btnUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseActionPerformed
        game.useItem( listInventory.getSelectedValue());
    }//GEN-LAST:event_btnUseActionPerformed

    private void listInventoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listInventoryValueChanged
        Object item =  listInventory.getSelectedValue();
        btnDrop.setEnabled(true);
        if ( item != null )
        {
            btnUse.setEnabled(game.canUse(item));
            listInventory.setToolTipText(game.getOccupantDescription(item));
        }
    }//GEN-LAST:event_listInventoryValueChanged

    private void btnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountActionPerformed
        game.countKiwi();
    }//GEN-LAST:event_btnCountActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handlingpublic static void listDictionary()throws IOException
        //This button will open up the "help.txt" file from the project folder and display the game rules as
        // a Message Dialog
        
        File file = new File("help.txt");
        String contents = null;
        try {
             contents = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KiwiCountUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(this, 
                    contents, "Game Information",
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jRadioWhangareiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioWhangareiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioWhangareiActionPerformed

    private void jRadioMoehauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioMoehauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioMoehauActionPerformed

    private void jRadioOkaritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioOkaritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioOkaritoActionPerformed

    private void jButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGameActionPerformed
        
        //Check Map Selection
        jRadioHaast.setActionCommand("Whangarei.txt");
        jRadioWhangarei.setActionCommand("Whangarei.txt");
        jRadioOkarito.setActionCommand("Whangarei.txt");
        jRadioTongariro.setActionCommand("Whangarei.txt");
        jRadioRand.setActionCommand("Whangarei.txt");
        jRadioMoehau.setActionCommand("Moehau.txt");
        
        userMapSelection = buttonGroup1.getSelection().getActionCommand();
        
        //CCheck Game mode selection
        jRadioBtnChallenge.setActionCommand("challenge");
        jRadioBtnRelax.setActionCommand("relax");
        String mode = buttonGroup2.getSelection().getActionCommand();
        
        gameChallengeMode = mode.contentEquals("challenge");
        
        //If Challenge mode is selected, Start timer until 5 minutes 
        if(gameChallengeMode){
            
            jLabelGameTime.setVisible(true);
            gameProgressBar.setVisible(true);
            
             
             timeElapsed = 0;
             timer = new Timer(3000, this);
             timer.start();
             stopTimer = false; //set Boolean to stop timer to false until
             
        }
        else{
                jLabelGameTime.setVisible(false);
                gameProgressBar.setVisible(false);
            }
        
        //Start the game grid based on the user selection of location and game mode
        startGame(userMapSelection);
        
        jButtonStartGame.setEnabled(false);
        jButtonStopGame.setEnabled(true);
    }//GEN-LAST:event_jButtonStartGameActionPerformed

    private void jRadioRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioRandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioRandActionPerformed

    private void jButtonStopGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopGameActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to end the Game?", "End Game",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION)
                        {
                            pnlIsland.removeAll();
                            jButtonStartGame.setEnabled(true); //Enable the Start Game Button
                            jButtonStopGame.setEnabled(false); //Disable the Stop Game Button
                            
                            //Hide the time Display
                            jLabelGameTime.setVisible(false); 
                            gameProgressBar.setVisible(false);
                            
                            if(gameChallengeMode){
                                timer.stop();
                                gameProgressBar.setValue(0);
                                timeElapsed = 0; //reset the time elapsed
                            }
                        } 
    }//GEN-LAST:event_jButtonStopGameActionPerformed
    
    /**
     * Creates and initialises the island grid.
     */
    private void initIslandGrid()
    {
        // Add the grid
        int rows    = game.getNumRows();
        int columns = game.getNumColumns();
        // set up the layout manager for the island grid panel
        pnlIsland.setLayout(new GridLayout(rows, columns));
        // create all the grid square panels and add them to the panel
        // the layout manager of the panel takes care of assigning them to the
        // the right position
        for ( int row = 0 ; row < rows ; row++ )
        {
            for ( int col = 0 ; col < columns ; col++ )
            {
                pnlIsland.add(new GridSquarePanel(game, row, col));
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollect;
    private javax.swing.JButton btnCount;
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnMoveEast;
    private javax.swing.JButton btnMoveNorth;
    private javax.swing.JButton btnMoveSouth;
    private javax.swing.JButton btnMoveWest;
    private javax.swing.JButton btnUse;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JProgressBar gameProgressBar;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JButton jButtonStopGame;
    private javax.swing.JLabel jLabelGameTime;
    private javax.swing.JLabel jLabelSelectGameMode;
    private javax.swing.JLabel jMapImage1;
    private javax.swing.JLabel jMapImage2;
    private javax.swing.JLabel jMapImage3;
    private javax.swing.JLabel jMapImage4;
    private javax.swing.JLabel jMapImage5;
    private javax.swing.JLabel jMapRandom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioBtnChallenge;
    private javax.swing.JRadioButton jRadioBtnRelax;
    private javax.swing.JRadioButton jRadioHaast;
    private javax.swing.JRadioButton jRadioMoehau;
    private javax.swing.JRadioButton jRadioOkarito;
    private javax.swing.JRadioButton jRadioRand;
    private javax.swing.JRadioButton jRadioTongariro;
    private javax.swing.JRadioButton jRadioWhangarei;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblKiwisCounted;
    private javax.swing.JLabel lblPredators;
    private javax.swing.JList listInventory;
    private javax.swing.JList listObjects;
    private javax.swing.JPanel pnlIsland;
    private javax.swing.JProgressBar progBackpackSize;
    private javax.swing.JProgressBar progBackpackWeight;
    private javax.swing.JProgressBar progPlayerStamina;
    private javax.swing.JLabel selectGameMap;
    private javax.swing.JLabel txtKiwisCounted;
    private javax.swing.JLabel txtPlayerName;
    private javax.swing.JLabel txtPredatorsLeft;
    // End of variables declaration//GEN-END:variables

    private Game game;
    private Boolean gameChallengeMode, stopTimer;
    private String userMapSelection;    
    //Variable used to recorde the game time
    private Integer timeElapsed;
    private Timer timer;

    
    /**
     * This listener is used to track the game time and update the game time left as a progress bar in the GUI 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameChallengeMode){
            
            if(timeElapsed<100){
                if(!stopTimer){
                    timeElapsed++;
                    gameProgressBar.setValue(timeElapsed);
                }
            }
            else{
                game.setGameTimeUp(true); //Inform the Game class to chage GameState to "TIME_UP" by setting this property to "true"
                timer.stop(); //Stop the time
                //update game state
                game.checkGameTimeOver();
            }
        }     
    }
}
