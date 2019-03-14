package am.levayv.testing.claio.oop2.location;

import am.levayv.testing.claio.oop2.person.Person;

public interface RoomInterface {
    //Someone can enter the room
    void enter(Person person);
    //Someone can exit the room
    void exit(Person person);
}
