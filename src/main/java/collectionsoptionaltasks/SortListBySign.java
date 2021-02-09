package collectionsoptionaltasks;

import java.util.ArrayList;

public class SortListBySign {
    public static void main(String[] args) {
        int currentNumber;
        int negativeArgumentsCounter = 0;
        ArrayList<Integer> argumentList = new ArrayList<>();
        argumentList.add(-21);
        argumentList.add(7);
        argumentList.add(17);
        argumentList.add(-3);
        argumentList.add(8);
        argumentList.add(-12);
        argumentList.add(-66);
        argumentList.add(19);
        argumentList.add(-1);
        argumentList.add(7);

        System.out.println("Arguments without sorting: " + argumentList);
        for (int i = 0; i < argumentList.size(); i++) {
            if (argumentList.get(i) < 0) {
                currentNumber = argumentList.get(i);
                argumentList.remove(i);
                argumentList.add(negativeArgumentsCounter, currentNumber);
                negativeArgumentsCounter++;
            }
        }
        System.out.println("Arguments sorted by sign: " + argumentList);
    }
}
