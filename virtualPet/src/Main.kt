class VirtualPet(val nome: String) {

    var fome = 50
    var felicidade = 50
    var cansaco = 0
    var idade = 0

    fun alimentar() {
        fome -= 10
        if (fome < 0) fome = 0
        println("$nome foi alimentado.")
    }

    fun brincar() {
        felicidade += 10
        cansaco += 15

        if (felicidade > 100) felicidade = 100
        if (cansaco > 100) cansaco = 100

        println("$nome está brincando.")
    }

    fun descansar() {
        cansaco -= 20
        if (cansaco < 0) cansaco = 0
        println("$nome está descansando.")
    }

    fun verificarStatus() {
        println("\n--- STATUS ---")
        println("Nome: $nome")
        println("Idade: $idade")
        println("Fome: $fome")
        println("Felicidade: $felicidade")
        println("Cansaço: $cansaco")
    }

    fun passarTempo() {
        fome += 3
        felicidade -= 3
        cansaco += 10
        idade += 1

        if (fome > 100) fome = 100
        if (felicidade < 0) felicidade = 0
        if (cansaco > 100) cansaco = 100
    }

    fun perdeu() = fome >= 100 || cansaco >= 100 || felicidade <= 0

    fun venceu() = idade >= 50
}


fun main() {

    println("Digite o nome do seu pet:")
    val nome = readLine() ?: "Pet"

    val pet = VirtualPet(nome)

    while (true) {

        println("\nEscolha uma ação:")
        println("1 - Alimentar")
        println("2 - Brincar")
        println("3 - Descansar")
        println("4 - Status")
        println("5 - Passar tempo")

        when (readLine()) {
            "1" -> pet.alimentar()
            "2" -> pet.brincar()
            "3" -> pet.descansar()
            "4" -> pet.verificarStatus()
            "5" -> {
                pet.passarTempo()
                println("O tempo passou...")
            }
            else -> println("Opção inválida")
        }

        if (pet.perdeu()) {
            println("\n💀 Você perdeu!")
            pet.verificarStatus()
            break
        }

        if (pet.venceu()) {
            println("\n🎉 Você venceu! Seu pet chegou aos 50 anos!")
            pet.verificarStatus()
            break
        }
    }
}