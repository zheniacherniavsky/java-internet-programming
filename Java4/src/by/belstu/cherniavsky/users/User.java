package by.belstu.cherniavsky.users;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "Admin")
public abstract class User {

    public static ArrayList<User> collection = new ArrayList<User>();

    public String adminKey = null;

    @XmlElement
    protected final String name;
    @XmlElement
    protected final String lastname;
    @XmlElement
    protected final String phone;
    protected final int birthday;
    public boolean isAdmin = false;

    private int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String name, String lastname, String phone, int birthday, boolean isAdmin) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.birthday = birthday;
        this.isAdmin = isAdmin;
        collection.add(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
