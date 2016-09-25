import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.sql.Date;

public class Stylist {
  private String name;
  private int age;
  private String email;
  private String phone;
  private int id;


  public Stylist(String name, int age, String email, String phone) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
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

  public static List<Stylist> all() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM stylists";
    return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  @Override
  public boolean equals(Object otherStylist){
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getAge() == newStylist.getAge() &&
             this.getEmail().equals(newStylist.getEmail()) &&
             this.getPhone().equals(newStylist.getPhone()) &&
             this.getId() == newStylist.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, age, email, phone) VALUES (:name, :age, :email, :phone)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("age", this.age)
        .addParameter("email", this.email)
        .addParameter("phone", this.phone)
        .executeUpdate()
        .getKey();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM stylists where id=:id";
    Stylist stylist = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
    return stylist;
    }
  }

  public void updateName(String name) {
   try(Connection con = DB.sql2o.open()) {
   String sql = "UPDATE stylists SET name = :name WHERE id = :id";
   con.createQuery(sql)
     .addParameter("name", name)
     .addParameter("id", id)
     .executeUpdate();
    }
  }

  public void updateAge(int age) {
   try(Connection con = DB.sql2o.open()) {
   String sql = "UPDATE stylists SET age = :age WHERE id = :id";
   con.createQuery(sql)
     .addParameter("age", name)
     .addParameter("id", id)
     .executeUpdate();
     }
   }

    public void updateEmail(String email) {
     try(Connection con = DB.sql2o.open()) {
     String sql = "UPDATE stylists SET email = :email WHERE id = :id";
     con.createQuery(sql)
       .addParameter("email", email)
       .addParameter("id", id)
       .executeUpdate();
       }
     }

   public void updatePhone(String phone) {
     try(Connection con = DB.sql2o.open()) {
     String sql = "UPDATE stylists SET phone = :phone WHERE id = :id";
     con.createQuery(sql)
     .addParameter("phone", phone)
     .addParameter("id", id)
     .executeUpdate();
     }
   }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM stylists WHERE id = :id;";
    con.createQuery(sql)
     .addParameter("id", id)
     .executeUpdate();
    }
  }


}
