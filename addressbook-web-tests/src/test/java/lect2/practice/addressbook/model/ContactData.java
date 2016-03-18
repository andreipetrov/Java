package lect2.practice.addressbook.model;

public class ContactData {
  private final String name;
  private final String initial;
  private final String surname;
  private final String position;
  private final String companyTitle;
  private final String address;
  private final String mobilePhone;
  private final String email;
  private final String age;
  private final String secondAddress;
  private final String secondPhone;
  private final String notes;
  private String group;

  public ContactData(String name, String initial, String surname,
                     String position, String companyTitle, String address,
                     String mobilePhone, String email, String age,
                     String secondAddress, String secondPhone, String notes
                     // String group
                     ) {
    this.name = name;
    this.initial = initial;
    this.surname = surname;
    this.position = position;
    this.companyTitle = companyTitle;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.email = email;
    this.age = age;
    this.secondAddress = secondAddress;
    this.secondPhone = secondPhone;
    this.notes = notes;
    //this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getIbitial() {
    return initial;
  }

  public String getSurname() {
    return surname;
  }

  public String getPosition() {
    return position;
  }

  public String getCompanyTitle() {
    return companyTitle;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getAge() {
    return age;
  }

  public String getSecondAddress() {
    return secondAddress;
  }

  public String getSecondPhone() {
    return secondPhone;
  }

  public String getNotes() {
    return notes;
  }

  // public String getGroup() {   return group;  }
}
