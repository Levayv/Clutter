package am.levayv.testing.claio.oop2.location;

import am.levayv.testing.claio.oop2.location.RoomInterface;
import am.levayv.testing.claio.oop2.person.Person;

import java.util.HashSet;

public abstract class Room implements RoomInterface {
    // Store data = Room's name
    protected String name;
    // Instance object, ensure filling the name
    public Room(){
        setName();
    }
    // When creating Room's concrete subclass must implement, how to define name
    protected abstract void setName();
    public String getName() {
        return name;
    }

    // Store data = people inside
    private HashSet<Person> people = new HashSet<Person>();

    // People entering room implementation
    @Override
    public void enter(Person person) {
        people.add(person);
    }

    // People exiting room implementation
    @Override
    public void exit(Person person) {
        people.remove(person);
    }

    // How many people are in this room
    public final int getPeopleCount(){
        return people.size();
    }


}
