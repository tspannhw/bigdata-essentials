package com.needforcode.graph;

import com.needforcode.arraylist.MyArrayList;
import com.needforcode.exceptions.GraphException;

public class MyUndirectedGraphAdjMatrix<T> {

    int verticesCount;
    int edgeCount;

    MyArrayList<T> vertices;
    boolean[][] matrix;

    MyUndirectedGraphAdjMatrix() {
        this.verticesCount=0;
        this.edgeCount=0;
        vertices = new MyArrayList();
    }

    MyUndirectedGraphAdjMatrix(int v) {
        if(v<0) {
            throw new GraphException("vertex count can't be less than 0");
        }
        this.verticesCount=v;
        this.edgeCount=0;
        vertices = new MyArrayList();
        matrix = new boolean[verticesCount][verticesCount];
    }

    public void addVertices(Iterable<T> t) {
        for(T value : t) {
            vertices.add((T) t);
            verticesCount++;
        }
    }

    public void addVertex(T t) {
        vertices.add(t);
        int resize = 0;
        if(verticesCount == vertices.size()) {
            resize=2*verticesCount;
        }
        boolean[][] matrixNew = new boolean[resize][resize];
        for(int i=0;i<verticesCount;i++) {
            for(int j=0;j<verticesCount;j++) {
                matrixNew[i][j]=matrix[i][j];
            }
        }
        verticesCount++;
    }

    public void addEdge(int i, int j) {
        try {
            if(!matrix[i][j]) {
                matrix[i][j]=true;
                matrix[j][i]=true;
            }
        } catch (Exception e) {
            throw new GraphException("vertices does not exist");
        }
    }

    public void removeEdge(int i, int j) {
        try {
            if(!matrix[i][j]) {
                matrix[i][j]=false;
                matrix[j][i]=false;
            }
        } catch (Exception e) {
            throw new GraphException("vertices does not exist");
        }
    }

    public boolean hasEdge(int i, int j) {
        boolean flag;
        try {
            flag = (matrix[i][j]==true);
        } catch(Exception e) {
            throw new GraphException("vertices doesn't exist");
        }
        return flag;
    }
}
