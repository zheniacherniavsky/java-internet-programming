package by.belstu.it.cherniavsky.basejava;

import java.util.Objects;

public class WrapperString {

    public WrapperString(String s1) {
        this.s1 = s1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(s1, that.s1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1);
    }

    private String s1;

    @Override
    public String toString() {
        return "WrapperString{" +
                "s1='" + s1 + '\'' +
                '}';
    }

    public void replace (char oldchar, char newchar)
    {
        this.s1 = s1.replace(oldchar, newchar);
    }
}

class NewWrapper extends WrapperString
{
    public NewWrapper(String s1) {
        super(s1);
    }
}