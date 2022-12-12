public class SmartKitchen {
    private CoffeeMaker coffeeMaker;
    private DishWasher dishWasher;
    private Refrigerator refrigerator;

    public SmartKitchen() {
        coffeeMaker = new CoffeeMaker();
        dishWasher = new DishWasher();
        refrigerator = new Refrigerator();
    }

    public CoffeeMaker getBrewMaster() {
        return coffeeMaker;
    }

    public Refrigerator getIceBox() {
        return refrigerator;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public void setKitchenState(boolean coffeeFlag, boolean fridgeFlag,
            boolean dishWasherFlag) {

        coffeeMaker.setStatus(coffeeFlag);
        refrigerator.setStatus(fridgeFlag);
        dishWasher.setStatus(dishWasherFlag);
    }

    public void doKitchenWork() {
        coffeeMaker.brewCofee();
        refrigerator.orderFood();
        dishWasher.doDishes();
    }
}

class Refrigerator {
    private boolean hasWorkToDo;

    public void setStatus(boolean state) {
        hasWorkToDo = state;
    }

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Ordering food.");
            hasWorkToDo = false;
        }
    }
}

class CoffeeMaker {
    private boolean hasWorkToDo;

    public void setStatus(boolean state) {
        hasWorkToDo = state;
    }

    public void brewCofee() {
        if (hasWorkToDo) {
            System.out.println("Brewing coffee.");
            hasWorkToDo = false;
        }
    }
}

class DishWasher {
    private boolean hasWorkToDo;

    public void setStatus(boolean state) {
        hasWorkToDo = state;
    }

    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("Washing dishes.");
            hasWorkToDo = false;
        }
    }
}
