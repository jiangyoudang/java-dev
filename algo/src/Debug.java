import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by cong on 4/2/17.
 */
public class Debug {

  public static void main(String[] args) {

    Node a = new Node(2);
    String s = "static";
    System.out.println(s.length());

    List<Integer> array = new ArrayList<>();


  }

  public static void staticFunc() {
    System.out.println("static method");
  }


  public static void reg() {
    String testStr = "etesdnl 650 919 3012";
    final String REGEX = "(\\(?)\\d{3}\\1([- ]?)\\d{3}\\2\\d{4}";
    Pattern p = Pattern.compile(REGEX);
    Matcher m = p.matcher(testStr);
    System.out.println(m.find());
    System.out.println("prefix " + (int) m.group(2).charAt(0));

    System.out.println(m.group(1).length());
  }

}


class Node{
  Node next;
  int val;
  public Node(int a){
    val = a;
  }
}