public class Person {
  private String firstName;
  public String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void greet() {
    System.out.println("Hello " + firstName);
  }
}