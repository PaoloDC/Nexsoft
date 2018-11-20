package esempioGianlucaLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Album> raccolta = new ArrayList<>();
		ArrayList<String> songs1 = new ArrayList<>();
		songs1.add("canzone 1");
		songs1.add("canzone 2");
		songs1.add("canzone 3");

		raccolta.add(new Album(songs1, 2000));

		ArrayList<String> songs2 = new ArrayList<>();
		songs2.add("1 canzone 1");
		songs2.add("2 canzone 2");
		songs2.add("3 canzone 3");

		raccolta.add(new Album(songs2, 2003));

		ArrayList<String> songs3 = new ArrayList<>();
		songs3.add("aaaa canzone 1");
		songs3.add("ffff canzone 2");
		songs3.add("2222 canzone 3");

		raccolta.add(new Album(songs3, 1999));

		//System.out.println(raccolta);

		// String[] array = raccolta.stream().map(a ->
		// a.getSongs().toString()).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]",
		// "").split(",");
		// Arrays.asList(array).sort(Comparator.naturalOrder());
		// System.out.println(array);
//
//		raccolta.stream().map(a -> a.getSongs()).flatMap(b -> b.stream()).sorted().collect(Collectors.toList())
//				.forEach(s -> System.out.println(s));
		

		raccolta.stream().flatMap(a -> a.getSongs().stream()).sorted().forEach(System.out::println);
	}
}
