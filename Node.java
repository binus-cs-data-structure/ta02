/**
 * Node class yang merepresentasikan sebuah node dalam linked list
 * Dalam single linked list, node minimal berisi data, dan next pointer
 * Next pointer digunakan untuk menunjuk ke node berikutnya dalam linked list
 */
class Node {
    Customer customer;
    Node next;
    
    public Node(Customer customer) {
        this.customer = customer;
        this.next = null;
    }
    
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}