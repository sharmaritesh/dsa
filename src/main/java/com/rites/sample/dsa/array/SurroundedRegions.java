package com.rites.sample.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * company facebook amazon microsoft google
 * topic array graph
 * category medium
 * leetcode https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    /*

        Step1 : check the four border of the matrix. If there is a element is
        'O', alter it and all its neighbor 'O' elements to 'R'.

        Then ,alter all the 'O' to 'X'

        At last,alter all the 'R' to 'O'

        For example:

         X X X X           X X X X             X X X X
         X X O X  ->       X X O X    ->       X X X X
         X O X X           X R X X             X O X X
         X O X X           X R X X             X O X X

*/
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        // find all boarder elements
        final List<Element> borderElements = findBorderElements(board);

        // for every border element, mark all 0 element with R value
        borderElements.forEach(element -> {
            solve(element.i, element.j, board, null);
        });

        // mark left O with X and R with O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'R') {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println(Arrays.toString(board));
    }

    static void solve(int i, int j, char[][] board, boolean[][] visited) {
//        visited[i][j] = true;

        if (board[i][j] == 'O') {
            board[i][j] = 'R';
            final List<Element> neighbors = getNeighbors(i, j, board);
            for (Element neighbor : neighbors) {
                solve(neighbor.i, neighbor.j, board, null);
            }
        }
    }

    static List<Element> getNeighbors(int i, int j, char[][] board) {
        List<Element> neighbors = new ArrayList<>();
        if (i > 0 && board[i-1][j] == 'O') neighbors.add(new Element(i-1, j));
        if (i < board.length-1 && board[i+1][j] == 'O') neighbors.add(new Element(i+1, j));
        if (j > 0 && board[i][j-1] == 'O') neighbors.add(new Element(i, j-1));
        if (j < board[0].length-1 && board[i][j+1] == 'O') neighbors.add(new Element(i, j+1));
        return neighbors;
    }

    static List<Element> findBorderElements(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            elements.add(new Element(i, 0));
            elements.add(new Element(i, col-1));
        }
        for (int i = 0; i < col; i++) {
            elements.add(new Element(0, i));
            elements.add(new Element(row-1, i));
        }
        return elements;
    }

    static class Element {
        int i;
        int j;

        public Element(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
