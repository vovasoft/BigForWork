package com.vova


abstract class Animal {
    val name: String
}

class Pet extends Animal {
    override val name: String = "Pet"
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

class PetContainer[+P](val pet: P) {
}

object demo_033_extends_1 {

    /**
     * 1）语法
     * class MyList[+T]{ //协变
     * } 
     * class MyList[-T]{ //逆变
     * }
     * class MyList[T] //不变
     * 2）说明
     * 协变：Son是Father的子类，则MyList[Son] 也作为MyList[Father]的“子类”。
     * 逆变：Son是Father的子类，则MyList[Son]作为MyList[Father]的“父类”。
     * 不变：Son是Father的子类，则MyList[Father]与MyList[Son]“无父子关系”。
     */
    def printer(petContainer: PetContainer[Pet]) = {
        println(petContainer.pet.name)
    }
    
    def main(args: Array[String]): Unit = {
        val dog: Dog = new Dog()
        val cat: Cat = new Cat()
        val lion: Lion = new Lion()
        val pet: Pet = new Pet()
        

        val dogContainer: PetContainer[Dog] = new PetContainer[Dog](dog)
        val catContainer: PetContainer[Cat] = new PetContainer[Cat](cat)
        val petContainer: PetContainer[Pet] = new PetContainer[Pet](pet)

        printer(dogContainer)
        printer(catContainer)
        printer(petContainer)
        
        
    }

}
