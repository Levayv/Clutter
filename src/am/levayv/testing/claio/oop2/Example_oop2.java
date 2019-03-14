package am.levayv.testing.claio.oop2;

import am.levayv.testing.claio.oop2.location.Room;
import am.levayv.testing.claio.oop2.person.Occupation;
import am.levayv.testing.claio.oop2.person.Person;
import am.levayv.testing.claio.oop2.person.Profession;

public class Example_oop2 {
    /** Entry point */
    public static void start() {
        // Define a room where interview held
        Amsterdam room = new Amsterdam();

        Person interviewee  = new Person(
                "Levon"
        );
        Person interviewer1 = new Person (
                "Elona",
                Occupation.HUMAN_RESOURCES
        );
        Person interviewer2 = new Person(
                "Artak",
                Profession.JAVA_ENGINEER,
                Occupation.DEVELOPER);
        Person interviewer3 = new Person(
                "Karen",
                Profession.JAVA_ENGINEER,
                Occupation.DEVELOPER
        );

        System.out.println("We are in "+room.getName() + " meeting room.");
        room.enter(interviewer1);
        room.enter(interviewee);
        // HR questions
        System.out.println("There are total of "+room.getPeopleCount()+" people during HR questions");

        room.exit(interviewer1);

        room.enter(interviewer2);
        room.enter(interviewer3);
        // Dev questions ...
        System.out.println("There are total of "+room.getPeopleCount()+" people during Dev questions");

        room.exit(interviewer2);
        room.exit(interviewer3);
        room.exit(interviewee);
    }
    /** Nested class example */
    static class Amsterdam extends Room {
        /** Set this room's name */
        @Override
        protected void setName() {
            // use reflection
            this.name = this.getClass().getSimpleName();
        }
    }
}
