package am.levayv.testing.claio.oop2.person;

public class Person {
    private String firstName;
    private Profession prof;
    private Occupation job;
    public Person(String name){
        this.firstName = name;
    }
    public Person(String name, Profession prof, Occupation job){
        this.firstName = name;
        this.prof = prof;
        this.job = job;
    }
    public Person(String name, Occupation job){
        this.firstName = name;
        this.job = job;
    }
//STOPSHIP - more useless constructor overloading and getters
//    public Person(String name, Profession prof){
//        this.firstName = name;
//        this.prof = prof;
//    }
//
//    public Occupation getJob() {
//        return job;
//    }
//
//    public Profession getProf() {
//        return prof;
//    }
}
