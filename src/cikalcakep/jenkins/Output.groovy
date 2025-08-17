package cikalcakep.jenkins;

class Output {
    static def hello(String name) {
        println("Hello $name")
    }
}

def steps = [
    echo: { msg -> println(msg) }
]

Output.hello(steps, "Groovy")
