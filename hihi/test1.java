public class test1 {

    public static String Format(String obj) {
        String[] chuoi = obj.split("\\s");
        String tab = "";
        for (String c : chuoi) {
            String first = c.substring(0, 1);
            String next = c.substring(1);
            tab = tab + first.toUpperCase() + next.toLowerCase() + " ";
        }
        return tab;
    }

    public static String Format2(String obj) {
        String chuoi[] = obj.split("\\s");
        String tab = "";
        for (String c : chuoi) {
            String first = c.substring(0, 1);
            String last = c.substring(1);
            tab = tab + first.toLowerCase() + last.toUpperCase() + " ";
        }
        return tab;
    }

    public static String Format3(String obj) {
        String chuoi[] = obj.split("\\s");
        String tab = "";
        for (String c : chuoi) {
            StringBuilder sb = new StringBuilder(c);
            sb.reverse();
            String first = sb.substring(0, 1);
            String last = sb.substring(1);
            tab = tab + first.toUpperCase() + last.toLowerCase() + " ";
        }
        return tab;

    }

    public static void main(String[] args) {
        String test = "toi di hoc";
        System.out.println(Format(test));
        System.out.println(Format2(test));
        System.out.println(Format3(test));

    }
}