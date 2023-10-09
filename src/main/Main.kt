package main

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("You are traveler knight you come across a dragon on the road. ")

        var knight = Player(6, 2, 20, 9..15)
        var dragon = Monster(5, 4, 25, 8..20)

        while (knight.isExist() && dragon.isExist()) {
            println("Choose an action: 1 attack")
            val choisenNumber = readLine()!!.toInt()

            when(choisenNumber) {
                1 -> {
                    knight.attack(dragon)
                    if (!dragon.isExist()) {
                        println("You win! Player HP: ${knight.health}")
                        break
                    }

                }
            }

            dragon.attack(knight)
            if (!knight.isExist()) {
                println("Monster win! Monster HP: ${dragon.health}")
                break
            }
        }
    }
}