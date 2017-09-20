package bestiary;

public class Monster {


	private int HP;
	private int Damage;
	private String Name;
	private int Alcohol; //Особая способность НПС Вячеслав.
	private Vyachaslav va;
	public Monster (){
	
	}
	public int getHP (){
		return HP;
	}
	public void setHP(int HP) {
		this.HP = HP;
	}
	public int getDamage (){
		return Damage;
	}
	public void setDamage(int damage) {
		this.Damage = damage;
	}
	public String getName() {
		return Name;
	}
	public int getAlcohol() {
		return Alcohol;
	}
}