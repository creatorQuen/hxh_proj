package main

import kotlin.math.max

const val MAX_HEAL_IN_GAME = 4

class Player(
    attack : Int,
    defence : Int,
    health : Int,
    rangeDamage: IntRange
) : AbstractCreature(attack, defence, health, rangeDamage), IAttack, IHealing {

    var countHeal = MAX_HEAL_IN_GAME

    private var maxHeatPoints = health


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
            println("Player damage: $damage.")
            creature.takeHealth(damage)
        } else {
            println("Player miss attack.")
        }
     }

    override fun heal() {
        if (health == maxHeatPoints) {
            println("You have max health: ${maxHeatPoints}.")
            return
        }

        if (countHeal > 0) {
            val newHealth = maxHeatPoints / 3 + health
            if (newHealth > maxHeatPoints) {
                health = maxHeatPoints
            } else {
                health = newHealth
            }

            println("You health increase: ${maxHeatPoints / 3}")
            this.countHeal--
        } else {
            println("You can't heal anymore.")
        }
    }
}