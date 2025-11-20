/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventorigudang.gudang;

import inventorigudang.GUI.MainMenu;

/**
 *
 * @author ASUS
 */
public class MainApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
    
}
