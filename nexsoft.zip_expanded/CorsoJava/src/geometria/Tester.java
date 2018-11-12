package geometria;

public class Tester {
	public static void main(String[] args) {
		Quadrato q = new Quadrato(5);
		System.out.println(q.calcolaArea());
		System.out.println(q.calcolaPerimetro());

		Triangolo t = new Triangolo(1, 2, 3);
		System.out.println(t.calcolaPerimetro());

		Triangolo t1 = new Triangolo(4);
		System.out.println(t1.calcolaArea());
		System.out.println(t1.calcolaPerimetro());

		Triangolo t2 = new Triangolo(3, 4);
		System.out.println(t2.calcolaArea());
		System.out.println(t2.calcolaPerimetro());
		
		Rettangolo r = new Rettangolo(10, 7);
		System.out.println(r.calcolaArea());
		System.out.println(r.calcolaPerimetro());
		
		
	}
}
