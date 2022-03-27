package GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Movements extends KeyAdapter implements ActionListener {

    private final HashSet<String> keys = new HashSet<String>();

        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_UP -> keys.add("UP");
                case KeyEvent.VK_DOWN -> keys.add("DOWN");
            }
        }

        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_UP -> keys.remove("UP");
                case KeyEvent.VK_DOWN -> keys.remove("DOWN");
            }
        }

    public void actionPerformed(ActionEvent e) {

    }
}
