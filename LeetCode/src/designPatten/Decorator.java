package designPatten;
/**
 * װ����ģʽ
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2017��11��22������8:04:29
 */
public class Decorator implements Sourceable{

	private Sourceable sourceable;
	public Decorator(Sourceable sourceable) {
		this.sourceable = sourceable;
	}
	
	@Override
	public void oprate() {
		System.out.println("װ�η���");
		sourceable.oprate();
		System.out.println("װ�η���");
	}
	
	public static void main(String[] args) {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.oprate();
	}

}
