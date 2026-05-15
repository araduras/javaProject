
import java.util.List;

class Knapsack {
    Item backpack = new Item(0, 0);
    int maximumValue(int maximumWeight, List<Item> items) {
        while (backpack.weight<maximumWeight) {
            if(backpack.weight+items.get(bestValueFinder(items)).weight<maximumWeight){
                backpack.value += items.get(bestValueFinder(items)).value;
                backpack.weight += items.get(bestValueFinder(items)).weight;
                items.remove(bestValueFinder(items));
            }
            else break;


        }
        return backpack.value;
       


    }
    int bestValueFinder (List<Item> items){
        int itemsIndex = 0;
        double bestValueItem = 0;
        for (int i = 0; i < items.size(); i++) {
            double currentItem = items.get(i).value / items.get(i).weight;  
            if (bestValueItem<currentItem) {
                itemsIndex = i;
            }
        }
        return itemsIndex;

    }

}