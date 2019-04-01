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
    head = null;
    tail = null;
    numberOfElements = 0;
    initialized = true;
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
    if (head == null) {
      head = new Node(newEntry);
      tail = head;
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
    if (tail == null) {
      tail = new Node(newEntry);
      head = tail;
    } else {
      Node newNode = new Node(newEntry);
      tail.next = newNode;
      tail = newNode;
    }
    numberOfElements++;
  }

  /**
   * Remove the front entry from the list. The list's size is decreased by 1.
   *
   * @return the removed entry, or null if nothing to remove.
   */
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

  /**
   * Remove the last entry from the list. The list's size is decreased by 1.
   *
   * @return the removed entry, or null if nothing to remove.
   */
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

  /**
   * Clears the entire list.
   */
  public void clear() {
    checkInitialization();
    head = null;
    tail = null;
    numberOfElements = 0;
  }

  /**
   * Access the entry at the given position.
   *
   * @param givenPosition Receives the position index.
   * @return the entry at the given position, or null if given position is not
   *         found.
   */
  public T getEntry(int givenPosition) {
    checkInitialization();
    if (givenPosition == numberOfElements - 1) {
      return tail.data;
    } else if (givenPosition >= 0 && givenPosition < numberOfElements - 1) {
      Node currentNode = head;
      int index = 0;
      while (index < numberOfElements - 1) {
        if (index == givenPosition)
          return currentNode.data;
        currentNode = currentNode.next;
        index++;
      }
    }
    return null;
  }

  /**
   * Displays the entire list in the form of "[A,B,C,D] head = a tail = D".
   */
  public void display() {
    checkInitialization();
    Node currentNode = head;
    System.out.print("[");
    if (isEmpty()) {
      System.out.print("]\n");
    } else {
      System.out.print(currentNode.data);
      currentNode = currentNode.next;
      while (currentNode != null) {
        System.out.print(", " + currentNode.data);
        currentNode = currentNode.next;
      }
      System.out.printf("]\thead=%s\ttail=%s\n", head.data, tail.data);
    }
  }

  /**
   * Checks if the list contains the given entry.
   *
   * @param anEntry Receives the entry to check.
   * @return the index of the found entry or -1 if the list does not contains the
   *         given entry.
   */
  public int contains(T anEntry) {
    checkInitialization();
    Node currentNode = head;
    int index = 0;

    while (currentNode != null) {
      if (currentNode.data.equals(anEntry)) {
        return index;
      } else {
        currentNode = currentNode.next;
        index++;
      }
    }
    return -1;
  }

  /**
   * Access the current number of entries in the list.
   *
   * @return the number of entries.
   */
  public int size() {
    checkInitialization();
    return numberOfElements;
  }

  /**
   * Checks to see if the list is empty and initialized.
   *
   * @return true if it is empty, or false if not.
   */
  public boolean isEmpty() {
    checkInitialization();
    return numberOfElements == 0;
  }

  /**
   * Compares this list to another specified list element-by-element.
   * At the first element that doesn't match, lists are compared by that element.
   * If there are no mismatched elements, and the end of one or both lists is reached,
   * comparison is based on list size.
   *
   * @param otherList The specified list to be compared.
   * @return A negative integer, zero, or a positive integer if this list is smaller than,
   * 		 logically identical to, or larger than the specified list, respectively.
   */
  public int compareTo(LinkedHeadTailList<T> otherList) {
    checkInitialization();
    Node currNodeThis = head;
	  Node currNodeOther = otherList.head;
	  while (currNodeThis != null && currNodeOther != null) {
      int check = currNodeThis.data.compareTo(currNodeOther.data);
      if (check != 0) {
        return check;
      } else {
        currNodeThis = currNodeThis.next;
        currNodeOther = currNodeOther.next;
      }
    }
    if (currNodeThis == null && currNodeOther == null) {
      return 0;
    } else {
      return numberOfElements - otherList.numberOfElements;
    }
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

  /**
   * Private class to hold the data and chain them together.
   */
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
