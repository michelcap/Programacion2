package TAD.Tree;

import java.time.LocalDate;
import java.util.Date;

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

//    @Override
//    public int compareTo(NodoTree<K, T> o) {
//        return ((Integer) this.key).compareTo((Integer) o.getKey());
//    }

    @Override
    public int compareTo(NodoTree<K, T> o) {
        if (o.getKey() instanceof String) {
            return ((String) this.key).compareTo((String) o.getKey());
        } else if (o.getKey() instanceof Integer) {
            return ((Integer) this.key).compareTo((Integer) o.getKey());
        } else if (o.getKey() instanceof Double) {
            return ((Double) this.key).compareTo((Double) o.getKey());
        } else if (o.getKey() instanceof Long) {
            return ((Long) this.key).compareTo((Long) o.getKey());
        } else if (o.getKey() instanceof Short) {
            return ((Short) this.key).compareTo((Short) o.getKey());
        } else if (o.getKey() instanceof Float) {
            return ((Float) this.key).compareTo((Float) o.getKey());
        } else if (o.getKey() instanceof Date) {
            return ((Date) this.key).compareTo((Date) o.getKey());
        } else if (o.getKey() instanceof LocalDate) {
            return ((LocalDate) this.key).compareTo((LocalDate) o.getKey());
        }
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
