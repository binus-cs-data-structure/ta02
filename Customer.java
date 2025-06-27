/**
 * Customer Class yang merepresentasikan customer dalam antrian restoran
 * Simple implementation dengan hanya nama customer
 */
class Customer {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return String.format("Customer {Name: '%s'}", name);
    }
}