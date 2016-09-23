import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private int age;
  private String email;
  private String phone;
  private boolean employed;
  private int id;


  public Client(String name, int age, String email, String phone, boolean employed) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
    employed = false;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public boolean getEmployed() {
    return employed;
  }

  public int getId() {
    return id;
  }
