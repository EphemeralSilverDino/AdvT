package game;
public class StatEffect{
  String effect;
  int stacks = 0;
  
  public StatEffect(String effect){
    this.effect = effect;
  }
  
  public String getName(){
  return effect;
  }
  
  public void setStacks(int stacks){
    this.stacks = stacks;
  }
  public void upStacks(){
    stacks++;
  }
}