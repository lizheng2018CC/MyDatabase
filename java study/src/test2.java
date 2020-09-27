public class test2{
    public static void main(String[] args) {
        Person p = new Person(1,"刘德华");
        System.out.println(p.getClass());  
        System.out.println(p.getClass().getName()); 
    }
}

class Person{
    int id;
    String name;
    public Person(int id, String name) {
//        super();
        this.id = id;
        this.name = name;
    }
}