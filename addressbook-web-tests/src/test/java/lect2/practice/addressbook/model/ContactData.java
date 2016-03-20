package lect2.practice.addressbook.model;

public class ContactData {
  private final String id;
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
    this.id = null;
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

  public ContactData(String id, String name, String initial, String surname,
                     String position, String companyTitle, String address,
                     String mobilePhone, String email, String age,
                     String secondAddress, String secondPhone, String notes
                     // String group
                     ) {
    this.id = id;
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

  public String getId() {
    return id;
  }

  // public String getGroup() {   return group;  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return surname != null ? surname.equals(that.surname) : that.surname == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
