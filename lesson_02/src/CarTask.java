

/*
Имеется список парка машин Car(String model, String type).
Необходимо разбить его на списки сгруппированные по type.
Пример исходного списка:
Лада седан, Лада хэтчбек, Мерседес седан, Бмв кроссовер,  Форд хэтчбек, Пежо кроссовер, Тойота седан и т.п.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CarTask {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Лада", "седан"));
        cars.add(new Car("Лада", "хэтчбек"));
        cars.add(new Car("Мерседес", "седан"));
        cars.add(new Car("Бмв", "кроссовер"));
        cars.add(new Car("Форд", "хэтчбек"));
        cars.add(new Car("Пежо", "кроссовер"));
        cars.add(new Car("Тойота", "седан"));

        for(Car car : cars)
            System.out.println(car);
        System.out.println();

        HashMap<String, ArrayList<Car>> groupsByType = new HashMap<>();

        for(Car car : cars){
            if (!groupsByType.containsKey(car.type)) {
                groupsByType.put(car.type, new ArrayList<>());
            }
            groupsByType.get(car.type).add(car);
        }

        System.out.println(groupsByType);
    }
}


class Car {
    String model;
    String type;

    Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    @Override
    public String toString() {
        return model + " " + type;
    }
}
