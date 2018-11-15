package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.sound.midi.Synthesizer;

public class Main {

	public static void main(String[] args) {
		
		Main m = new Main();
	//	m.esempioDate();
	//	m.esempioCalendar();
	//	m.esempioLocalDate();
		m.esempioSimpleDateFormat();
	}
	
	private void esempioDate() {
		Date d = new Date();
		
		System.out.println(d.getTime());
		
		
	}
	
	private void esempioCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1992);
		cal.set(Calendar.MONTH, Calendar.JULY);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		Calendar cal2 = new GregorianCalendar();
		
		System.out.println(cal.getTime());
		System.out.println(cal2.getTime());
	}
	
	private void esempioLocalDate() {
		LocalDate ld = LocalDate.of(2016, 10, 12);
		System.out.println(ld);
		System.out.println("Bisestile? : " + ld.isLeapYear());
		
		
	}
	
	private void esempioDuration() {
		LocalDate ld1 = LocalDate.of(2018, 8, 1);
		LocalDate ld2 = LocalDate.of(2018, 9, 30);
		
		Duration d1 = Duration.ofSeconds(10,40);
		Duration d2 = Duration.between(ld2, ld1);
	}
	
	private void esempioSimpleDateFormat() {
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar d = new GregorianCalendar();
		System.out.println(simple.format(d.getTime()));
		
		String stringaData = "01/05/2019";
		try {
			Date d1 = simple.parse(stringaData);
			System.out.println(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}
