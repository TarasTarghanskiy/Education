package basic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        try {
            program.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

