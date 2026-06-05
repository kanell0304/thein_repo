package src.com.gjl.anonymousClass;

public class MyMain6 {
	public static void main(String[] args) {
		Greeting greet = new Greeting() {

			@Override
			public void sayHello() {
				System.out.println("안녕하세요.");
			}

		};

		greet.sayHello();

	}
}
