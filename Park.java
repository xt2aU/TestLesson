public class Park {
    // Внутренний класс для хранения информации об аттракционах
    public static class Attraction {
        private String name;
        private String workingHours;
        private double price;

        // Конструктор класса Attraction
        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
    }
}
