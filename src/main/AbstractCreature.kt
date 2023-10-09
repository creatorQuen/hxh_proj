package main

abstract class AbstractCreature(
    var attack: Int,
    var defense: Int,
    var health: Int,
    var rangeDamage: IntRange
) {

    fun isExist(): Boolean {
        return health > 0
    }

    fun takeHealth(damage: Int) {
        health = health - damage

        if (health < 0) {
            health = 0
        }
    }


}