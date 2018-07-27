package trainingDemo;

import org.testng.annotations.Test;

public class Demo1 {
  @Test(priority=1)
  public void f() {
	  System.out.println("Welcome in f()");
  }
  @Test(priority=3)
  public void abc() {
	  System.out.println("Welcome in abc()");
  }
  @Test(priority=2)
  public void xyz() {
	  System.out.println("Welcome in xyz()");
  }
}
