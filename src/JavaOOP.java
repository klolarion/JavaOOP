public class JavaOOP {
    public static void main(String[] args) {
//        Person person1 = new Person();
//        Person person2 = new Person("lee", 30);
//        person1.setAge(25);
//        person1.setName("kim");
//
//        System.out.println(person1.getName());
//        System.out.println(person2.getName());
//
//        System.out.println(Person.from);
//
//        Cat cat1 = new Cat();
//        Dog dog1 = new Dog();
//
//        cat1.sound();
//        dog1.sound();
//
//
//        Fish fish1 = new Fish();
//        System.out.println(fish1.place);
//        fish1.species();
//
//        Shark shark1 = new Shark();
//        System.out.println(shark1.place);
//        shark1.species();
//        shark1.name();
//
//        Shark shark2 = new Shark("아기상어");
//
//        System.out.println(shark2.name);
//
//        SUV suv1 = new SUV();
//        suv1.wheel();
//        suv1.sound();


//        Animal2 a2 = new Cow();
//        Animal2 a3 = new Horse();
//        Cow cow = new Cow();
//
//        a2.eat();
//        a2.walk();
//
//        System.out.println("-----------");
//
//        a3.eat();
//        a3.walk();
//
//        System.out.println("-----------");
//
//
//        //부모인스턴스일때 부모필드출력
//        System.out.println(a2.place);
//        //자식인스턴스일때 자식필드출력
//        System.out.println(cow.place);

        Box<String> box1 = new Box<>();
        box1.setItem("String");
        Box<Integer> box2 = new Box<>();


        Animal2 animal1 = new Animal2();
        Cow cow1 = new Cow();
        System.out.println(cow1.place);
        cow1.eat("건초");
        //부모타입으로 업캐스팅. 문제없음.
        Animal2 animal2 = cow1;
        System.out.println(animal2.place);
        animal2.eat();
        //자식타입으로 다운캐스팅. 문제발생.
        Cow cow2 = (Cow) animal1;
        System.out.println(cow2.place);
    }
}

//클래스
class Person{
    //속성, 멤버변수, 필드
    static String from = "Korea"; //모든 인스턴스가 공유
    private String name;
    private int age;

    //기본생성자, 다른 생성자가 없을시 생략가능
    public Person(){}

    //생성자, 인스턴스 생성시 필드값 초기화
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //메서드(생성자) 오버로딩, 변타입, 수에따라 다르게 호출
    public Person(String name){
        this.name = name;
    }
    public Person(int age){
        this.age = age;
    }

    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    //getter
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}

//인터페이스
interface Animal{
    void sound();
}
//인터페이스를 구현한 클래스
class Cat implements Animal{
    @Override
    public void sound(){
        System.out.println("Meow");
    }
}
class Dog implements Animal{
    @Override
    public void sound(){
        System.out.println("Bark");
    }
}


//부모 클래스
class Fish{
    String place = "sea";
    String name;

    public Fish(){}
    public Fish(String name){
        this.name = name;
    }

    void species(){
        System.out.println("물고기");
    }
}
//Fish클래스를 상속. Shark객체는 Fish클래스의 필드와 메서드를 사용가능
class Shark extends Fish{
    public Shark(){}

    public Shark(String name){
        super(name);
    }

    void name(){
        System.out.println("상어");
    }
}


//추상클래스
abstract class Car{
    public Car(){}

    abstract void sound();
    //상속된 클래스들이 공통으로 사용할 메서드
    void wheel(){
        System.out.println("4개");
    }
}
//추상클래스를 상속하여 인스턴스마다 추상메서드를 별도로 구현
class SUV extends Car{

    @Override
    void sound() {
        System.out.println("달달달달");
    }
}


class Animal2{
    String place = "공원";
    void walk() {
        System.out.println("걸어");
        System.out.println("소입니까? " + (this instanceof Cow));
        System.out.println("말입니까? " + (this instanceof Horse));

        if(this instanceof Cow){
            System.out.println("소몰이");
        }else if(this instanceof Horse){
            System.out.println("다그닥");
        }
    }

    void eat(){
        System.out.println("냠냠");
    }
}
class Cow extends Animal2{
    String place = "축사";
    void eat(String food){
        System.out.println(food + "를 냠냠");
    }

}
class Horse extends Animal2{
    @Override
    void eat() {
        System.out.println("풀머겅");
    }

}


class Box<T>{
    private T item;

    void setItem(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }
}
//어떤 타입의 배열이 오더라도 출력할 수 있음
class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}