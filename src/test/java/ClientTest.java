import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @Test
  public void Client_instantiatesCorrectly_true() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals("Dan", myClient.getName());
  }

  @Test
  public void Client_instantiatesWithAge_int() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals(38, myClient.getAge());
  }

  @Test
  public void Client_instantiatesWithEmail_String() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals("dan@gmail.com", myClient.getEmail());
  }

  @Test
  public void Client_instantiatesWithPhone_String() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals("123-456-6534", myClient.getPhone());
  }

  @Test
  public void Client_instantiatesWithAppointment_Date() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals(testDate, myClient.getAppointment());
  }

  @Test
  public void Client_instantiatesWithStylistId_int() {
    Date testDate = Date.valueOf("2016-08-01");
    Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    assertEquals(1, myClient.getStylistId());
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Date testDate = Date.valueOf("2016-08-01");
    Client firstClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
    firstClient.save();
    Client secondClient = new Client("Joe", 39, "joe@gmail.com", "123-456-6534", testDate, 2);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  // @Test
  // public void getId_returnsId_true() {
  //   Date testDate = Date.valueOf("2016-08-01");
  //   Client myClient = new Client("Dan", 38, "dan@gmail.com", "123-456-6534", testDate, 1);
  //   myClient.save();
  //   assertTrue(myClient.getId() > 0);
  // }


}
