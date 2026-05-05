package ESTORE;

public class Customer extends User {
     private ShoppingCart cart;


     public Customer(String name, String email, String password) {
          super(name, email, password);
     }
}

