import org.springframework.security.crypto.password.PasswordEncoder;

//run this class as a Java application
public class EncodePassword {
	private static PasswordEncoder passEncode;
	
	public static void main(String args[]) {
		System.out.println(passEncode.encode("Ravi"));
	}

}
