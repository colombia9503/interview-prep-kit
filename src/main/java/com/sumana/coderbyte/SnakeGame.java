package com.sumana.coderbyte;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class SnakeGame {
    public static void main(String[] args) {
        PriorityQueue<Coordinate> queue = new PriorityQueue<>();
        queue.add(new Coordinate(4, 1));
        queue.add(new Coordinate(4, 2));
        queue.add(new Coordinate(4, 3));
        queue.add(new Coordinate(4, 4));

        Snake snake = new Snake(queue);
        snake.draw();
    }
}

interface ISnake {
    void draw();
    void move();
}

class Snake implements ISnake {
    private PriorityQueue<Coordinate> queue;

    public Snake(PriorityQueue<Coordinate> queue) {
        this.queue = queue;
    }

    @Override
    public void draw() {
        String[][] grid = new String[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = " ";
            }
        }

        for (String[] row : grid) {
            StringJoiner sj = new StringJoiner("|");
            for (String s : row) {
                sj.add(s);
            }
            System.out.println(sj);
        }
    }

    @Override
    public void move() {

    }
}

record Coordinate (int x, int y) implements Comparable<Coordinate> {
    @Override
    public int compareTo(Coordinate o) {
        int xCompare = Integer.compare(this.x, o.x);
        return xCompare != 0 ? xCompare : Integer.compare(this.y, o.y);
    }
}
