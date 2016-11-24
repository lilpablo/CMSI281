public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {
    Node last;
    public CircularLinkedList() {
        super();
        last = null;
    }
    

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        boolean compare = n==0;
        return compare;
        //throw new UnsupportedOperationException();
    }

    public int size() {
        return n;
        //throw new UnsupportedOperationException();
    }

    public void add(String s) {
        //double check
        //Node next = new Node (first,s);
        //first = next;
        first = new Node (first,s);
        if (size()==0){
            last = first;
        }
        last .next = first;
        n++;
        //throw new UnsupportedOperationException();
    }

    public String first() {
        return first.value;
    }

    /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        //check both removes
        boolean once = false;
        Node current = first;
       // Node prev = null;
       for (int i = 0; i < n && !once; i++){
           if (current.next.value == s){
               current.next = current.next.next;
               n--;
               once = true;
           }
           current = current.next;
       }
       /* if (first.value.equals(s)){
            first = first.next;
            n--;
            once = true;
        }
        while (current != null && !once){
            if(current.value.equals(s)){
                prev.next = current.next;
                n--;
                once = true;
            }
            prev = current;
            current = current.next;
            if (current == null){
                once = false;
            }
        }*/
        //throw new UnsupportedOperationException();
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
        Node current = first;
        Node prev = null;
        for (int i = 0; i < n; i++){
            if (current.next.value == s){
                current.next = current.next.next;
                n--;
            }
            current = current.next;
        }
       /* if (first.value.equals(s)){
            first = first.next;
            n--;
            return;
        }
        while (current != null){
            if(current.value.equals(s)){
                prev.next = current.next;
                n--;
            }
            prev = current;
            current = current.next;
        }*/
       // throw new UnsupportedOperationException();
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        Node here;
        public CircularLinkedListIterator() {
            here = first;
        }

        public boolean hasNext() {
            boolean FALSE = n ==0;
            return FALSE;
            /*if (here.next != null){
                return true;
            } else{
                return false;
            }*/
        }

        public String next() {
            here= here.next;
            return here.value;
            //throw new UnsupportedOperationException();
        }

        /** remove():
         *  removes the last/previous element in the list
         *  (i.e. removes the element that was returned by the
         *  most recent call to next())
         */
        public void remove() {
            here.value = here.next.value;
            here.next = here.next.next;
            if(here.value ==(first.value)){
                first = here;
            }
            n--;
            //throw new UnsupportedOperationException();
        }

        /** removeKth(int k):
         *  iterates through the next k elements and removes
         *  the kth one. The next call to removeKth would
         *  start at the node after the removed node.
         *  (i.e. kthNode.next)
         */
        public String removeKthElement(int k) {
            for (int i = 1; i < k; i++){
                next();
            }
            String kElement = here.value;
            remove();
            return kElement;
        }

        public boolean oneElementLeft() {
            boolean TRUE =(n ==1);
            return TRUE;
            /*if (first.next != null){
                return false;
            } else {
                return true;
            }*/
            //throw new UnsupportedOperationException();
        }
    }
}

