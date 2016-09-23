import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private int age;
  private String email;
  private String phone;
  private int id;
  private int stylistId;


  public Client(String name, int age, String email, String phone) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.categoryId = categoryId;
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

  public int getId() {
    return id;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public static List<Task> all() {
    String sql = "SELECT id, name, email, phone, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }
