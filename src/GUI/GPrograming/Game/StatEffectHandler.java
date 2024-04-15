import java.util.*;
public class StatEffectHandler {
  static HashMap<String,Animations> effects = new HashMap<>() {};
  public static void handleEffect(StatEffect effect, Character c){
    if (effect.getName().equals("posion")){
      c.setStat("health",c.getStat("health")-10);
    }
    
  }
}