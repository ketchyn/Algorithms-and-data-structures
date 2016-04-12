package Company;

/**
 * Created by Alexandr on 02.04.2016.
 */
public class Emploee <T>  {
    public T  name;

    public Emploee(T name) {
        this.name = name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}
