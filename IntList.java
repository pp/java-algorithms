public class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        ListNode(int elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            if (this.next == null) {
                this.next = new ListNode(elem, null);
            } else {
                this.next.add(elem);
            }
        }

        void reverse() {
            ListNode reversedPart = null;
            ListNode current = this;
            while (current != null) {
                ListNode next = current.next;
                current.next = reversedPart;
                reversedPart = current;
                current = next;
            }
            head = reversedPart;
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    // Test if the list is empty
    public boolean empty() {
        return this.head == null;
    }

    // Add element to the list
    public void add(int elem) {
        if (this.empty()) {
            this.head = new ListNode(elem, null);
        } else {
            this.head.add(elem);
        }
    }

    // Test if the list contains a specific value at least once
    public boolean search(int value) {
        ListNode currentNode = this.head;
        while (currentNode.getNext() != null) {
            if (currentNode.getElem() == value) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // Remove all occurrences of a specific value
    // Return true if at least one element was removed
    public boolean remove(int value) {
        ListNode tmpNode = this.head;
        ListNode previousNode = null;
        boolean deleted = false;

        while (tmpNode != null) {
            if (tmpNode.elem == value) {
                if (tmpNode == this.head)
                    this.head = this.head.next;
                else
                    previousNode.next = tmpNode.next;
                deleted = true;
            } else {
                previousNode = tmpNode;
            }
            tmpNode = tmpNode.next;
        }

        return deleted;
    }

    // Return the first element (the head) of the list
    public int first() {
        return this.head.getElem();
    }

    // Reverse the list
    public void reverse() {
        if (empty() || this.head.next == null)
            return;
        else
            this.head.reverse();
    }

    // Return a string representation of the list
    public String toString() {
        return "[" + this.head + "]";
    }

}
