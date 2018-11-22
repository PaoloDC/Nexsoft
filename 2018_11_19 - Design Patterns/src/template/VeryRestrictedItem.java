package template;

public class VeryRestrictedItem extends ItemStock {
	String code;
	String name;
	int currentQuantity;
	int maxLotSize;

	public VeryRestrictedItem(String cod, String nam, int mlSize) {
		code = cod;
		name = nam;
		maxLotSize = mlSize;
	}

	public void setStock(int quantity) {
		currentQuantity = quantity;
	}

	public String toString() {
		return code + " " + name + " " + currentQuantity + " (Max. Lot Size: " + maxLotSize + ")";
	}

	public int getCurrentStock() {
		return currentQuantity;
	}

	public void decreaseStock(int quantity) {
		currentQuantity -= quantity;
	}

	public boolean validateQuantity(int quantity) {
		if (quantity >= 0 && quantity <= Math.min(currentQuantity, maxLotSize))
			return true;
		return false;
	}
}