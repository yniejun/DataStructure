package com.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class recursion {
    public static void main(String[] args) {
//        maze m = new maze();
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(m.map[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println(m.findBestWay(1, 1));

//        if (m.findWay(1, 1)) {
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 7; j++) {
//                    System.out.print(m.map[i][j] + " ");
//                }
//                System.out.println("");
//            }
//        }
        System.out.println(solveNQueens(1));
    }
    public static List<List<String>> solveNQueens(int n) {
        Queen queen = new Queen(n);
        queen.findSolution();
        return queen.list;
    }
}

class maze {
    public int[][] map = new int[8][7];
    public int wall = 1;
    public int space = 0;
    public int path = 2;
    public int door = 3;
    public int fail_path = 4;

    public maze() {
        for (int i = 0; i < 7; i++) {
            map[0][i] = wall;
            map[7][i] = wall;
        }
        for (int i = 0; i < 6; i++) {
            map[i][0] = wall;
            map[i][6] = wall;
        }
        map[3][1] = wall;
        map[3][2] = wall;
        map[6][5] = door;
    }

    public boolean findWay(int i, int j) {
        if (map[i][j] == door) {
            return true;
        }
        if (i >= 6 && j >= 5) {
            return false;
        }
        if (map[i][j] == space) {
            map[i][j] = path;
            if (findWay(i, j + 1)) {
                return true;
            } else if (findWay(i + 1, j)) {
                return true;
            } else if (findWay(i - 1, j)) {
                return true;
            } else if (findWay(i, j - 1)) {
                return true;
            } else {
                map[i][j] = fail_path;
                return false;
            }
        }
        return false;
    }

    public int findBestWay(int i, int j, int steps) {
        if (steps == -1) {
            return -1;
        }
        steps++;
        if (map[i][j] == space) {
            map[i][j] = path;
            if (map[i + 1][j] == door || map[i][j + 1] == door || map[i - 1][j] == door || map[i][j - 1] == door) {
                return steps;
            } else if (map[i + 1][j] != space && map[i][j + 1] != space && map[i - 1][j] != space && map[i][j - 1] != space) {
                map[i][j] = fail_path;
                return 100000;
            } else {
                List<Integer> list = new ArrayList<>();
                if (i < 6) list.add(findBestWay(i + 1, j, steps));
                if (j < 5) list.add(findBestWay(i, j + 1, steps));
                if (i > 1) list.add(findBestWay(i - 1, j, steps));
                if (j > 1) list.add(findBestWay(i, j - 1, steps));
                if (list.size() == 0) {
                    map[i][j] = fail_path;
                    return 100000;
                } else {
                    return Collections.min(list);
                }
            }
        }
        return 100000;
    }

    public int findBestWay(int i, int j) {
        int steps = 0;
        return findBestWay(i, j, steps);
    }
}

class Queen {
    public int space = 0;
    public int location = 1;
    public static int count = 0;
    int n;
    public static List<List<String>> list = new ArrayList<>();

    public Queen(int n) {
        this.n = n;
    }

    public void findSolution() {
        findSolution(new int[n][n], 0, 0);
    }

    public void findSolution(int[][] map, int X, int Y) {
        boolean flag = this.hasConflict(map, X, Y);
        if (!flag && X == n - 1) {
            count++;
            map[X][Y] = location;
            list.add(output(map));
            map[X][Y] = space;
            return;
        }

        if (!flag) {
            map[X][Y] = location;
            findSolution(map, X + 1, 0);
            map[X][Y] = space;
        }

        if (Y < n - 1) {
            findSolution(map, X, Y + 1);
        }
    }


    public boolean hasConflict(int[][] map, int X, int Y) {
        for (int i = 0; i < n; i++) {
            if (i != Y && map[X][i] == location) {
                return true;
            }
            if (i != X && map[i][Y] == location) {
                return true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != X && j != Y && Math.abs(i - X) == Math.abs(j - Y) && map[i][j] == location) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> output(int[][] map) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            String str = "";
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == location) {
                    str = str + "Q";
                } else {
                    str = str + ".";
                }
            }
            strList.add(str);
        }
        return strList;
    }
}
