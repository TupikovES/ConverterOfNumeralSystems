package com.samgtu.cons.util;

import javax.swing.*;

/**
 * Created by x3mib_000 on 29.10.2015.
 * Вспомогательный класс
 *
 */
public class SwingConsole {
    public static void run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }
}
