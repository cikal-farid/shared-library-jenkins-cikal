package cikalcakep.jenkins;

class Output {
    static def hello(String name) {
        println("Hello $name")
    }
}

// Mendefinisikan langkah
def steps = [
    echo: { msg -> println(msg) }
]

// Memanggil metode hello dengan satu argumen
Output.hello("Groovy")
