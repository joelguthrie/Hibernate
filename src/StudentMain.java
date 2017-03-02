/**
 * Created by Joel on 2/27/2017.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StudentMain {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();

        //Inserting records
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setName("Frodo");
        student.setStandard("Shire");
        session.save(student);
        tx.commit();

        System.out.println("Inserted Hobbit stuff!");

        //select records
        Object object = session.load(Student.class, "Frodo");
        Student stud = (Student) object;
        System.out.println("Selected hobbits stuff");
        System.out.println("Hobbit name" + stud.getName());
        System.out.println("Hobbit's home" + stud.getStandard());

        //update records!
        System.out.println("Updating the hobbits stuff");
        Transaction tx1 = session.beginTransaction();
        stud.setStandard("Wherever the elves go");
        session.update(stud);
        tx1.commit();

        //Selecting records again after updating
        Object object1 = session.load(Student.class, "Frodo");
        Student stud1 = (Student) object1;
        System.out.println("Selected hobbits stuff after updating:");
        System.out.println("Hobbit name" + stud.getName());
        System.out.println("Hobbit's home" + stud.getStandard());

        //Removing records from the database
        System.out.println("Deleting Everything");
        Transaction tx2 = session.beginTransaction();
        session.delete(stud1);
        tx2.commit();

        System.out.println("All Done Deleting!");
        if (session!= null)
            session.close();




    }
}
