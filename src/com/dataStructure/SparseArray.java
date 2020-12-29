package com.dataStructure;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        //1. initial list 11*11
        //0: null  1: black 2: blue
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 2. to sparse array
        // 2.1. traverse initial 2D list, get numbers of items not equal to 0
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                }
            }
        }
        // 2.2. create sparse array[cause already know the scale]
        int sparseArr[][] = new int[count][3];
        // 2.3. assign value and save file
        // 2.4. save file
        File file = new File("sparseArray");
        FileWriter write = null;
        try {
            write = new FileWriter(file);
            write.write(11 + "\t" + 11 + "\t" + count + "\n");
            int k = 0;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    if (chessArr1[i][j] != 0) {
                        sparseArr[k][0] = i;
                        sparseArr[k][1] = j;
                        sparseArr[k][2] = chessArr1[i][j];
                        write.write(sparseArr[k][0] + "\t" + sparseArr[k][1] + "\t" + sparseArr[k][2] + "\n");
                        k++;
                    }
                }
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. back to list
        // 3.1. read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // 3.2. create
            String sparseStr = reader.readLine();
            String size[] = sparseStr.split("\t");
            int sizeX = Integer.parseInt(size[0]);
            int sizeY = Integer.parseInt(size[1]);
            int chessArr2[][] = new int[sizeX][sizeY];
            while ((sparseStr = reader.readLine()) != null) {
                // 3.3. assign value
                String chess[] = sparseStr.split("\t");
                int x = Integer.parseInt(chess[0]);
                int y = Integer.parseInt(chess[0]);
                chessArr2[x][y] = Integer.parseInt(chess[0]);
            }
            // check
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    System.out.print(chessArr2[i][j] + " ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
