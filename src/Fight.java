import java.util.Random;
import java.util.Scanner;
import bestiary.Monster;
import bestiary.Vyachaslav;
import humanPackage.Human;

public class Fight {
	Random rnd = new Random();
	Scanner scn = new Scanner(System.in);
	Human human = new Human();
	public void fight() throws InterruptedException { 
		Monster[] monster = new Monster[2]; // Наш Бестиарий
		monster[0] = new Vyachaslav();
		monster[1] = new Monster();
		int number = rnd.nextInt(monster.length);
		// =========================================================================================================================================================================================

		System.out.println("Здрасьте, если вы увидели это сообщение, то значит что на вас напал монстр! "
					+ monster[number].getName() + " Его жизни=" + monster[number].getHP() + " Атака= "
					+ monster[number].getDamage());
		System.out.println("Вы можете попытаться избежать этого боя, вероятность убежать 20%");
		
		//====================================================== Ниже 
		int escape = scn.nextInt();
		if (escape == 1) {
			if (Chance(20)) {
				System.out.println("Вы съебались");
				return;
			} else {
				System.out.println("Упс, не удалось, продолжаем бой");
			}
		}
		//======================================================
		do{
		turnHumanFight(monster[number]); 	//Метод атаки хумана
		if (checkWin(monster[number].getHP())){
			System.out.println("Выйграл человек");
		}
		turnAI(monster[number]);	//Метод атаки AI
		if (checkWin(human.getHP())){
		System.out.println("Вы мертвы! Игра окончена");
		}
		}while(true);
		//======================================================
	scn.close();
	}
	
public void turnHumanFight(Monster monsterFight) throws InterruptedException { //Метод атаки человека с фаллаут системой
		int attack;
		do{
			System.out.println("На выбор вы можете атаковать одну из частей его тела 1=Body(10) 2=HeaD(60) 3=Hand(30) 4=Leg(20)(В скобках шанс промаха)");
			attack=scn.nextInt();
			if(attack==1){
				if(Chance(90)){
					System.out.println("Вы наносите противнику="+human.Attack+" урона");
					monsterFight.setHP(monsterFight.getHP()-human.Attack);
					System.out.println("У противника осталось= "+monsterFight.getHP()+" Жизней");
				}
				else{
					System.out.println("Вы промахнулись");
					return;
				}
			}
			if(attack==2){
				if(Chance(40)){
					System.out.println("Вы попадаете противнику по голове!! Критический удар! Нанасено="+(human.Attack+human.Attack*2)+" урона");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+human.Attack*2));
					System.out.println("У противника осталось= "+monsterFight.getHP()+" Жизней");
				}
				else{
					System.out.println("Вы промахнулись");
					return;
				}		
					}
			if(attack==3){
				if(Chance(70)){
					System.out.println("Вы наносите противнику="+human.Attack+" урона");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+10));
					System.out.println("У противника осталось= "+monsterFight.getHP()+" Жизней");
				}
				else{
					System.out.println("Вы промахнулись");
					return;
				}
			}
			if(attack==4){
				if(Chance(80)){
					System.out.println("Вы наносите противнику="+human.Attack+" урона");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+5));
					System.out.println("У противника осталось= "+monsterFight.getHP()+" Жизней");
				}
				else{
					System.out.println("Вы промахнулись");
					return;
				}
			}
		}while(attack!=1 && attack!=2 && attack!=3 && attack!=4);
	}
	
//	public void turnAI(Monster monsterFight){ //Примитив Атака Монстра
		System.out.println("Монстр атакует вас");
		human.setHP(human.getHP()-monsterFight.getDamage());
//		System.out.println("У вас осталось "+human.getHP()+" жизней");
//	}
//	boolean checkWin(int HP){ //Проверка жизни и победы
//		if(HP<=0){
//			return true;
//			}
//		return false;
//	}
	boolean Chance(int a) { // Расчитываем вероятность побега, попадания, крита.
		int chance = rnd.nextInt(100);
		if (chance > 100 - (a)) {
			return true;
		} else
			return false;
	}	
}