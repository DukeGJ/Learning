package interfaces;

public class ClassB implements TransValue{
	private String data;
	public ClassB() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getValue(String data) {
		// TODO Auto-generated method stub
		System.out.println("����B��Խӿڵ�ʵ��");
		System.out.println("����B��õ�������" + data);
	}
}
