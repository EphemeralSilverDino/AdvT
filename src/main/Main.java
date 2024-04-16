// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
package main;

import debug.DebugWriter;

public class Main {
  public static DebugWriter dWriter = new DebugWriter();
  
  public static void main(String[] args) throws InterruptedException{
    MainFrame.startGUI();
    System.out.println("Yessir I love Peaches - Derek");
    dWriter.write("Your mama");
    dWriter.write("makes the best pasta");
		dWriter.write("I love peaches");
  }
}