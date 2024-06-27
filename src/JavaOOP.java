public class JavaOOP {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("lee", 30);
        person1.setAge(25);
        person1.setName("kim");

        System.out.println(person1.getName());
        System.out.println(person2.getName());

        System.out.println(Person.from);

        Cat cat1 = new Cat();
        Dog dog1 = new Dog();

        cat1.sound();
        dog1.sound();


        Fish fish1 = new Fish();
        System.out.println(fish1.place);
        fish1.species();

        Shark shark1 = new Shark();
        System.out.println(shark1.place);
        shark1.species();
        shark1.name();

        Shark shark2 = new Shark("아기상어");

        System.out.println(shark2.name);

        SUV suv1 = new SUV();
        suv1.wheel();
        suv1.sound();
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