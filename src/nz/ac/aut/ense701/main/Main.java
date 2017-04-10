package nz.ac.aut.ense701.main;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gui.KiwiCountUI;

/**
 * Kiwi Count Project
 * @author Moses
 * @version March 2017
 */
public class Main 
{
    /**
     * Main method of Kiwi Count.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        // create the GUI for the game
        final KiwiCountUI  gui  = new KiwiCountUI();
        // make the GUI visible
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                gui.setVisible(true);
            }
        });
    }

}
