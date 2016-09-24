import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Date;

public class Client {
  private String name;
  private int age;
  private String email;
  private String phone;
  private int id;
  private Date appointment;
  private int stylistId;

  public Client(String name, int age, String email, String phone, Date appointment) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.appointment = appointment;
    this.stylistId = stylistId;
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

  public Date getAppointment() {
    return appointment;
  }

  public int getStylistId() {
    return stylistId;
  }


  public static List<Task> all() {
    String sql = "SELECT id, name, email, phone, appointment, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }
