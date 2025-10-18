public class HelloWorld {
  public static void main(String[] args) {
    Person person = new Person("Thomas", "Anderson");
    person.greet();
    greet(person.getFirstName() + " " + person.lastName);
  }

  public static void greet(String first_name) {
    System.out.println("Hello " + first_name);
  }
}