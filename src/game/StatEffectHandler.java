package game;
import java.util.*;
public class StatEffectHandler {
  static HashMap<String,Animations> effects = new HashMap<String,Animations>() {};
  public static void handleEffect(StatEffect effect, characters.Character character){
    if (effect.getName().equals("posion")){
      character.setStat("health",character.getStat("health")-10);
    }
    
  }
}