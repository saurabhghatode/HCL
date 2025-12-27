public class stringOperations {
    public static void main(String[] args) {

        String s1 = "  Java Programming  ";
        String s2 = "Java";
        String s3 = "Programming";

        // length()
        System.out.println("Length: " + s1.length());

        // isEmpty()
        System.out.println("Is Empty: " + s2.isEmpty());

        // charAt()
        System.out.println("charAt(2): " + s2.charAt(2));

        // toString()
        System.out.println("toString(): " + s2.toString());

        // equals()
        System.out.println("equals(): " + s2.equals("Java"));

        // compareTo()
        System.out.println("compareTo(): " + s2.compareTo("Java"));

        // contains()
        System.out.println("contains(): " + s1.contains("Java"));

        // indexOf()
        System.out.println("indexOf(): " + s1.indexOf("J"));

        // lastIndexOf()
        System.out.println("lastIndexOf(): " + s1.lastIndexOf("a"));

        // startsWith()
        System.out.println("startsWith(): " + s1.trim().startsWith("Java"));

        // endsWith()
        System.out.println("endsWith(): " + s1.trim().endsWith("Programming"));

        // matches()
        System.out.println("matches(): " + s2.matches("[A-Za-z]+"));

        // substring()
        System.out.println("substring(): " + s1.substring(2, 6));

        // toLowerCase()
        System.out.println("toLowerCase(): " + s2.toLowerCase());

        // trim()
        System.out.println("trim(): " + s1.trim());

        // replace()
        System.out.println("replace(): " + s1.replace("Java", "Core Java"));

        // split()
        String[] arr = s1.trim().split(" ");
        System.out.println("split():");
        for (String x : arr)
            System.out.println(x);

        // join()
        System.out.println("join(): " + String.join("-", s2, s3));

        // valueOf()
        int num = 100;
        System.out.println("valueOf(): " + String.valueOf(num));
    }
}
