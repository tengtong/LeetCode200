package others;

public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);

        Dog d = new Dog();
        animalCry(d);

        Cat t = new Cat();
        animalCry(t);
    }
    //多态的关键，通过父类的引用调用子类重写的方法。
    static void animalCry(Animal a) {
        a.shout();
    }
}

class Animal{
    public void shout() {
        System.out.println("叫了一声");
    }
}
class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("汪汪汪！");
    }
}
class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("喵喵喵！");
    }
}