import java.util.List;
import java.util.ArrayList;
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

  public Client(String name, int age, String email, String phone, Date appointment,int stylistId) {
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

  public static List<Client> all() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients";
    return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getAge() == newClient.getAge() &&
             this.getEmail().equals(newClient.getEmail()) &&
             this.getPhone().equals(newClient.getPhone()) &&
             this.getId() == newClient.getId() &&
             this.getAppointment().equals(newClient.getAppointment()) &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, age, email, phone, appointment, stylistid) VALUES (:name, :age, :email, :phone, :appointment, :stylistid)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("age", this.age)
        .addParameter("email", this.email)
        .addParameter("phone", this.phone)
        .addParameter("appointment", this.appointment)
        .addParameter("stylistid", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients where id=:id";
    Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    return client;
    }
  }

  public void updateName(String name) {
   try(Connection con = DB.sql2o.open()) {
   String sql = "UPDATE clients SET name = :name WHERE id = :id";
   con.createQuery(sql)
     .addParameter("name", name)
     .addParameter("id", id)
     .executeUpdate();
   }
 }

 public void updateAge(int age) {
  try(Connection con = DB.sql2o.open()) {
  String sql = "UPDATE clients SET age = :age WHERE id = :id";
  con.createQuery(sql)
    .addParameter("age", age)
    .addParameter("id", id)
    .executeUpdate();
    }
  }

   public void updateEmail(String email) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE clients SET email = :email WHERE id = :id";
    con.createQuery(sql)
      .addParameter("email", email)
      .addParameter("id", id)
      .executeUpdate();
      }
    }

  public void updatePhone(String phone) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE clients SET phone = :phone WHERE id = :id";
    con.createQuery(sql)
    .addParameter("phone", phone)
    .addParameter("id", id)
    .executeUpdate();
    }
  }

  // public void updateAppointment(Date appointment) {
  //   try(Connection con = DB.sql2o.open()) {
  //   String sql = "UPDATE clients SET appointment = :appointment WHERE id = :id";
  //   con.createQuery(sql)
  //   .addParameter("appointment", appointment)
  //   .addParameter("id", id)
  //   .executeUpdate();
  //   }
  // }


 public void delete() {
   try(Connection con = DB.sql2o.open()) {
   String sql = "DELETE FROM clients WHERE id = :id;";
   con.createQuery(sql)
     .addParameter("id", id)
     .executeUpdate();
   }
 }


}
