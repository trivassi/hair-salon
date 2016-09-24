import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @Test
  public void Task_instantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithName_String() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals("Harry", myStylist.getName());
  }

  @Test
  public void Stylist_instantiatesWithAge_int() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals(34, myStylist.getAge());
  }

  @Test
  public void Stylist_instantiatesWithEmail_String() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals("harry@gmail.com", myStylist.getEmail());
  }

  @Test
  public void Stylist_instantiatesWithPhone_String() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertEquals("123-456-7890", myStylist.getPhone());
  }

}
