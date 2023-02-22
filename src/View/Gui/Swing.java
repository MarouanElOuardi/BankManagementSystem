package View.Gui;


import Dao.DbFile;
import Model.Banque;
import View.Gui.Frames.LoginFrame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Swing {
    public static void run() throws IOException {
        Banque banque = new Banque("Emsi Bank", "Emsi@Banque.com");
        DbFile.init();
        DbFile.seed();
        DbFile.load(banque);
        new LoginFrame(banque);
    }
}
