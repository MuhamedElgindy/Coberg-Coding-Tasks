package Helper;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ALKODS
 */
public class Node {
    private int x;
    private int y;
    private String path;

    public Node() {
    }
    public Node(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }}
