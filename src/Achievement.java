public class Achievement {
    private int value; //points per achievement
    private String name; //name of achievement
    private int quantity; //how many times a student has earned this achievement
    private int index; //the index of this achievement (given by file)

    public Achievement(String aName, int aValue, int aQuantity, int aIndex){
        value = aValue;
        name = aName;
        quantity = aQuantity;
        index = aIndex;
    }

    public int getValue() {
        return value;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Value: " + value;
    }
}
