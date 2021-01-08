package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

class Nodee {
    public int val;
    public List<Nodee> children;

    
    public Nodee() {
        children = new ArrayList<Nodee>();
    }
    
    public Nodee(int _val) {
        val = _val;
        children = new ArrayList<Nodee>();
    }
    
    public Nodee(int _val,ArrayList<Nodee> _children) {
        val = _val;
        children = _children;
    }
}
public class DiameterOfNAryTree {

	protected int diameter = 0;

    /**
     * return the maximum depth of leaves nodes descending from the given node
     */
    protected int maxDepth(Nodee node, int currDepth) {
        if (node.children.size() == 0)
            return currDepth;

        // select the top two largest depths
        int maxDepth1 = currDepth, maxDepth2 = 0;
        for (Nodee child : node.children) {
            int depth = maxDepth(child, currDepth + 1);
            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }
            // calculate the distance between the two farthest leaves nodes.
            int distance = maxDepth1 + maxDepth2 - 2 * currDepth;
            this.diameter = Math.max(this.diameter, distance);
        }

        return maxDepth1;
    }

    public int diameter(Nodee root) {
        this.diameter = 0;
        maxDepth(root, 0);
        return diameter;
    }
}
