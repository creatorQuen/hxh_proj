package main

class Monster(
    attack: Int,
    defense: Int,
    health: Int,
    rangeDamage: IntRange
) : AbstractCreature(attack, defense, health, rangeDamage), IAttack {

    override fun attack(creature: AbstractCreature) {
        val modifierAttack = if (attack - creature.defense + 1 <= 0 ) attack - creature.defense + 1  else 1

        var success = false
        for(i in 1..modifierAttack) {
            val cubeNumber = (0..6).random()

            if (cubeNumber >= 5) {
                success = true
                break
            }
        }

        if (success) {
            val damage = rangeDamage.random()
            println("Monster damage: $damage damage.")
            creature.takeHealth(damage)
        } else {
            println("Monster miss attack.")
        }
    }

}