package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public <App> void getCommunities_returnsAllApp_List() {
        App testApp = new App("Fire Enthusiasts", "Flame on!");
        testApp.save();
        Person testPerson = new Person("Henry", "[email protected]Links to an external site.");
        testPerson.save();
        testApp.addPerson(testPerson);
        List savedCommunities = testPerson.getApp();
        assertEquals(1, savedCommunities.size());
    }

}