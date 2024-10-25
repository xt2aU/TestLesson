//Создаём класс Животное
class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++; //Счетчик животных
    }
//Метод для бега
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
//Метод для плавания
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
//Создаём класс Собака
class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++; //Счетчик собак
    }
//Переопределяем метод для бега собаки
    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
//Переопределяем метод для плавания собаки
    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
//Создаём класс Кот
class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        catCount++; //Счетчик котов
        this.isFull = false;
    }
//Переопределяем метод для бега кота
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
//Переопределяем метод для плавания кота
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
//Создаём метод мисок с едой
    public void eat(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println(name + " не может поесть, недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}
//Создаём класс Миска
class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        }
    }
//Метод для добавления еды в миску
    public void addFood(int amount) {
        foodAmount += amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");

        dog1.run(150);
        dog1.swim(5);

        cat1.run(100);
        cat1.swim(1);

        System.out.println("Создано животных: " + Animal.getAnimalCount());
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());
        //Создаём массив котов с едой
        Bowl bowl = new Bowl(50);
        Cat[] cats = {cat1, cat2};
        //Просим котов поесть
        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        bowl.addFood(30);
        System.out.println("Еды в миске: " + bowl.getFoodAmount());
    }
}