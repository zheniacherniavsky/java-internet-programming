package by.belstu.it.cherniavsky.basejava;

/**
 * Special class for testing java language
 * @author geshka
 * @author zheniacherniavskyplay@gmail.com
 * @version 1.0
 */
public class JavaTest {

    char myChar = 'c';
    int myInt = 1234;
    short myShort = 13;
    byte myByte = 20;
    long myLong = 123123;
    boolean myBool = false;
    double myDouble = 232;
    static int sInt;

    final int f1;
    public final int f2;
    public static final int f3 = 3;

    public JavaTest() {
        f1 = 2;
        f2 = 3;
        // f4 = 4; we cant because f3 is static variable
        // static variables we should init firstly and out of ctor;
    }
}
