package TAD.Tree;

public class NodoTree<K, T> implements Comparable<NodoTree<K, T>>{
    K key;
    T data;
    int count = 0;

    NodoTree<K, T> leftChild;
    NodoTree<K, T> rightChild;

    public NodoTree(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count = getCount() + 1;
    }

    public NodoTree<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodoTree<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodoTree<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodoTree<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(NodoTree<K, T> o) {
        if((Integer) this.key < (Integer) o.getKey())
            return -1;
        else if((Integer) this.key > (Integer) o.getKey())
            return 1;
        else
        return 0;
    }

    public int nodosCompletos(NodoTree<K, T> n) {
        if (n == null)
            return 0;
        else {
            if (n.getLeftChild()!= null && n.getRightChild() != null)
                return nodosCompletos(n.getLeftChild()) + nodosCompletos(n.getRightChild()) + 1;
            return nodosCompletos(n.getLeftChild()) + nodosCompletos(n.getRightChild());
        }
    }
}
