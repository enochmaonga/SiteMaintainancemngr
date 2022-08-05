import models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.sql2o.*;

class AppTest {

    @BeforeEach
    void setUp() {


        @Test
        public void getName_APPInstantiatesWithDescription_String;() {
            App testAPP = new App("Water Enthusiasts", "Lovers of all things water monsters!");
            assertEquals("Lovers of all things water monsters!", testAPP.getDescription());
        }
    }

    @Test
    public void equals_returnsTrueIfNameAndDescriptionAreSame_true() {
        App testApp = new App("Fire Enthusiasts", "Flame on!");
        App anotherApp = new App("Fire Enthusiasts", "Flame on!");
        assertTrue(testApp.equals(anotherApp));
    }

    @Test
    public void save_insertsObjectIntoDatabase_App() {
        App testApp = new App("Fire Enthusiasts", "Flame on!");
        testApp.save();
        assertEquals(true, App.all().get(0).equals(testApp));
    }

    @Test
    public void all_returnsAllInstancesOfApp_true() {
        App firstApp = new App("Fire Enthusiasts", "Flame on!");
        firstengineers.save();
        App secondengineers = new App("Water Enthusiasts", "Lovers of all things water monsters!");
        secondengineers.save();
        assertEquals(true, engineers.all().get(0).equals(firstApp));
        assertEquals(true, engineers.all().get(1).equals(secondApp));
    }
    @Test
    public void addPerson_addsPersonToengineers() {
        App testApp = new App("Fire Enthusiasts", "Flame on!");
        testengineers.save();
        Person testPerson = new Person("Henry", "[email protected]Links to an external site.");
        testPerson.save();
        testengineers.addPerson(testPerson);
        Person savedPerson = (Person) testengineers.getPersons().get(0);
        assertTrue(testPerson.equals(savedPerson));
    }
    @Test
    public void getPersons_returnsAllPersons_List() {
        App testengineers = new App("Fire Enthusiasts", "Flame on!");
        testengineers.save();
        Person testPerson = new Person("Henry", "[email protected]Links to an external site.");
        testPerson.save();
        testengineers.addPerson(testPerson);
        List savedPersons = testengineers.getPersons();
        assertEquals(savedPersons.size(), 1);
    }
    @Test
    public void delete_deletesengineers_true() {
        engineers testCommunity = new engineers("Fire Enthusiasts", "Flame on!");
        testCommunity.save();
        testCommunity.delete();
        assertEquals(0, engineers.all().size());
    }
    @Test
    public void delete_deletesAllPersonsAndCommunitiesAssociations() {
        engineers testengineers = new engineers("Fire Enthusiasts", "Flame on!");
        testengineers.save();
        Person testPerson = new Person("Henry", "henry@henry.com");
        testPerson.save();
        testengineers.addPerson(testPerson);
        testengineers.delete();
        assertEquals(0, testPerson.getCommunities().size());
    }
}
