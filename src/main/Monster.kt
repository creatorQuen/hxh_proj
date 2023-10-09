package main

class Monster(
    attack: Int,
    defense: Int,
    health: Int,
    damageMin: Int,
    damageMax: Int
) : AbstractCreature(attack, defense, health, damageMin, damageMax), IAttack {

    override fun attack(creature: AbstractCreature) {
        TODO("Not yet implemented")
    }

}