/*
 * Copyright 2023 Bohdan Brukhovets
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package root.gui;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */

import root.model.DatePrinter;
import root.model.Finish;
import root.model.UserIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class GameWindow extends JFrame implements DatePrinter, UserIn, Finish {

    private static final int FONT_SIZE = 35;

    private static final int CELL_SIZE = 75;

    private int clickedNumber;

    public GameWindow() {
        super("Guess the number");
        setSystemLookAndFeel();
        setLayout(new GridLayout(2, 5));
        createGameTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        displayInTheMiddleOfTheScreen();
    }

    private void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | UnsupportedLookAndFeelException |
                IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void createGameTable() {
        for (int i = 0; i < 10; i++) {
            final JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font(Font.SERIF, Font.PLAIN, FONT_SIZE));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setText(String.valueOf(i));
            add(label);
            final int number = i;
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent unused) {
                    synchronized (GameWindow.this) {
                        clickedNumber = number;
                        GameWindow.this.notifyAll();
                    }
                }
            });
        }
    }

    private void displayInTheMiddleOfTheScreen() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
    }

    // ВОТ ЭТОТ МЕТОД ИСПОЛЬЗУЙТЕ ДЛЯ ВЫВОДА ВСЕХ СООБЩЕНИЙ ПОЛЬЗОВАТЕЛЮ!!!
    public void printInfoMessage(final String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public void win() {
        printInfoMessage("Congratulations, you guessed the number!");
    }

    @Override
    public void bigger(int i) {
        printInfoMessage("number < " + i + ". Try again");
    }

    @Override
    public void less(int i) {
        printInfoMessage("number > " + i + ". Try again");

    }

    @Override
    public void fault() {
// Nothing to do
    }

    @Override
    public void showeInstructions() {
        printInfoMessage("Please try to guess number 0 to 9");

    }

    @Override
    public void end() {
        System.exit(0);
    }

    @Override
    public int getNumber() {
        synchronized (this) {
            try {
                wait();
            } catch (final InterruptedException exception) {
                exception.printStackTrace();
                System.exit(2);
            }
        }
        return clickedNumber;
    }
}

