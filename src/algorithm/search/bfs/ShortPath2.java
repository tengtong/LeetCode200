package algorithm.search.bfs;

import javafx.util.Pair;

import java.util.*;

public class ShortPath2 {
    public int solution(int [][] grids){
        if (grids == null || grids.length == 0 || grids[0].length == 0){
            return -1;
        }
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//九宫格中，从(0,0)出发一个步长能到达的点
        int row = grids.length, col = grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-- > 0){//完成一次步长的操作
                //取出一个元素
                Pair<Integer,Integer> cur = queue.poll();//弹出一个元素，这里比较特殊，用队列中排的是"点"，每个点用Pair<key,value>，key记录横坐标，value记录纵坐标
                int cr = cur.getKey(), cc = cur.getValue();
                //if、如果这个点的值为1，此路从不同，不判断该点的情况
                if (grids[cr][cc] == 1){
                    continue;
                }
                //判断是否到达目标点
                if (cr == row-1 && cc == col-1){
                    return pathLength;
                }
                //对本次访问的点做个标记，避免重复走
                grids[cr][cc] = 1;//标记
                //添加下一层的点，将下一个步长的点添加到队列中
                for (int[] d:direction){
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= row || cc<0 || cc >=col){//如果该点的范围不在
                        continue;
                    }
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;//如果最后都没找到，即走完了所有的地方，则表示达到不了，返回-1
    }
}
