package com.vova

abstract class Animal {
    val name: String
}

abstract class Pet extends Animal {

}

class Dog extends Pet {
    override val name: String = "dog"
}

class Cat extends Pet {
    override val name: String = "cat"
}

class Lion extends Animal {
    override val name: String = "lion"
}

class PetContainer[P <: Pet](val pet: P) {
}

object demo_034_extends_uplowlimit {

    /**
     * 1）语法
     * Class PersonList[T <\: Person]{ //泛型上限
     * }
     * Class PersonList[T >: Person]{ //泛型下限
     * }
     * 2）说明
     * 泛型的上下限的作用是对传入的泛型进行限定。 
     */

    def printer(petContainer: PetContainer[Pet]) = {
        println(petContainer.pet.name)
    }

    def main(args: Array[String]): Unit = {
        val dog: Dog = new Dog()
        val cat: Cat = new Cat()
        val lion: Lion = new Lion()

        val dogContainer: PetContainer[Dog] = new PetContainer[Dog](dog)
        val catContainer: PetContainer[Cat] = new PetContainer[Cat](cat)
//        val lionContainer: PetContainer[Lion] = new PetContainer[Lion](lion) //Error

    }

}
