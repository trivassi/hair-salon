import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteTasksQuery = "DELETE FROM clients *;";
      String deleteCategoriesQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void Task_instantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithName_String() {
    Stylist myStylist = new Stylist("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("Dan", myStylist.getName());
  }

  @Test
  public void Stylist_instantiatesWithAge_int() {
    Stylist myStylist = new Stylist("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals(38, myStylist.getAge());
  }

  @Test
  public void Stylist_instantiatesWithEmail_String() {
    Stylist myStylist = new Stylist("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("dan@gmail.com", myStylist.getEmail());
  }

  @Test
  public void Stylist_instantiatesWithPhone_String() {
    Stylist myStylist = new Stylist("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("dan@gmail.com", myStylist.getPhone());
  }

}
