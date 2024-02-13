package Domen;


public class HotDrink extends Product {
    // Поля
    private int temperature;

    // Конструкторы
    public HotDrink(int price, int place, String name, long id, int temperature) {
        super(price, place, name, id);
        this.temperature = temperature;
    }

    public HotDrink(int price, int place, String name, long id) {
        super(price, place, name, id);
        this.temperature = 60;
    }

    // Свойства
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + "Temperature = " + temperature;
    }

}

