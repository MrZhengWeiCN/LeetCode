package designPatten;
/**
 * 装饰器模式
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年11月22日下午8:04:29
 */
public class Decorator implements Sourceable{

	private Sourceable sourceable;
	public Decorator(Sourceable sourceable) {
		this.sourceable = sourceable;
	}
	
	@Override
	public void oprate() {
		System.out.println("装饰方法");
		sourceable.oprate();
		System.out.println("装饰方法");
	}
	
	public static void main(String[] args) {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.oprate();
	}

}
