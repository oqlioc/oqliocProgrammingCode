package TemplateMethodPattern;

abstract class ���л�
{
	public void ����() {
		���();
		�ı�();
		Ÿ��();
		if (!����()) {
			�б����();
		}else {
			�ǽù�();
		}
	}

	protected void ���() {
		System.out.println("���....");		
	}
	protected void �б����() {
		System.out.println("�б��� �ö󰣴�.");
	}
	private void �ǽù�() {
		System.out.println("���������ϱ� ������");
	}
	
	abstract protected boolean ����();
	abstract protected void �ı�();
	abstract protected void Ÿ��();
}

class �Ǽ� extends ���л�{
	
	boolean ����;
	public �Ǽ�(boolean ����) {
		this.���� = ����;
	}
	@Override
	protected boolean ����() {
		return ����;
	}

	@Override
	protected void �ı�() {
		System.out.println("���!!!!");
	}
	@Override
	protected void Ÿ��() {
		System.out.println("�ڰ��� ����� ź��");
	}
}

class ���� extends ���л�{

	boolean ����;
	public ����(boolean ����) {
		this.���� = ����;
	}
	@Override
	protected boolean ����() {
		return ����;
	}
	
	@Override
	protected void �ı�() {
		System.out.println("������ �Ѵ�");
	}
	@Override
	protected void Ÿ��() {
		System.out.println("�پ�´�");
	}
	
}

public class main {

	public static void main(String[] args) {

		���л� A = new �Ǽ�(true);
		A.����();
		
		A = new ����(false);
		A.����();
		
	}

}
