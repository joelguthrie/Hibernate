/**
 * Created by Joel on 2/27/2017.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate" , catalog = "hibernateschema")

public class Student {
    @Id
    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name = "standard", unique = true, nullable = false, length = 100)
    private String standard;

    public String getStandard(){
        return standard;
    }
    public void setStandard(String standard){
        this.standard = standard;
    }
    public String getName(){
        return name;
    }
    public void setName(String string){
        name = string;
    }
    public String toString(){
        return name;
    }
}
