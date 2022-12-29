import java.util.HashMap;

class Solution {

  public HashMap<Integer, Node> hm = new HashMap<>();

  public Node cloneGraph(Node node) {
    return clone(node);
  }

  Node clone(Node node) {
    if (node == null) {
      return null;
    }

    // this is useful when checking neighbors of non-1st node
    if (hm.containsKey(node.val)) { // e.g. 1st node checked and recursively calls 2nd, but 1st is a neighbor of 2nd
                                    // so it has to be checked again
      return hm.get(node.val); // returns the same thing as n2 does later, but its already done
    }

    Node n2 = new Node(node.val, new ArrayList<Node>());
    hm.put(n2.val, n2);
    for (Node n : node.neighbors) {
      n2.neighbors.add(clone(n));
    }
    return n2;
  }
}