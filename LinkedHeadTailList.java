/**
 * This is a list data structure implemented using Head-Tail-Linked Nodes. •
 * List starts at position 0. • Entries can only be add/remove at the
 * beginning/end of the list. • Entries can only be accessed from any position.
 *
 * @author Bo Fone, Brian Nguyen & Emilie Biondi
 * @since 2019
 * @version 1.0
 */
public class LinkedHeadTailList<T extends Comparable<? super T>>
    implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {

  private Node head, tail;
  private int numberOfElements;

  public LinkedHeadTailList() {
    head = null;
    tail = null;
    numberOfElements = 0;
  }

  public void addFront(T newEntry) {

  }

  public void addBack(T newEntry) {

  }

  public T removeFront() {
    return null;
  }

  public T removeBack() {
    return null;
  }

  public void clear() {
    head = null;
    tail = null;
    numberOfElements = 0;
  }

  public T getEntry(int givenPosition) {
    return null;
  }

  public void display() {
  }

  public int contains(T anEntry) {
    return -1;
  }

  public int size() {
    return numberOfElements;
  }

  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  public int compareTo(LinkedHeadTailList<T> otherList) {
    return 0;
  }

  private class Node {
    private T data; // Entry in list
    private Node next; // Link to next node

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    } // end constructor

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    } // end constructor

    private T getData() {
      return data;
    } // end getData

    private void setData(T newData) {
      data = newData;
    } // end setData

    private Node getNextNode() {
      return next;
    } // end getNextNode

    private void setNextNode(Node nextNode) {
      next = nextNode;
    } // end setNextNode
  }
}