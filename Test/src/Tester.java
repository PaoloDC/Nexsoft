
public class Tester {

	public static void main(String[] args) {
		Utente u = new Utente();
		u.setNome("Paolo");
		u.setCognome("DC");
		
		for(int i=0 ; i < 10 ; i++) {
			u.getListaConti().add(new ContoCorrente());
		}
		
		u.getListaConti().forEach(System.out::println);

	}

}
