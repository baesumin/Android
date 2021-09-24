package org.techtown.contactroom.model;

public class Contact {
  private int id;
  private String name;
  private String occupation;

  public Contact() {
  }

  public Contact(int id, String name, String occupation) {
    this.id = id;
    this.name = name;
    this.occupation = occupation;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getOccupation() {
    return occupation;
  }
}
