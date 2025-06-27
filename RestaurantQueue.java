/**
 * RestaurantQueue class yang merepresentasikan antrian restoran
 * Implementasi menggunakan Single Linked List
 * FIFO (First In First Out) untuk mengatur urutan pelayanan customer
 */
class RestaurantQueue {
    // Pointer ke customer pertama dalam antrian
    // head selalu menunjuk ke node pertama dan akan selalu berubah jika ada customer yang mau dilayani
    private Node head;
    // Pointer ke customer terakhir dalam antrian
    // tail selalu menunjuk ke node terakhir dan akan selalu berubah jika ada customer yang baru antri
    // Jika tail berubah, maka head juga akan berubah
    private Node tail;
    // Jumlah customer dalam antrian
    private int size;
    
    public RestaurantQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Push operation - Menambahkan customer ke dalam antrian
     * Time Complexity: O(1)
     */
    public void push(Customer customer) {
        Node newNode = new Node(customer);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        System.out.println("Customer added: " + customer);
        displayQueue();
    }
    
    /**
     * Pop operation - Menghapus dan mengembalikan customer dari depan antrian
     * Time Complexity: O(1)
     */
    public Customer pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No customer to serve");
            return null;
        }
        
        Customer servedCustomer = head.getCustomer();
        head = head.getNext();
        
        if (head == null) {
            tail = null;
        }
        
        size--;
        System.out.println("Customer served: " + servedCustomer);
        displayQueue();
        return servedCustomer;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int getSize() {
        return size;
    }
    
    /**
     * Menampilkan status antrian
     */
    public void displayQueue() {
        clearConsole();
        System.out.println("=== Current Queue Status ===");
        if (isEmpty()) {
            System.out.println("   Queue is empty.");
        } else {
            System.out.println("   Queue size: " + size);
            System.out.print("   Queue order (front → back): ");
            
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.getCustomer().getName() + "] ");
                current = current.getNext();
                if (current != null) {
                    System.out.print("→ ");
                }
            }
            System.out.println();
        }
        System.out.println("================================\n");
    }
    
    /**
     * Menghapus console supaya lebih rapi
     */
    private void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.print("\033[2J\033[H");
            System.out.flush();
        }
    }
    
    /**
     * Peek operation - Melihat customer yang paling depan
     * Time Complexity: O(1)
     */
    public Customer peek() {
        if (isEmpty()) {
            return null;
        }
        clearConsole();
        return head.getCustomer();
    }
}