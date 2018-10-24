package StatePattern;

interface UnitState {
	public void Attack();

	public void Move();
}

class NormalState implements UnitState {

	@Override
	public void Attack() {
		System.out.println("���� ����");
	}

	@Override
	public void Move() {
		System.out.println("�̵� ���� 10��ŭ");
	}
}

class LockDown implements UnitState {

	@Override
	public void Attack() {
		System.out.println("���� �Ұ�");
	}

	@Override
	public void Move() {
		System.out.println("�̵� �Ұ�");
	}
}

class Blind implements UnitState {

	@Override
	public void Attack() {
		System.out.println("���� ����");
	}

	@Override
	public void Move() {
		System.out.println("�̵� ���� 2��ŭ");
	}
}

class SiegeTank {
	private UnitState state;

	public SiegeTank(UnitState state) {
		this.state = state;
	}

	public void Attacked(String s) {
		switch (s) {
		case "Medic Blind":
			System.out.println("�޵񿡰� ����ε� ���� �̻� ������ ����");
			this.state = new Blind();
			break;
		case "Ghost LockDown":
			System.out.println("��Ʈ���� ���ٿ� ���� �̻� ������ ����");
			this.state = new LockDown();
			break;
		default:
			break;
		}
	}
	
	public void Attack() {
		state.Attack();
	}
	
	public void Move() {
		state.Move();
	}
}

public class main {

	public static void main(String[] args) {
		SiegeTank tank = new SiegeTank(new NormalState());
		tank.Attack();
		tank.Move();

		tank.Attacked("Medic Blind");
		tank.Attack();
		tank.Move();
		
		tank.Attacked("Ghost LockDown");
		tank.Attack();
		tank.Move();
	}

}
