package characters;

public class JimboTheFatty extends Player{
	
	public JimboTheFatty(String url, int x, int y){
		super(url,x,y);
		setDefaultStats();
	}

	public void setDefaultStats(){
		stats.put("maxHp",100000);
		stats.put("hp",10000);
		stats.put("intellgence",1);
		stats.put("strength", 50);
		stats.put("dexterity", -100);
		stats.put("speedCap",3);
		stats.put("speed",1);
		stats.put("speedMin",1);
		stats.put("mana",75);
		stats.put("manaMax",75);
	}

	public void updateStats(){
		stats.put("hp",stats.get("hp")-1);
		
	}
}