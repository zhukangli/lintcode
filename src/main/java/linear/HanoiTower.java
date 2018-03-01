package linear;

import java.util.Stack;

/**
 * 在经典的汉诺塔问题中，有 3 个塔和 N 个可用来堆砌成塔的不同大小的盘子。
 * 要求盘子必须按照从小到大的顺序从上往下堆
 * （如，任意一个盘子，其必须堆在比它大的盘子上面）。同时，你必须满足以下限制条件：

 (1) 每次只能移动一个盘子。
 (2) 每个盘子从堆的顶部被移动后，只能置放于下一个堆中。
 (3) 每个盘子只能放在比它大的盘子上面。

 请写一段程序，实现将第一个堆的盘子移动到最后一个堆中。
 * Created by Conley on 2018/2/28.
 */
public class HanoiTower {
    private Stack<Integer> disks;
    /*
    * @param i: An integer from 0 to 2
    */
    public HanoiTower(int i) {
        // create three towers
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(HanoiTower t) {
        // Move the top disk of this tower to the top of t.
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
        // Move n Disks from this tower to destination by buffer tower
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }

}
