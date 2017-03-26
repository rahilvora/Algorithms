/**
 * Created by rahilvora on 1/27/17.
 */
class NodeLocal
{
    int data;
    NodeLocal left, right;

    NodeLocal(int item)
    {
        data = item;
        left = right = null;
    }
}

class Values
{
    int max, min;
}
public class VerticalOrder {
    // Java program to print binary tree in reverse order
// A binary tree node
    NodeLocal root;
    Values val = new Values();

    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(NodeLocal node, Values min, Values max, int hd)
    {
        // Base case
        if (node == null)
            return;

        // Update min and max
        if (hd < min.min)
            min.min = hd;
        else if (hd > max.max)
            max.max = hd;

        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }

    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(NodeLocal node, int line_no, int hd)
    {
        // Base case
        if (node == null)
            return;

        // If this node is on the given line number
        if (hd == line_no)
            System.out.print(node.data + " ");

        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }

    // The main function that prints a given binary tree in
    // vertical order
    void verticalOrder(NodeLocal node)
    {
        // Find min and max distances with resepect to root
        findMinMax(node, val, val, 0);

        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        for (int line_no = val.min; line_no <= val.max; line_no++)
        {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }

    // Driver program to test the above functions
    public static void main(String args[])
    {
        VerticalOrder tree = new VerticalOrder();

    /* Let us construct the tree shown in above diagram */
        tree.root = new NodeLocal(1);
        tree.root.left = new NodeLocal(2);
        tree.root.right = new NodeLocal(3);
        tree.root.left.left = new NodeLocal(4);
        tree.root.left.right = new NodeLocal(5);
        tree.root.right.left = new NodeLocal(6);
        tree.root.right.right = new NodeLocal(7);
        tree.root.right.left.right = new NodeLocal(8);
        tree.root.right.right.right = new NodeLocal(9);

        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
}

