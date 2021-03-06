package util;

import org.junit.Test;
import service.http.server.HttpHelloWorldServerInitializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class HttpServerTest {


    @Test
    public void test () {
        String name = "xxx1233";
        char s = 0x01;

        System.out.println(name.charAt(1));
        Integer.valueOf("1");
        int digit = Character.digit(name.charAt(1),10);
    }

    @Test
    public void run() throws Exception{
        HttpServer.run(8888, new HttpHelloWorldServerInitializer());
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
            /*
            输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]

        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/binary-tree-paths
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> binaryTreePaths(TreeNode root) {
        List<Integer> stepList = new ArrayList<Integer>();
        if (root == null) return stepList;
        step(stepList, root);
        Integer.valueOf("1");
        return stepList;
    }
    /*
    从根节点开始
    1、左侧有 一只找左侧 直到找不到
    2、
     */

    public void step (List<Integer> steps, TreeNode node) {
        if (node ==null) {
            return;
        }
        if (node.left == null  && node.right == null) {
            steps.add(node.val);
            return;
        }

        if (node.left != null) {
            step(steps, node.left);
        }
        steps.add(node.val);
        step(steps, node.right);

    }




    public void br(StringBuilder path, List<String> paths, TreeNode node) {
        if (node == null) {
            return;
        }
        path = (path != null ? path: new StringBuilder());
        if (node.left == null && node.right == null) {
            // 叶子节点
            path.append(node.val);
            paths.add(path.toString());
            return;
        }
        // 非叶子节点


        path.append(node.val).append("->");
        StringBuilder left = new StringBuilder(path);
        br(left, paths, node.left);
        br(left, paths, node.right);
    }



    @Test
    public void ss() {
        Date date = new Date();
        binaryTreePaths(null);
        System.out.println(new Date().getTime() - date.getTime());
    }
}
