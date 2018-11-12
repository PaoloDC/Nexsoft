package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class PredicateEsempioUtenti {

	public static void main(String[] args) {
		PredicateEsempioUtenti ex = new PredicateEsempioUtenti();

		List<Utente> lista = new ArrayList<>();
		lista = ex.getListaUtenti();

		List<Utente> trovati = ex.cercaUtente(lista, utente -> utente.getEta() < 10);
		System.out.println(trovati);

		Consumer<Utente> cu = utente -> System.out.println("Ciao " + utente.getNome());
		lista.forEach(cu);

		UnaryOperator<String> s = stringa -> stringa.toLowerCase();
		System.out.println(s.apply("PROVA MAIUSC"));

		UnaryOperator<Long> l = val -> val * val;
		System.out.println(l.apply(10l));

		BinaryOperator<Long> ll = (a, b) -> a + b;
		System.out.println(ll.apply(10l, 5l));

		List<Utente> listaTrovati = ex.cercaUtente(ex.getListaUtenti(), utente -> utente.getCognome().equals("DC"));
		System.out.println(listaTrovati);
	
	}
	
	public Utente cercaUtenti(List<Utente> elenco, Predicate<Utente> filtro){
		for(Utente u: elenco) {
			if(filtro.test(u)) {
				return u;
			}
		}
		return null;
	}

	private void stampaDatiUtente(Supplier<Utente> su) {
		System.out.println(su.get().getNome());
	}

	private List<Utente> getListaUtenti() {
		ArrayList<Utente> lista = new ArrayList<>();

		lista.add(new Utente("Paolo", "DC", 26));
		lista.add(new Utente("Luigi", "DC", 7));
		lista.add(new Utente("Francesca", "DC", 8));
		lista.add(new Utente("Carmine", "Palo", 25));
		lista.add(new Utente("Max", "Moli", 27));
		lista.add(new Utente("Alfredo", "Giuliano", 26));

		return lista;
	}

	public List<Utente> cercaUtente(List<Utente> listaUtenti, Predicate<Utente> p) {
		List<Utente> trovati = new ArrayList<>();

		for (Utente u : listaUtenti) {
			if (p.test(u))
				trovati.add(u);
		}

		return trovati;
	}
}
