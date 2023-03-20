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

        public void setKey(int key) {
            this.key = key;
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
        if (z.left!= null) updateMinNode(z.left);
        if (z.right!= null) updateMinNode(z.right);
        z.min = min(z);
    }

    /**
     * Déplacer le sous-arbre lors de la suppression d'un noeud
     * @param u noeud à supprimer
     * @param v noeud devant être déplacé sous le parent de u
     */
    public void transplant(Node u, Node v) {
        if (v == u.getRight()) {
            if (u.getLeft() != null) {
                while (v.getLeft() != null) v = v.getLeft();
                v.setLeft(u.getLeft());
            }
            v.setP(u.getP());
            u.getP().setRight(v);
        }

        else{
            if (u.getRight() != null) {
                while (v.getRight() != null) v = v.getRight();
                v.setRight(u.getRight());
            }
            v.setP(u.getP());
            u.getP().setLeft(v);
        }
        updateMinNode(getRoot());
    }

    void printPreorder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public Node extractMinEfficient(Node z) {
        Node Head= new Node(1,1);


        return Head;
    }
}
