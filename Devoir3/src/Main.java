public class Main {
    public static void main(String[] args) {
        // Test pour le fichier Merge.java
        int[] listVal1 = {1,5,7},listVal3 = {2,3,6,9}, listVal2 = {4,8,10}, listVal4={11,13,24};
        Node[] listNodes= new Node[4];
        Merge m = new Merge();

        // Générer trois listes chaînées de noeuds
        Node list1 = new Node(listVal1[0]);
        listNodes[0] = list1;
        addNodes(listVal1,list1);
        Node list2 = new Node(listVal2[0]);
        listNodes[1] = list2;
        addNodes(listVal2,list2);
        Node list3 = new Node(listVal3[0]);
        listNodes[2] = list3;
        addNodes(listVal3,list3);
/*
        Node list4 = new Node(listVal1[0]);
        listNodes[3] = list4;
        addNodes(listVal1,list4);
*/
        // Trier les listes chaînées
        Node merged = m.mergeKLists(listNodes);

        // Afficher le résultat final du tri
        Node n = merged;
        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }

        // Initier l'arbre binaire
        int[] listKeys ={10,5,7,6,3,2,8,9,15,13,12,14,17,16,18};
        MinPriorityQueueUsingBST a = new MinPriorityQueueUsingBST();
        a.setRootKey(listKeys[0]);
        for (int i=1;i < listKeys.length;i++)a.addMeBaby(listKeys[i],a.getRoot());
        a.printPreorder(a.getRoot());
        a.updateMinNode(a.getRoot());
        System.out.println();

        MinPriorityQueueUsingBST.Node found = a.getRoot().findMeBaby(7);
        a.transplant(found, found.getRight());
        a.printPreorder(a.getRoot());

        System.out.println();

        MinPriorityQueueUsingBST.Node found2 = a.getRoot().findMeBaby(13);
        a.transplant(found2, found2.getLeft());
        a.printPreorder(a.getRoot());


        while (a.getRoot() !=null){
            MinPriorityQueueUsingBST.Node extract = a.extractMinEfficient(a.getRoot());
            System.out.println(extract.getKey());
            a.printPreorder(a.getRoot());
            System.out.println();
            System.out.println("_________________________");
        }

        System.out.println("Problem try");
        int[] array = {4,3,2,6};
        System.out.println(Problem.calculateCost(array));
        System.out.println("_________________________");


        // Partie Caro
        Treap arbre = new Treap();
        TreapNode noeud = new TreapNode(13);
        TreapNode racine1 = new TreapNode(0);
        TreapNode racine2 = new TreapNode(0);
        TreapNode racine3 = new TreapNode(0);
        TreapNode racine4 = new TreapNode(0);
        TreapNode racine5 = new TreapNode(0);
        TreapNode racine6 = new TreapNode(0);
        TreapNode racine7 = new TreapNode(0);

        racine1 = arbre.insertNode(noeud, 10);
        racine2 = arbre.insertNode(racine1, 5);
        racine3 = arbre.insertNode(racine2, 12);
        racine4 = arbre.insertNode(racine3, 11);
        racine5 = arbre.insertNode(racine4, 25);
        racine6 = arbre.insertNode(racine5, 14);
        racine7 = arbre.insertNode(racine6, 28);

        arbre.printPreorder(racine7);
        System.out.println();
        //System.out.println(arbre.searchNode(racine2, 99));
        arbre.printPreorder(arbre.deleteNode(racine7, 11));

    }
    public static void addNodes(int[] listVal, Node list){
        for (int i = 1; i < listVal.length;i++){
            Node n = list;
            while(n.next != null) n = n.next;
            n.next = new Node(listVal[i]);
        }
    }
}