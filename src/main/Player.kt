package main

const val MAX_HEAL_IN_GAME = 4

class Player(
    private val attack : Int,
    private val defence : Int,
    private val maxHealth : Int,
    private val minDamage : Int,
    private val maxDamage : Int) : AbstractCreature(), IAttack, IHealing {

    var _damage = 0
    var _heatPoints = maxHealth

    private var _countHeal = 0


    override fun attack(damage: Int) {
       // var modifyAttack =
    }

    override fun heal(): AbstractCreature {
        if ( _heatPoints <= 0 ) {
            throw MyException("Heat points for creature is zero")
        }

        if (_countHeal > MAX_HEAL_IN_GAME) {

            var newHealth = _heatPoints + maxHealth / 3
            if ( newHealth > maxHealth) {
                newHealth = maxHealth
            }

            val player = Player(attack, defence, newHealth, minDamage, maxDamage)
            player._countHeal++

            return player
        }

        return this
    }
}