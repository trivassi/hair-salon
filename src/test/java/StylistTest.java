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

  @After
   public void tearDown() {
     try(Connection con = DB.sql2o.open()) {
       String deleteClientsQuery = "DELETE FROM clients *;";
       String deleteStylistsQuery = "DELETE FROM stylists *;";
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

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Arnold", 34, "arnold@gmail.com", "123-456-7890");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void clear_emptiesAllStylistsFromArrayList_0() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890"); assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void getId_returnsId_true() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    myStylist.save();
    assertTrue(myStylist.getId() > 0);
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Arnold", 34, "arnold@gmail.com", "123-456-7890");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    Stylist secondStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_returnsTrueIfNamesAretheSame() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void update_updateStylistName_true() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    myStylist.save();
    myStylist.updateName("Ron");
    assertEquals("Ron", Stylist.find(myStylist.getId()).getName());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Harry", 34, "harry@gmail.com", "123-456-7890");
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
  }



}
