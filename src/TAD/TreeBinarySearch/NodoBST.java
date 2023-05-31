package TAD.TreeBinarySearch;

public class NodoBST<K extends Comparable<K>, T> {
    K key;
    T data;
    int count = 0;

    NodoBST<K, T> leftChild;
    NodoBST<K, T> rightChild;

    public NodoBST(K key, T data) {
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

    public NodoBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodoBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodoBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodoBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public int nodosCompletos(NodoBST<K, T> n) {
        if (n == null)
            return 0;
        else {
            if (n.getLeftChild()!= null && n.getRightChild() != null)
                return nodosCompletos(n.getLeftChild()) + nodosCompletos(n.getRightChild()) + 1;
            return nodosCompletos(n.getLeftChild()) + nodosCompletos(n.getRightChild());
        }
    }
}
