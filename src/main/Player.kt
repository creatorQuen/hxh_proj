package main

const val MAX_HEAL_IN_GAME = 4

class Player(
    attack : Int,
    defence : Int,
    health : Int,
    rangeDamage: IntRange
) : AbstractCreature(attack, defence, health, rangeDamage), IAttack, IHealing {

    private var maxHeatPoints = health

    private var _countHeal = 0


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
            println("Player damage: $damage damage.")
            creature.takeHealth(damage)
        } else {
            println("Player miss attack.")
        }
     }

    override fun heal() {
        if (_countHeal > MAX_HEAL_IN_GAME) {

            var newHealth = maxHeatPoints + health / 3
            if ( newHealth > health) {
                newHealth = health
            }

            this._countHeal++
        }
    }
}