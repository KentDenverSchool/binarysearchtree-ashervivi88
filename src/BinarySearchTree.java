/***
 * Ashley Kim
 * 12/19/19
 * The purpose of this code is to create a binary search tree that uses recursion to order key/value pairs to  either
 * left or right sides of the tree
 ***/
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
    }

    public int size() { //root version of size
        return size(root);
    }

    private int size(Node x) { //size using Node's recursive size
        if(x == null){
            return 0;
        }
        return x.getSize();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
        private Node<Key,Value> put(Node<Key, Value> n, Key key, Value val) {

        Node<Key,Value> newNode = new Node(key, val, 1);

        if(n == null){

        return newNode;
        }

        else if(n.getKey().compareTo(key) < 0 &&
           n.getRight() == null){
                n.setRight(newNode);
        }

        else if(n.getKey().compareTo(key) > 0 &&
                n.getLeft() == null){
                    n.setLeft(newNode);
        }

        else if(n.getKey().compareTo(key) == 0){
            n.setValue(newNode.getValue());
        }

        else if(n.getKey().compareTo(key)< 0){
            n.setRight(put(n.getRight(), key, val));
        }

        else if(n.getKey().compareTo(key)> 0){
            n.setLeft(put(n.getLeft(), key, val));
        }

        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null) {
            return null;
        } else if (n.getKey().compareTo(key) < 0 &&
                n.getRight() == null) {
            return null;
        } else if (n.getKey().compareTo(key) > 0 &&
                n.getLeft() == null) {
            return null;
        } else if (n.getKey().compareTo(key) == 0) {
            return n.getValue();
        } else if (n.getKey().compareTo(key) < 0) {
            return get(n.getRight(), key);
        } else {
            return get(n.getLeft(), key);
        }}


    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value remove(Key key) { //root version of remove method
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) { //recursive remove method
        if(n == null) return null;
        int i = key.compareTo(n.getKey());
        if( i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if(i > 0) {
            n.setRight(remove(n.getRight(), key));
        }else {
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    //returns smallest key value
    public Key min() {
        if(size() == 0 ){
            return null;
        }
        else{return min(root).getKey();}
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if(n.getLeft() == null){
        return n;}
        else return min(n.getLeft());
    }

    //returns largest key value
    public Key max() {
        if(size() == 0 ){
            return null;
        }
        else return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if(n.getRight() == null){
            return n;}
        else return max(n.getRight());
    }

    //root toString method
    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length()-2);
        return "{" + temp + "}";
    }

    //recursive toString method
    private String toString(Node<Key, Value> n) {
        if(n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue()  + ", " +
                toString(n.getRight());

    }
}