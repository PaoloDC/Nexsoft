package template;

public class TemplateExample {

	public static void main(String[] args) {
		System.out.println("A very restricted item example");
		VeryRestrictedItem vri = new VeryRestrictedItem("VRI1", "Golden stone", 5);
		vri.setStock(20);
		System.out.println("Current stock " + vri.toString());
		System.out.println("I will try to take 6 units:");
		if (vri.remove(6))
			System.out.println("Items removed.");
		else
			System.out.println("Items cannot be removed.");
		System.out.println(vri.toString());
		System.out.println("I will try to take 3 units:");
		if (vri.remove(3))
			System.out.println("Items removed.");
		else
			System.out.println("Items cannot be removed.");
		System.out.println(vri.toString());
		System.out.println("A general item example");
		GeneralItem gi = new GeneralItem("GEN1", "Common stone");
		gi.setStock(20, 10, 0);
		System.out.println("Current stock " + gi.toString());
		System.out.println("I will try to take 6 units:");
		if (gi.remove(6))
			System.out.println("Items removed.");
		else
			System.out.println("Items cannot be removed.");
		System.out.println(gi.toString());
		System.out.println("I will try to take 25 units:");
		if (gi.remove(25))
			System.out.println("Items removed.");
		else
			System.out.println("Items cannot be removed.");
		System.out.println(gi.toString());

	}

}
