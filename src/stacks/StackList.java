package stacks;

import java.util.*;

/**
 * StackList keeps track of the current, previous and next links of a given list.
 * It has two inner classes, Node and StackIterator, that iterate Objects of type StackList.
 *
 * @param <T> genetic type.
 * @author Pires, Marilize.
 */

public class StackList<T> implements Iterable<T> {
    // Private fields.
    private int mSize;
    private String name; // Used for testing and debugging purposes.
    private Node top; // Points to the top of the stack.

    /**
     * Constructor initializes the class attributes.
     *
     * @param name stores name of the stack.
     */
    StackList(String name) {
        this.name = name;
        clear();
    }

    /**
     * Adds the genetic type (item) to the top of the stack.
     *
     * @param item genetic item
     */
    public void push(T item) {

        Node newNode = new Node(item);
        newNode.next = this.top;
        this.top = newNode;
        this.mSize++;
    }

    /**
     * Removes the item from the top of the stack.
     *
     * @return generic item (value) popped.
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            throw new EmptyStackException();
        }
        T value = this.top.data;
        this.top = top.next;
        this.mSize--;
        return value;
    }

    /**
     * Retrieves, but it doesn't remove, the the first elements of the stack.
     *
     * @return null if the list is empty. Returns the genetic type otherwise.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.top.next.data;

    }

    /**
     * Discard all object references from the list.
     */
    public void clear() {
        this.mSize = 0;
        this.top = null;
    }

    /**
     * Prints out the name of the stack passed in by the Navigator class
     * in addition to the number of links in the stack.
     *
     * @return string
     */
    @Override
    public String toString() {
        String result = "";

        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            result += iterator.next() + ", ";
        }

        return this.name + " has " + this.mSize + " link(s): \n[" + result + "]";
    }

    /**
     * isEmpty() checks for empty stack.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        if (this.mSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Accessor
     *
     * @return number of elements in the stack.
     */
    public int size() {
        return mSize;
    }

    /**
     * StackList will return a new iterator to the beginning of the list.
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }


    //INNER CLASSES: Node & StackIterator.

    /**
     * Class Node implements abstract StackList.
     */
    private class Node {
        Node next;
        T data;

        /**
         * Constructor.
         *
         * @param dataItem genetic type.
         */
        Node(T dataItem) {
            data = dataItem;
            next = null;
        }

    }

    /**
     * Class StackIterator iterates over outer genetic StackList.
     */
    private class StackIterator implements Iterator<T> {

        //Keeps track of current location.
        private Node mCurrentNode;

        /**
         * Default Constructor.
         */
        StackIterator() {
            this.mCurrentNode = top;
        }

        /**
         * It checks to see if the next node (right of iterator) is valid.
         *
         * @return true if there is a link forward. False otherwise.
         */
        public boolean hasNext() {
            return mCurrentNode != null;
        }

        /**
         * Iterates onto the next element of the stack.
         *
         * @return genetic type.
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = (T) this.mCurrentNode.data;
            this.mCurrentNode = this.mCurrentNode.next;

            return data;
        }
    }
}


