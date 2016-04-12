package All;

/**
 * Created by Alexandr on 27.03.2016.
 */
public class NewLinkedListImp {
    public NewLinkedListImp( ) {
        header = new ListNode( null );
    }

    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return header.next == null;
    }

    /**
     * Make the list logically empty.
     */
    public void makeEmpty( ) {
        header.next = null;
    }

    /**
     * Return an iterator representing the header node.
     */
    public LinkedListIterator zeroth( ) {
        return new LinkedListIterator( header );
    }

    /**
     * Return an iterator representing the first node in the list.
     * This operation is valid for empty lists.
     */
    public LinkedListIterator first( ) {
        return new LinkedListIterator( header.next );
    }

    /**
     * Insert after p.
     * @param x the item to insert.
     * @param p the position prior to the newly inserted item.
     */
    public void insert( Object x, LinkedListIterator p ) {
        if( p != null && p.current != null )
            p.current.next = new ListNode( x, p.current.next );
    }

    /**
     * Return iterator corresponding to the first node containing an item.
     * @param x the item to search for.
     * @return an iterator; iterator is not valid if item is not found.
     */
    public LinkedListIterator find( Object x ) {
        ListNode itr = header.next;

        while( itr != null && !itr.element.equals( x ) )
            itr = itr.next;

        return new LinkedListIterator( itr );
    }

    /**
     * Return iterator prior to the first node containing an item.
     * @param x the item to search for.
     * @return appropriate iterator if the item is found. Otherwise, the
     * iterator corresponding to the last element in the list is returned.
     */
    public LinkedListIterator findPrevious( Object x ) {
        ListNode itr = header;

        while( itr.next != null && !itr.next.element.equals( x ) )
            itr = itr.next;

        return new LinkedListIterator( itr );
    }

    /**
     * Remove the first occurrence of an item.
     * @param x the item to remove.
     */
    public void remove( Object x ) {
        LinkedListIterator p = findPrevious( x );

        if( p.current.next != null )
            p.current.next = p.current.next.next;  // Bypass deleted node
    }

    // Simple print method
    public static void printList( NewLinkedListImp theList ) {
        if( theList.isEmpty( ) )
            System.out.print( "Empty list" );
        else {
            LinkedListIterator itr = theList.first( );
            for( ; itr.isValid( ); itr.advance( ) )
                System.out.print( itr.retrieve( ) + " " );
        }

        System.out.println( );
    }

    private ListNode header;

    // In this routine, LinkedList and LinkedListIterator are the
    // classes written in Section 17.2.
    public static int listSize( NewLinkedListImp theList ) {
        LinkedListIterator itr;
        int size = 0;

        for( itr = theList.first(); itr.isValid(); itr.advance() )
            size++;

        return size;
    }

    public static void main( String [ ] args ) {
        NewLinkedListImp theList = new NewLinkedListImp( );
        LinkedListIterator theItr;
        int i;

        theItr = theList.zeroth( );
        printList( theList );

        for( i = 0; i < 10; i++ ) {
            theList.insert( new Integer( i ), theItr );
            printList( theList );
            theItr.advance( );
        }
        System.out.println( "Size was: " + listSize( theList ) );

        for( i = 0; i < 10; i += 2 )
            theList.remove( new Integer( i ) );

        for( i = 0; i < 10; i++ )
            if( ( i % 2 == 0 ) == ( theList.find( new Integer( i ) ).isValid( ) ) )
                System.out.println( "Find fails!" );

        System.out.println( "Finished deletions" );
        printList( theList );
    }

    public class LinkedListIterator {
        /**
         * Construct the list iterator
         * @param theNode any node in the linked list.
         */
        LinkedListIterator( ListNode theNode ) {
            current = theNode;
        }

        /**
         * Test if the current position is AA valid position in the list.
         * @return true if the current position is valid.
         */
        public boolean isValid( ) {
            return current != null;
        }

        /**
         * Return the item stored in the current position.
         * @return the stored item or null if the current position
         * is not in the list.
         */
        public Object retrieve( ) {
            return isValid( ) ? current.element : null;
        }

        /**
         * Advance the current position to the next node in the list.
         * If the current position is null, then do nothing.
         */
        public void advance( ) {
            if( isValid( ) )
                current = current.next;
        }

        ListNode current;    // Current position
    }


// Basic node stored in AA linked list
// Note that this class is not accessible outside
// of package weiss.nonstandard

    class ListNode {
        // Constructors
        public ListNode( Object theElement ) {
            this( theElement, null );
        }

        public ListNode( Object theElement, ListNode n ) {
            element = theElement;
            next    = n;
        }

        public Object   element;
        public ListNode next;
    }

}


// LinkedListIterator class; maintains "current position"
//
// CONSTRUCTION: Package visible only, with AA ListNode
//
// ******************PUBLIC OPERATIONS*********************
// void advance( )        --> Advance
// boolean isValid( )     --> True if at valid position in list
// Object retrieve        --> Return item in current position

/**
 * Linked list implementation of the list iterator
 *    using AA header node.
 * @author Mark Allen Weiss
 * @see LinkedList
 */

