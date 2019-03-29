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
  // Instance Variables
  private Node head, tail;
  private boolean initialized = false;
  private int numberOfElements;

  /**
   * The default constructor initializes the list with no content.
   */
  public LinkedHeadTailList() {
    head = new Node(null);
    tail = head;
    initialized = true;
    numberOfElements = 0;
  }

  /**
   * The regular constructor takes an array of generic objects to start with. Note
   * that the original order of the array elements is unchanged. This constructor
   * can be used as an array to LinkedHeadTailLIst converter.
   *
   * @param array Receives an array of T to initialize.
   */
  public LinkedHeadTailList(T[] array) {
    this();
    for (int i = 0; i < array.length; i++) {
      addBack(array[i]);
    }
  }

  /**
   * Adds a new entry to the beginning of the list. Entries currently in the list
   * are shifted down. The list's size is increased by 1.
   *
   * @param newEntry The object to be added as a new entry.
   */
  public void addFront(T newEntry) {
    checkInitialization();
    if (head.getData() == null) {
      head.setData(newEntry);
    } else {
      head = new Node(newEntry, head);
    }
    numberOfElements++;
  }

  /**
   * Append a new entry to the end of the list. Entries currently in the list are
   * unchanged. The list's size is increased by 1.
   *
   * @param newEntry The object to be added as a new entry.
   */
  public void addBack(T newEntry) {
    checkInitialization();
    if (tail.getData() == null) {
      tail.setData(newEntry);
    } else {
      Node newNode = new Node(newEntry);
      tail.setNextNode(newNode);
      tail = newNode;
    }
    numberOfElements++;
  }

  public T removeFront() {
    checkInitialization();
    if (head != null) {
      Node temp = head;
      head = head.next;
      numberOfElements--;
      if (numberOfElements == 0) {
        tail = null;
      }
      return temp.data;
    }
    return null;
  }

  public T removeBack() {
    checkInitialization();
    if (numberOfElements == 1) {
      head = null;
      Node temp = tail;
      tail = null;
      numberOfElements--;
      return temp.data;
    } else if (numberOfElements > 1) {
      Node currentNode = head;
      int index = 0;
      while (index < numberOfElements - 2) {
        currentNode = currentNode.next;
        index++;
      }
      Node temp = currentNode.next;
      currentNode.next = null;
      numberOfElements--;
      tail = currentNode;
      return temp.data;
    }
    return null;
  }

  public void clear() {
    head = new Node(null);
    tail = head;
    numberOfElements = 0;
  }

  public T getEntry(int givenPosition) {
    if (givenPosition == numberOfElements - 1) {
      return tail.data;
    } else if (givenPosition >= 0 && givenPosition < numberOfElements-1) {
      Node currentNode = head;
      int index = 0;
      while (index < numberOfElements-1) {
        if (index == givenPosition) return currentNode.data;
        currentNode = currentNode.next;
        index++;
      }
    }
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

  // Helper Methods

  /**
   * Checks if the object is correctly initialized.
   *
   * @throws SecurityException if it is not properly initialized.
   */
  private void checkInitialization() {
    if (!initialized) {
      throw new SecurityException("ArrayHeadTailListInterface object is not initialized properly.");
    }
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
