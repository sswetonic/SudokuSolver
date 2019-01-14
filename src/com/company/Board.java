package com.company;
import java.util.*;
import java.io.*;

public class Board {

    private ArrayList<ArrayList<Character>> ar = new ArrayList<>();

    public Board(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            ArrayList<Character> row = new ArrayList<>();
            String line1 = sc.nextLine();
            for(int i = 0; i < line1.length(); i++) {
                row.add(line1.charAt(i));
            }
            ar.add(row);
        }
    }

    public String toString() {
        String toReturn = "";
        for(ArrayList<Character> val : ar) {
            for(int i = 0; i < val.size(); i++) {
                toReturn += val.get(i) + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
