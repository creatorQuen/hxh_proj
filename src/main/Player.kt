package main

const val MAX_HEAL_IN_GAME = 4

class Player(
    attack : Int,
    defence : Int,
    health : Int,
    minDamage : Int,
    maxDamage : Int
) : AbstractCreature(attack, defence, health, minDamage, maxDamage), IAttack, IHealing {

    var _damage = 0
    var _heatPoints = health

    private var _countHeal = 0


    override fun attack(creature: AbstractCreature) {
       // var modifyAttack =
    }

    override fun heal() {
        if (_countHeal > MAX_HEAL_IN_GAME) {

            var newHealth = _heatPoints + health / 3
            if ( newHealth > health) {
                newHealth = health
            }

            this._countHeal++
        }
    }
}