import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class oo {

  public String test_field;

  public static void main(String[] args) {
    Parent p = new Parent("parent");

    Parent s = new Sub("Sub_Parent", "Sub", 10);

    Sub s2 = new Sub("Sub", "Sub2", 11);

    System.out.println( p.field );

    System.out.println(Parent.class);
    System.out.println(s2.field == p.field);
    System.out.println( s.field );
    System.out.println( s2.field );



//    p.callPrivateFuc();
//    s.callPrivateFuc();
//    s2.callPrivateFuc();
//
//    System.out.println(s.privateFunc());
//    System.out.println("**********");
//    System.out.println(s.getName());
//
//    System.out.println("**********");
//
//    p.getNameStatic();
//    s.getNameStatic();
//
//    ((Sub) s).isSame();
//
////    Field f_name = Sub.class.getDeclaredField("name");
//    System.out.println(Arrays.toString(s.getClass().getClasses()));
//    System.out.println(Arrays.toString(p.getClass().getDeclaredFields()));
//    try {
//      System.out.println(s.getClass().getDeclaredMethod("getNameStatic") == p.getClass()
//          .getDeclaredMethod("getNameStatic"));
//      System.out.println(s.getClass().getDeclaredMethod("getNameStatic"));
//
//    } catch (NoSuchMethodException e) {
//      System.out.println(e);
//    }


  }



}


class Parent {

  private String name;
  public String test_field;
  final static String field = "static field Parent";

  public Parent() {
    System.out.println("a shit");
  }

  public Parent(String name) {
    this.name = name;
  }

  public String privateFunc() {
    return name;
  }

  public void callPrivateFuc() {
    System.out.println(privateFunc());
  }

  public static void getNameStatic() {
    System.out.println("Static func");
  }


  public String getName() {
    System.out.println("parent func");
    return name;
  }


  public static void print(Object[] obj) {
    System.out.println(Arrays.toString(obj));
  }

  public final void final_m() {
    System.out.println("final method");
  }

  public String what_this(){

    return getName();
  }


}


class Sub extends Parent {

  public String name;
  private int age;
//  static String field = "static field sub";

  public Sub(String name, String sub_name, int age) {
    super(name);
    this.name = sub_name;
    this.age = age;

  }

  @Override
  public void callPrivateFuc() {
    this.privateFuc();
//    super.callPrivateFuc();
  }

  private void privateFuc() {
    System.out.println(this.name);
  }

  public static void getNameStatic() {
    System.out.println("sub static");
  }

  public String getName() {
    System.out.println("sub func");
    return name;
  }

  public void isSame() {
    System.out.println(super.test_field == this.test_field);
    System.out.println(this.getClass().getSuperclass());
    print(super.getClass().getFields());
    try {

      System.out.println("-------");
      System.out.println(this.getClass().getSuperclass().getMethod("getNameStatic"));
      System.out.println(this.getClass().getMethod("getNameStatic"));
    } catch (NoSuchMethodException e) {

    }
  }



}
