package template;

public class GeneralItem extends ItemStock {
	String code;
	String name;
	int onHand;
	int inTransit;
	int backorders;

	public GeneralItem(String cod, String nam) {
		code = cod;
		name = nam;
	}

	public void setStock(int oh, int it, int bo) {
		onHand = oh;
		inTransit = it;
		backorders = bo;
	}

	public String toString() {
		return code + " " + name + ". Inv. On Hand: " + onHand + " In Transit: " + inTransit + " Backorders: "
				+ backorders;
	}

	public boolean validateQuantity(int quantity) {
		return (quantity >= 0);
	}

	public int getCurrentStock() {
		return onHand + inTransit - backorders;
	}

	public void decreaseStock(int quantity) {
		onHand -= quantity;
		if (onHand < 0) {
			backorders += Math.abs(onHand);
			onHand = 0;
		}
	}
}
