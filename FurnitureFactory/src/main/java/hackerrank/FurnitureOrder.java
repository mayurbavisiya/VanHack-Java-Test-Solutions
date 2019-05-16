package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

	HashMap<Furniture, Integer> furnitureMap = new HashMap<Furniture, Integer>();

	FurnitureOrder() {
	}

	public void addToOrder(final Furniture type, final int furnitureCount) {
		if (furnitureCount > 0) {
			furnitureMap.put(type, furnitureCount);
		}
	}

	public HashMap<Furniture, Integer> getOrderedFurniture() {
		return furnitureMap;
	}

	public float getTotalOrderCost() {
		float cost = 0.0f;
		for (Map.Entry<Furniture, Integer> entry : furnitureMap.entrySet()) {
			cost += (entry.getKey().cost() * entry.getValue());
		}
		return cost;
	}

	public int getTypeCount(Furniture type) {
		int count = 0;
		for (Map.Entry<Furniture, Integer> entry : furnitureMap.entrySet()) {
			if (entry.getKey().label().equalsIgnoreCase(type.label())) {
				return entry.getValue();
			}
		}
		return count;
	}

	public float getTypeCost(Furniture type) {
		float cost = 0.0f;
		for (Map.Entry<Furniture, Integer> entry : furnitureMap.entrySet()) {
			if (entry.getKey().label().equalsIgnoreCase(type.label())) {
				cost += (entry.getKey().cost() * entry.getValue());
			}
		}
		return cost;
	}

	public int getTotalOrderQuantity() {
		return furnitureMap.values().stream().mapToInt(Integer::intValue).sum();
	}
}