package Domen;


public class HotDrink extends Product {
    // Поля
    private int Temperature;

    // Конструкторы
    public HotDrink(int price, int place, String name, long id, int temperature) {
        super(price, place, name, id);
        this.Temperature = temperature;
    }

    public HotDrink(int price, int place, String name, long id) {
        super(price, place, name, id);
        this.Temperature = 60;
    }

    // Свойства
    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        this.Temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + "Temperature = " + Temperature;
    }

}

