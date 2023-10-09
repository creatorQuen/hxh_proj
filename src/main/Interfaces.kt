package main

interface IAttack {

    fun attack(creature: AbstractCreature)
}

interface IHealing {

    fun heal()
}