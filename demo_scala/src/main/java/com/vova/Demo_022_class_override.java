package com.vova;

/**
 * scala中属性和方法都是动态绑定，而java中只有方法为动态绑定
 * @author WangYang - vova
 * @version Create in 3:08 下午 2020/7/8
 */
class Person {

    public String name = "person";
    public void hello() {
        System.out.println("hello person");
    }

}
class Teacher extends Person {

    public String name = "teacher";
    @Override
    public void hello() {
        System.out.println("hello teacher");
    }

}

public class Demo_022_class_override {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Person person = new Teacher();

        System.out.println(teacher.name);
        teacher.hello();

        System.out.println(person.name);
        person.hello();
    }
}
