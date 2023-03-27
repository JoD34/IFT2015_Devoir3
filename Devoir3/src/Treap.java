import java.util.Random;

// A Treap Node
class TreapNode
{
    int data;
    int priority;
    TreapNode left, right;

    // constructor
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(100);
        this.left = this.right = null;
    }
}

class Treap {

    /**
     * Effectue une rotation à la gauche.
     * @param root racine de l'arbre où on effectue une rotation.
     * @return la nouvelle racine de l'arbre.
     */
    public static TreapNode rotateLeft(TreapNode root) {
        TreapNode R = root.right;
        TreapNode X = root.right.left;

        // rotate
        R.left = root;
        root.right = X;

        // set a new root
        return R;
    }

    /**
     * Effectue une rotation à la droite.
     * @param root racine de l'arbre où on effectue la rotation.
     * @return la nouvelle racine de l'arbre.
     */
    public static TreapNode rotateRight(TreapNode root) {
        TreapNode L = root.left;
        TreapNode Y = root.left.right;

        // rotate
        L.right = root;
        root.left = Y;

        // set a new root
        return L;
    }

    /**
     * Insère un noeud dans l'arbre.
     * @param root la racine de l'arbre.
     * @param data la valeur contenue dans le nouveau noeud.
     * @return la racine de l'arbre.
     */
    public static TreapNode insertNode(TreapNode root, int data) {

        if (root == null) {
            return new TreapNode(data);
        }

        if (data < root.data) {
            root.left = insertNode(root.left, data);

            if (root.priority < root.left.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insertNode(root.right, data);

            if (root.priority < root.right.priority) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    /**
     * Cherche si un noeud est contenu dans l'arbre.
     * @param root la racine de l'arbre.
     * @param key la valeur du noeud à chercher.
     * @return true si la valeur est dans l'arbre et false si elle ne l'est pas.
     */
    public static boolean searchNode(TreapNode root, int key) {

        if (root == null) { return false; }
        if (root.data == key) { return true; }

        if (key < root.data) {
            return searchNode(root.left, key);

        }
        return searchNode(root.right, key);
    }

    /**
     * Enlève un noeud de l'arbre.
     * @param root racine de l'arbre.
     * @param key valeur à éliminer de l'arbre.
     * @return la racine de l'arbre après la suppression.
     */
    public static TreapNode deleteNode(TreapNode root, int key) {

        if (root == null) { return root; }

        else if (key < root.data) { root.left = deleteNode(root.left, key); }
        else if (key > root.data) { root.right = deleteNode(root.right, key); }

        // Si aucun enfant
        else if (root.left == null && root.right == null) { root = null; }

        // Si deux enfants
        else if (root.left != null && root.right != null) {

            if (root.left.priority < root.right.priority) {
                root = rotateLeft(root);
                root.left = deleteNode(root.left, key);

            } else {
                root = rotateRight(root);
                root.right = deleteNode(root.right, key);
            }
        }
        // Si un seul enfant
        else if (root.left != null) {
            root = root.left;
        } else {
            root = root.right;
        }
        return root;
    }

    /**
     * Imprime le contenu des noeuds de l'arbre en notation préfixe.
     * @param root racine de l'arbre
     */
    public static void printPreorder(TreapNode root) {
        if (root == null)
            return;

        System.out.println("Data : " + root.data + " Prio : " + root.priority);

        printPreorder(root.left);
        printPreorder(root.right);
    }
}


