package _1_1_Homework;

public class ItemStorage<T> {
    private T value;

    public ItemStorage(T value) {
        setValue(value);
    }

    public void compareWith(T otherValue) {
        // долго пытался понять тз. Не понимал, почему в Б compareWith по ==, а в В по equals.
        // потом обратил внимание на фразу "Оба сравнения", понял, что, вероятно, имеется ввиду, что нужно вызывать оба.
        // хотя почему то этого нигде не сказано.
        if (value == null || otherValue == null) {
            System.out.println("Опачки! Ревизия невозможна, объект не найден");
        }
        else
        {        System.out.println(value.equals(otherValue));
            if (value == otherValue) { // сравнивает по объекту, а не по значению. это понятно из теста b
            System.out.println("Значения идентичны. Контроль качества пройден");
        }}
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
