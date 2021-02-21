package by.belstu.it.cherniavsky.basejava;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static java.lang.Math.log;
import static java.lang.String.valueOf;

public class Main {
    /**
     * main function
     * @param args it is arguments from console window
     */
    public static void main(String[] args) {

        /** Создание объекта JavaTest
         * @see JavaTest()
         */
        JavaTest JT = new JavaTest();

        System.out.println("Hello" + JT.myInt);
        System.out.println("Hello" + JT.myChar);
        System.out.println("Hello" + JT.myDouble);

        byte b = (byte) (JT.myByte + JT.myInt);
        int i = (int) (JT.myDouble + JT.myLong);
        long l = JT.myInt + 2147483647;

        System.out.println(b);
        System.out.println(i);
        System.out.println(l);
        System.out.println(JT.sInt);

        boolean f = false;
        boolean t = true;
        boolean alwaysF = f && t;
        boolean alwaysT = f ^ t;

        // System.out.println(f + t); dont work

        long a = 9223372036854775807L;
        long byt = 0x7fff_ffff_fffL;
        
        char c1 = 'a';
        char c2 = '\u0061';
        char c3 = 97;

        System.out.println("=============");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println((char)(c1 + c2 + c3)); // we sum the char code and get char symbol by this code

        System.out.println("=============");
        System.out.println(3.45 % 2.4); // we can use % at float numbers
        System.out.println(1.0/0.0); // we can divide by zero and get infinity
        System.out.println(0.0/0.0); // NaN
        System.out.println(log(-345)); // NaN
        System.out.println(Float.intBitsToFloat(0x7F800000)); // Infinity
        System.out.println(Float.intBitsToFloat(0xFF800000)); // -Infinity

        // we have hex, octal, binary

        var p = Math.round(Math.PI);
        var e = Math.round(Math.E);

        System.out.println(p);
        System.out.println(e);
        System.out.println(Math.min(p,e));

        System.out.println("====RANDOM CHECK ======");

        // random Math.round(Math.random() % 1) in radius [0,1]

        var r = new Random(47);
        for (int j = 0; j < 10; j++) {
            System.out.println(r.nextInt(2));
        }

        System.out.println("==== different operations with type objects ======");
        Integer intObj = -7;
        System.out.println(Integer.toBinaryString(intObj));
        intObj = intObj >> 2;
        System.out.println(Integer.toBinaryString(intObj));
        intObj = -7;
        System.out.println(Integer.toBinaryString(intObj));
        intObj = intObj >>> 2;
        System.out.println(Integer.toBinaryString(intObj));

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        int boxingI = 3;
        Integer boxingInt = boxingI; // boxing
        boxingI = boxingInt; // unboxing

        byte boxingB = 3;
        Byte boxingByte = boxingB; // boxing
        boxingB = boxingByte; // unboxing

        System.out.println("====== INTEGER FUNCTIONS ======");
        System.out.println(Integer.parseInt("7262"));
        System.out.println(Integer.toHexString(23));
        System.out.println(Integer.compare(2,2));
        System.out.println(Integer.toString(23));
        System.out.println(Integer.bitCount(boxingI));
        // isNaN is doesn't work idk where is it

        //f task

        String s32 = "2345";

        System.out.println(Integer.parseInt(s32));
        System.out.println(valueOf(s32));

        var barr = s32.getBytes();

        for(byte belement: barr)
        {
            System.out.println(String.format("Byte is [%s]",
                    (char)belement));
        }

        // str to byte array
        boolean strToBool = Boolean.parseBoolean(s32);
        System.out.println(strToBool);

        // byte array to string
        String myNewString = new String(barr, StandardCharsets.UTF_8);
        System.out.println(myNewString);

        // СOMPAAAAAAAAAARE
        String str1 = "Zeka";
        String str2 = "Zehka";
        System.out.println(str1 == str2); // default compare, without null check
        System.out.println(str1.equals(str2)); // cant compare with null

        System.out.println(str1.compareTo(str2));   // this can compare with null
                                                    // also this function may return 0 if equal

        // STRING OPERATIONS
        System.out.println("================");
        String myStr = "Hello, my name is Zhenia and i learn JAVA language";

        // that is split function, which have one arg REGEX;
        String[] splitArr = myStr.split(" ");
        for(String element: splitArr)
        {
            System.out.println(element);
        }

        // contains function
        System.out.println(myStr.contains("JAVA"));

        // hashCode of string
        System.out.println(myStr.hashCode());

        // indexOf return only first meet char
        System.out.println(myStr.indexOf('i'));

        // length
        System.out.println(myStr.length());

        // Replace
        System.out.println(myStr.replace("JAVA", "C++"));
        System.out.println(myStr.replace("i", "I"));

        // g
        System.out.println("============");
        // all this constructions are true
        char[][] arr1;
        char[] arr2[];
        char arr3[][];

        char[] arr4 = new char[0]; // we can but idk for what

        // if we catch indexOutException, java just throw exception
        // for example, c++ dont do it and it is soooo bad, baad boy c++

        arr1 = new char[3][];
        for(int u = 1; u < 4; u++)
        {
            arr1[u - 1] = new char[u];
            System.out.println("length of " + u + " is " + arr1[u-1].length);
        }

        char[] carr1 = new char[3];
        char[] carr2 = new char[3];

        carr2[0] = '1'; carr1[0] = '2';
        System.out.println(carr1 == carr2);

        boolean comRez = carr1 == carr2;
        carr1 = carr2;

        System.out.println(false);

        for (char element:carr2
        ) {
            System.out.println(element);
        }
        for (char element:carr1
        ) {
            System.out.println(element);
        }

        // h

        WrapperString wstr = new WrapperString("Hello");
        wstr.replace('H','h');
        System.out.println(wstr.toString());
    }
}
