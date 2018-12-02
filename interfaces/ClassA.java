package interfaces;

public class ClassA implements TransValue{
	private String data;
	public ClassA() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getValue(String data) {
		// TODO Auto-generated method stub
		System.out.println("这是ClassA对接口的的实现");
		System.out.println("这是A类得到的数据" + data);
	}

}
