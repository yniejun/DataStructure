package com.examples;

import java.io.*;
import java.util.HashMap;

public class FileSort {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("a"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b"),"utf-8");
        BufferedWriter bw = new BufferedWriter(new FileWriter("b"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] list = line.split(".");
            map.put(list[0], list[1]);
        }
        for (String key: map.keySet()){
            String value = map.get(key);
            bw.write(value);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
