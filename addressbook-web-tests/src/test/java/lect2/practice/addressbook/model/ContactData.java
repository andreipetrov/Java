package lect2.practice.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String initial;
  private String surname;
  private String position;
  private String companyTitle;
  private String address;
  private String mobilePhone;
  private String email;
  private String age;
  private String secondAddress;
  private String secondPhone;
  private String notes;
  private String group;

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

  public int getId() {
    return id;
  }

  // public String getGroup() {   return group;  }


  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withInitial(String initial) {
    this.initial = initial;
    return this;
  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public ContactData withPosition(String position) {
    this.position = position;
    return this;
  }

  public ContactData withCompanyTitle(String companyTitle) {
    this.companyTitle = companyTitle;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withAge(String age) {
    this.age = age;
    return this;
  }

  public ContactData withSecondAddress(String secondAddress) {
    this.secondAddress = secondAddress;
    return this;
  }

  public ContactData withSecondPhone(String secondPhone) {
    this.secondPhone = secondPhone;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

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

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return surname != null ? surname.equals(that.surname) : that.surname == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
