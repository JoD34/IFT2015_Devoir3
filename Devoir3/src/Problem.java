
public class Problem {

    public static int calculateCost(int[] ropes) {

        int res = 0;
	    MinPriorityQueueUsingBST tree = new MinPriorityQueueUsingBST();
        // Construire l'arbre
        tree.setRootKey(ropes[0]);
        for (int i=1;i < ropes.length;i++)tree.addMeBaby(ropes[i],tree.getRoot());
        tree.updateMinNode(tree.getRoot());

        // Retirer les deux noeuds à valeur minimum, les additionner et ajouter le nouveau noeud
        while (tree.getRoot() != null
                && tree.getRoot().getRight()!= null || tree.getRoot().getLeft()!=null){
            MinPriorityQueueUsingBST.Node pop1 = tree.extractMinEfficient(tree.getRoot());
            MinPriorityQueueUsingBST.Node pop2 = tree.extractMinEfficient(tree.getRoot());
            int addValue = pop1.getSize() + pop2.getSize();
            if (tree.getRoot()!=null) tree.addMeBaby(addValue, tree.getRoot());
            else tree.setRootKey(addValue);
            tree.updateMinNode(tree.getRoot());
            res += addValue;
        }

        return res;
    }

}
