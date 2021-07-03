package algorithm.search.bfs;
import javafx.util.Pair;

import java.util.*;

/**
 * BFS
 * 广度优先搜索，逐层遍历，每一层遍历的节点与根节点的距离相同，每一层的节点用队列存储，以便在统计、存储和遍历下一层的节点
 * 最短路径：每一层遍历的节点与根节点距离相等，di为第i节点到根节点的距离，对与先遍历的节点i与后遍历的节点j，di<=dj，故可以求解最短路径
 * 值得注意的是: BFS只能求解无权图的最短路径，即图中每个节点到另一个节点的代价都是1
 * 程序实现BFS需要考虑：
 *     队列：用来存储每一轮遍历得到节点
 *     标记：对于遍历过的节点，应该将它标记，防止重复遍历
 * 应用场景：最路路径
 *
 * 第一层：0->{1,2,6,5}
 * 第二层：1->{}
 *       2->{}
 *       6->{4}
 *       5->{3}(已经遍历过的节点不能再被遍历)
 * 第三层：4->{}
 *       3->{}
 */

/**
 * 统计在网络中从左上角到右下角的最短路径长度
 * Input: int[][]，grids，0是可以通过的位置，1是不能通过，路径可以走斜对角
 * Output: int，最短路径长度
 * 总结：广度优先遍历，就比如过树，队列中都一层一层元素的存储，也是一层一层的计算，层间的步长一样
 *      每一层到出发点的pathLength都是一样，故只要最后谁先到达重点，谁的路径就是最短的
 */
public class ShortPath {
    public int shortestPathBinaryMatrix(int[][] grids){
        //判断特殊情况
        if(grids == null || grids.length == 0 || grids[0].length == 0){
            return -1;
        }
        int [][] direction = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};//cur点周围的8个点//二维数组，就是数组里面存的元素还是数组
        int row = grids.length, col = grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();//每个pair就是一个点，pair里面是它的横、纵坐标//map可以保存多对key-value，pair只能保存一对key-value
        queue.add(new Pair<>(0,0));//制定起点(0,0)
        int pathLength = 0;
        while (!queue.isEmpty()){//当队列不为空时保持循环
            int size = queue.size();//size只在这里统计和重置，故下面往队列里添加了元素，但是size还未重置
            pathLength++;//走一步//每一个队列走一步到达的点的集合，故每次都是把当前队列中的当前步长的点遍历完，故公用一个pathLength即可
                        //下面一个while循环只执行一步，虽然坐标和方向会千差万别，但是每个点到出发点的步长是一样的，故pathLength在下面的while循环外+1
            while (size-- > 0){//遍历一层，一个while只处理一个步长的情况
                Pair<Integer, Integer> cur = queue.poll();//从队列中取出一个点，key是横坐标，val是纵坐标
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1){//如果此路不同，查找下个元素
                    continue;
                }
                if (cr == row-1 && cc ==col-1){//当grids[cr][cc]到达了矩阵右下角，统计结束
                    return pathLength;
                }
                grids[cr][cc] = 1;//单独使用一个二维数组来做标记//标记，已经处理过的元素进行标记，避免回头遍历
                //将周围的八个点加入队列//这里bfs中每次计算都是处理同步长的元素
                //往队列中添加下一步的情况，即添加该点周边的8个点
                for (int[] d : direction){//遍历方向数组
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= row || nc < 0 || nc >= col){//当往四周添加的点不在矩阵内，则不往队列里添加
                        continue;
                    }
                    queue.add(new Pair<>(nr,nc));//增加子节点
                }
            }
        }
        return -1;
    }
}
