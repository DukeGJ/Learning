package interfaces;

public class ClassA implements TransValue{
	private String data;
	public ClassA() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getValue(String data) {
		// TODO Auto-generated method stub
		System.out.println("����ClassA�Խӿڵĵ�ʵ��");
		System.out.println("����A��õ�������" + data);
	}

}
