public class MinPriorityQueueUsingBST {

    private Node root;

    public static class Node {
        private int key, size;
        private Node left, right, p;
        private Node min; // to store the min node

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }
        public void setRight(Node right){this.right = right;}
        public void setLeft(Node left) {this.left = left;}
        public void setP(Node p) {this.p = p;}
        public Node getLeft() {return left;}
        public Node getRight() {return right;}
        public Node getP() {return p;}
        public Node getMin() {return min;}
        public void setKey(int key) {this.key = key;}

        public int getKey() {return key;}

        public int getSize() {return size;}

        public void setMin(Node min) {
            this.min = min;
        }

        public void addLeft(Node left) {
            setLeft(left);
            getLeft().setP(this);
        }

        public void addRight(Node right) {
            setRight(right);
            getRight().setP(this);
        }
        public Node findMeBaby(int key){
            if(this.key == key) return this;
            if (key < this.key) return this.getLeft().findMeBaby(key);
            else return this.getRight().findMeBaby(key);
        }
    }

    public MinPriorityQueueUsingBST() {
        root = null;
    }

    public Node getRoot() {return root;}

    public void setRoot(Node root) {this.root = root;}

    public void setRootKey(int key) {
        this.root = new Node(key,key);
    }

    public void addMeBaby(int key, Node node){
        if (key < node.key){
            if (node.getLeft() == null) node.addLeft(new Node(key, key));
            else addMeBaby(key, node.getLeft());
        }
        else {
            if (node.getRight() == null) node.addRight(new Node(key, key));
            else addMeBaby(key, node.getRight());
        }
    }

    /**
     * Retourne la valeur minimum d'une noeud.
     *      Logique: arbre binaire -> plus petite valeur à gauche
     * @param x Noeud qu'on cherche savoir l'enfant de valeur minimum
     * @return noeud de valeur min du noeud présent ou le noeud présent s'il n'a aucun enfant
     */
    public Node min(Node x) {
        while (x.left != null) x = x.left;
        return x;
    }

    /**
     * Mettre à jour l'attribut min de chaque noeud
     * @param z Arbre à partir duquel on cherche mettre à jour les min
     */
    protected void updateMinNode(Node z) {
        if (z.getLeft()!= null) updateMinNode(z.getLeft());
        if (z.getRight()!= null) updateMinNode(z.getRight());
        z.setMin(min(z));
    }

    /**
     * Déplacer le sous-arbre lors de la suppression d'un noeud
     * @param u noeud à supprimer
     * @param v noeud devant être déplacé sous le parent de u
     */
    public void transplant(Node u, Node v) {
        v.setP(u.getP());
        if (u == u.getP().getLeft()) u.getP().setLeft(v);
        else u.getP().setRight(v);
    }

    /**
     * Afficher l'arbre binaire de façon préfixée
     * @param node Noeud de départ de l'impression.
     */
    void printPreorder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.getKey() + " ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    public Node extractMinEfficient(Node z) {

        // Si l'arbre est null.
        if (z == null) return z;
        Node min = z.getMin();
        // Si z est la root.
        if (min.getP() == null) {
            if (getRoot().getRight() == null) setRoot(null);
            else {
                setRoot(getRoot().getRight());
                getRoot().setP(null);
            }
        }
        // Si le noeud minimum possède un enfant droit.
        else if (min.getRight() != null) transplant(min, min.getRight());
        // Si le min est une feuille gauche.
        else min.getP().setLeft(null);
        // Modifier le min de z.
        if(getRoot() != z.getMin()){
            if(min.getRight()== null) z.setMin(min.getP());
            else z.setMin(min.getRight().getMin());
        }
        return min;
    }
}
