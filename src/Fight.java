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
		Monster[] monster = new Monster[2]; // ��� ���������
		monster[0] = new Vyachaslav();
		monster[1] = new Monster();
		int number = rnd.nextInt(monster.length);
		// =========================================================================================================================================================================================

		System.out.println("��������, ���� �� ������� ��� ���������, �� ������ ��� �� ��� ����� ������! "
					+ monster[number].getName() + " ��� �����=" + monster[number].getHP() + " �����= "
					+ monster[number].getDamage());
		System.out.println("�� ������ ���������� �������� ����� ���, ����������� ������� 20%");
		
		//====================================================== ���� 
		int escape = scn.nextInt();
		if (escape == 1) {
			if (Chance(20)) {
				System.out.println("�� ���������");
				return;
			} else {
				System.out.println("���, �� �������, ���������� ���");
			}
		}
		//======================================================
		do{
		turnHumanFight(monster[number]); 	//����� ����� ������
		if (checkWin(monster[number].getHP())){
			System.out.println("������� �������");
		}
		turnAI(monster[number]);	//����� ����� AI
		if (checkWin(human.getHP())){
		System.out.println("�� ������! ���� ��������");
		}
		}while(true);
		//======================================================
	scn.close();
	}
	
public void turnHumanFight(Monster monsterFight) throws InterruptedException { //����� ����� �������� � ������� ��������
		int attack;
		do{
			System.out.println("�� ����� �� ������ ��������� ���� �� ������ ��� ���� 1=Body(10) 2=HeaD(60) 3=Hand(30) 4=Leg(20)(� ������� ���� �������)");
			attack=scn.nextInt();
			if(attack==1){
				if(Chance(90)){
					System.out.println("�� �������� ����������="+human.Attack+" �����");
					monsterFight.setHP(monsterFight.getHP()-human.Attack);
					System.out.println("� ���������� ��������= "+monsterFight.getHP()+" ������");
				}
				else{
					System.out.println("�� ������������");
					return;
				}
			}
			if(attack==2){
				if(Chance(40)){
					System.out.println("�� ��������� ���������� �� ������!! ����������� ����! ��������="+(human.Attack+human.Attack*2)+" �����");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+human.Attack*2));
					System.out.println("� ���������� ��������= "+monsterFight.getHP()+" ������");
				}
				else{
					System.out.println("�� ������������");
					return;
				}		
					}
			if(attack==3){
				if(Chance(70)){
					System.out.println("�� �������� ����������="+human.Attack+" �����");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+10));
					System.out.println("� ���������� ��������= "+monsterFight.getHP()+" ������");
				}
				else{
					System.out.println("�� ������������");
					return;
				}
			}
			if(attack==4){
				if(Chance(80)){
					System.out.println("�� �������� ����������="+human.Attack+" �����");
					monsterFight.setHP(monsterFight.getHP()-(human.Attack+5));
					System.out.println("� ���������� ��������= "+monsterFight.getHP()+" ������");
				}
				else{
					System.out.println("�� ������������");
					return;
				}
			}
		}while(attack!=1 && attack!=2 && attack!=3 && attack!=4);
	}
	
//	public void turnAI(Monster monsterFight){ //�������� ����� �������
		System.out.println("������ ������� ���");
		human.setHP(human.getHP()-monsterFight.getDamage());
//		System.out.println("� ��� �������� "+human.getHP()+" ������");
//	}
//	boolean checkWin(int HP){ //�������� ����� � ������
//		if(HP<=0){
//			return true;
//			}
//		return false;
//	}
	boolean Chance(int a) { // ����������� ����������� ������, ���������, �����.
		int chance = rnd.nextInt(100);
		if (chance > 100 - (a)) {
			return true;
		} else
			return false;
	}	
}