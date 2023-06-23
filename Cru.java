package lesson3.HW210623;

// 1 уровень сложности: Создайте перечисление Cru со значениями
//AUTRE
//PREMIER
//GRAND
//
//Добавьте поле private int quality,
//добавьте конструктор,
//проинициализируйте значения
//AUTRE(80),
//PREMIER(90),
//GRAND(100)
//и добавьте геттер.

public enum Cru {
    AUTRE(80),
    PREMIER(90),
    GRAND(100);

    private int quality;

    Cru(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public static void main(String[] args) {
        Cru cru  = Cru.AUTRE;
        System.out.println(cru.getQuality());
    }
}
