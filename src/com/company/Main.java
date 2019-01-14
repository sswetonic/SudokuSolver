package com.company;
import java.io.*;



public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        File boardFile = new File("src/board.sdk");

        Board b = new Board(boardFile);
        System.out.println(b);

    }
}
