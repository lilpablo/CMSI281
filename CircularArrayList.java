public class CircularArrayList extends AbstractArrayList implements CircularCollectible {

    public CircularArrayList() {
        super();
    }

    public CircularArrayList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        boolean compare = (size == 0);
        return compare;
        //throw new UnsupportedOperationException();
    }

    public int size() {
        return size;
        //throw new UnsupportedOperationException();
    }

    public void add(String s) {
        if (size < arraySize ){
            elements[size] = s;
            size++;
        } else {
            arraySize = 2*arraySize ;
            String[] newElements = new String[arraySize];
            for (int i = 0; i < size; i++){
                newElements[i]=elements[i];
            }
            elements = newElements;
            elements[size] = s;
            size++;
        }
        /*
        int size = elements.length;
        String [] newElements = new String[(elements.length+1)];
        for (int i = 0; i < elements.length; i++){
            newElements[i] = elements[i];
        }
        newElements[size]=s;
        elements = newElements;*/
        //throw new UnsupportedOperationException();
    }
    
    public String first() {
        int i;
        for (i=0; elements[i] == null || i < size; i++);
        return elements[i];
     // return elements[0];
    }

    /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        boolean first = true;
        int count = 0;
        int other = 0;
       // String [] holder =new String[elements.length-1];
        for (int i = 0; i < size; i++){
            if(elements[i]==(s) && (first)){
         //       other++;
                  first = false;
                  elements[i] = null;
            }
         //   holder[count] = elements[other];
         //   count++;
         //   other++;
        }
        //elements = holder;
        //throw new UnsupportedOperationException();
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
 //       String [] dummy = new String [elements.length];
 //       int count = 0;
          int other = 0;
        for (int i = 0; i<elements.length-1; i++){
            if (elements[i]==(s)){
                other++;
                elements[i] = null;
            }
           // dummy[count] = elements[other];
 //           count++;
 //           other++;

        }
  //      elements = dummy;
        //throw new UnsupportedOperationException();
    }

    public CircularIterator iterator() {
        return new CircularArrayListIterator();
    }

    class CircularArrayListIterator implements CircularIterator {
        int index;
        public CircularArrayListIterator() {
            index = 0;
            //throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            boolean next = (size == 0);
            return next;
           /* if(elements[1] != null){
                return true;
            } else {
                return false;
            }*/
            //throw new UnsupportedOperationException();
        }

        public String next() {
            while (elements[index] == null){
                index++;
                if (index >= arraySize){
                    index -= arraySize;
                }
            }
            return elements[index];
          /*  if (elements[index] != null){
                index++;
                if (index > elements.length-1){
                    index = index - elements.length;
                }
                return elements[index];
            } else {
                return null;
            }*/
            //throw new UnsupportedOperationException();
        }

        /** remove():
         *  removes the last/previous element in the list
         *  (i.e. removes the element that was returned by the
         *  most recent call to next())
         */
        public void remove() {
            elements[index] = null;
            size--;
            next();
            //throw new UnsupportedOperationException();
        }

        /** removeKth(int k):
         *  iterates through the next k elements and removes
         *  the kth one. The next call to removeKth would
         *  start at the node after the removed node.
         *  (i.e. elements[kthElementIndex] because you've shifted
         *  everything over)
         */
        public String removeKthElement(int k) {
        for (int i = 0; i < k; i++){
            next();
        }
   
        String kElement = elements[index];
        remove();
        System.out.println(kElement);
        return kElement;
        
            //throw new UnsupportedOperationException();
        }

        public boolean oneElementLeft() {
            return (size == 1);
            //throw new UnsupportedOperationException();
        }
    }

}
