public class MinPriorityQueueUsingBST {

    private Node root;

    public static class Node {
        private int key, size;
        private Node left, right, p;
        private Node min; // to store the min node

        /**
         * Constructeur de Node
         * @param key Valeur de clé d'entrée
         * @param size Valeur de longueur de la corde (pour le problème suivant)
         */
        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }

        /**
         * Mutator de l'attribut right
         * @param right nouvelle valeur de right
         */
        public void setRight(Node right){this.right = right;}

        /**
         * Mutator de l'attribut left
         * @param left nouvelle valeur de left
         */
        public void setLeft(Node left) {this.left = left;}

        /**
         * Mutator de l'attribut P
         * @param p nouvelle valeur de P
         */
        public void setP(Node p) {this.p = p;}

        /**
         * Accessor de l'attribut left
         * @return valeur de l'attribut left
         */
        public Node getLeft() {return left;}

        /**
         * Accessor de l'attribut right
         * @return valeur de l'attribut right
         */
        public Node getRight() {return right;}

        /**
         * Accessor de l'attribut P
         * @return valeur de l'attribut P
         */
        public Node getP() {return p;}

        /**
         * Accessor de l'attribut min
         * @return la valeur de l'attribut min
         */
        public Node getMin() {return min;}

        /**
         * Mutator de l'attribut key
         * @param key nouvel valeur de key
         */
        public void setKey(int key) {this.key = key;}

        /**
         * Accessor de l'attribut key
         * @return la valeur de l'attribut key
         */
        public int getKey() {return key;}

        /**
         * accessor de l'attribut size
         * @return la valeur de l'attribut size
         */
        public int getSize() {return size;}

        /**
         * mutator de l'attribut minimum
         * @param min nouvelle valeur minimum
         */
        public void setMin(Node min) {
            this.min = min;
        }

        /**
         * Ajouter un nouveau noeud à gauche du noeud présent
         * @param left Nouveau noeud à ajouter à gauche
         */
        public void addLeft(Node left) {
            setLeft(left);
            getLeft().setP(this);
        }

        /**
         * Ajouter un nouveau noeud à droite du noeud présent
         * @param right Nouveau noeud à ajouter à droite
         */
        public void addRight(Node right) {
            setRight(right);
            getRight().setP(this);
        }

        /**
         * Trouver un noeud souhaité
         * @param key Valeur du noeud à trouver
         * @return Le noeud trouvé
         */
        public Node findMeBaby(int key){
            if(this.key == key) return this;
            if (key < this.key) return this.getLeft().findMeBaby(key);
            else return this.getRight().findMeBaby(key);
        }
    }

    /**
     * Constructeur de la classe MinPriorityQueueUsingBST
     */
    public MinPriorityQueueUsingBST() {
        root = null;
    }

    /**
     * Accessor pour l'attribut root
     * @return la valeur de l'attribut root
     */
    public Node getRoot() {return root;}

    /**
     * Mutator pour le nouveau noeud
     * @param root nouveau noeud
     */
    public void setRoot(Node root) {this.root = root;}

    /**
     * Mutator de l'attribut key du noeud
     * @param key nouvelle valeur de key
     */
    public void setRootKey(int key) {
        this.root = new Node(key,key);
    }

    /**
     * Ajouter un noeud à un arbre
     * @param key Clé d'entrée du noeud
     * @param node Noeud de départ pour ajouter le nouveau noeud
     */
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
        if (node == null) return;
        System.out.print(node.getKey() + " ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    /**
     * Extraire le noeud ayant la plus petite valeur de size
     * @param z noeud auquel commence la recherche
     * @return noeud ayant la plus petite valeur de size
     */
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
