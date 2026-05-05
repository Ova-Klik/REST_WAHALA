package ESTORE;

public class User {
    private int age;
    private String name;
    private final String password;
    private final String email;

    public User(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;

    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}

    public void setAge(int age){this.age = age;}
    public void setName(){this.name=name;}


}
