package adapter;

public class ObjectAdapterExample {

	public static void main(String[] args) {
		Polygon block = new RectangleObjectAdapter();
		block.setId("OBJ esempio");
		block.define(3, 4, 10, 20, "VERDE");
		System.out.println(
				"The area of " + block.getId() + " is " + block.getSurface() + ", and it’s " + block.getColor());

	}

}
