import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteCategoriesQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("Dan", myClient.getName());
  }

  @Test
  public void Client_instantiatesWithAge_int() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals(38, myClient.getAge());
  }

  @Test
  public void Client_instantiatesWithEmail_String() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("dan@gmail.com", myClient.getEmail());
  }

  @Test
  public void Client_instantiatesWithPhone_String() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals("dan@gmail.com", myClient.getPhone());
  }

  @Test
  public void Client_instantiatesWithAppointment_Date() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals(testDate, myClient.getAppointment());
  }

  @Test
  public void Client_instantiatesWithStylistId_int() {
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    Date testDate = Date.valueOf("2016-08-01");
    assertEquals(1, myClient.getStylistId());
  }

}
