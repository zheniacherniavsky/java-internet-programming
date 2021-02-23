package by.belstu.cherniavsky.users;

public abstract class User {

    public String adminKey = null;
    protected final String name;
    protected final String lastname;
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
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", isAdmin=" + isAdmin +
                ", id=" + id +
                '}';
    }
}
