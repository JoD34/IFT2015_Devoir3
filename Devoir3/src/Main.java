public class Main {
    public static void main(String[] args) {
        // Test pour le fichier Merge.java
        int[] listVal1 = {1,5,7},listVal3 = {2,3,6,9}, listVal2 = {4,8,10};
        Node[] listNodes= new Node[3];
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

        // Trier les listes chaînées
        Node merged = m.mergeKLists(listNodes);

        // Afficher le résultat final du tri
        Node n = merged;
        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }


    }
    public static void addNodes(int[] listVal, Node list){
        for (int i = 1; i < listVal.length;i++){
            Node n = list;
            while(n.next != null) n = n.next;
            n.next = new Node(listVal[i]);
        }
    }
}