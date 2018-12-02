package interfaces;

public class ClassB implements TransValue{
	private String data;
	public ClassB() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getValue(String data) {
		// TODO Auto-generated method stub
		System.out.println("这是B类对接口的实现");
		System.out.println("这是B类得到的数据" + data);
	}
}
