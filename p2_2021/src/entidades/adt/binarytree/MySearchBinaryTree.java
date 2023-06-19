/**
 * 
 */
package entidades.adt.binarytree;

import entidades.adt.linkedlist.MyList;

public interface MySearchBinaryTree<K extends Comparable<K>, V> {

	void add(K key, V value);

	void remove(K key);
	
	boolean contains(K key);
	
	V find(K key);

	MyList<K> inOrder();

}
