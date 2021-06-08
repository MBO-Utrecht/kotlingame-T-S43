fun main(args: Array<String>) {
    val ANSI_RED = "\u001B[31m"
    val ANSI_RESET = "\u001B[0m"
    val ANSI_CYAN = "\u001b[0;96m"
    val ANSI_PURPLE = "\u001b[35m"
    val ANSI_YELLOW = "\u001b[1;33m"
    val ANSI_VIBRANT_YELLOW = "\u001b[1;93m"
    val ANSI_GREEN = "\u001b[1;92m"

    println("There was once a man called "+ ANSI_PURPLE + "Bladimir" + ANSI_RESET + ", he practiced the dark arts and became the ultimate being Bladcula.")
    println(ANSI_PURPLE + "He" + ANSI_RESET + " was stopped by the priest society and banished to hell.")
    println("Now 500 years later " + ANSI_PURPLE + "he" + ANSI_RESET +" is back for revenge, " + ANSI_PURPLE + "he" + ANSI_RESET + " killed all members of the priest society somehow "+ ANSI_CYAN + "you" + ANSI_RESET + " survived and are out on vengeance.")

    println("\nWhat is your name?")
    var username = readLine()


    while (username!!.isBlank()) {
        println("Please enter a valid username")
        username = readLine()
    }
    val player = Player("$username", 4, 30)
    // Begin items
    val woodenSword = Weapon("Wooden Sword", 8)
    val woodenSwordItem = Loot("Wooden Sword", LootType.WEAPON)

    val cloak = Loot("Cloak", LootType.ARMOR)
    val redPotion = Loot("Health Potion", LootType.POTION)

    // Collectible items
    val key1 = Loot("Key 1", LootType.KEY)

    val ironSword = Weapon("Iron Sword", 16)
    val ironSwordItem = Loot("Iron Sword", LootType.WEAPON)

    // World 2
    val bloodOfdarkness = Weapon("Blood of darkness", 40)
    val bloodOfdarknessItem = Loot("Blood of darkness", LootType.WEAPON)

    val holyBlood = Loot("Holy Blood", LootType.ARTIFACT)
    val holyWater = Loot("Holy Water", LootType.ARTIFACT)

    val key2 = Loot("Key 2", LootType.KEY)

    // Begin Items
    player.inventory.add(cloak)
    player.weapon = woodenSword
    player.inventory.add(redPotion)
    player.inventory.add(woodenSwordItem)

    // Begin var
    var level1 = true
    var key1Data = false
    var mummyBoss = true
    // World 2
    var level12 = true
    var level22 = true
    var level32 = true

    // Enemies
    val zombie = Zombie("Zombie", 10,1, 5)

    // World 2
    val skeleton = Enemy("Skeleton", 10, 1, 5)
    val abomination = Enemy("Abomination", 10,2, 4)
    val azreal = Enemy("Angel", 18, 2, 4)

    // Game start
    println("So $username started his crusade")

    println("\n\n$username arrived at " + ANSI_PURPLE + "Bladcula's" + ANSI_RESET + " mansion he never felt this level of evil power before, if this power would be unleashed"+ ANSI_RED + "\narmageddon would surely happen." + ANSI_RESET)
    println("He went inside and shivered, it felt like he was in a freezer he marched to the hallway.")
    println("Press enter to continue text")
    readLine()

    println("\nThere are 3 doors one on your left, one on the right and one at the end of the hallway.")
    println("Type 1 for the door on the left")
    println("Type 2 for the door on the right")
    println("Type 3 for the door at the end of the hallway")


    //------------------End of the start------------------
    var playing = true
    var world = 1
    while (world == 1) {

        fun level1() {
            println("It's cold and wet, in the corner $username saw a zombie coming towards him.\nPrepare for combat.")
            println("Type in 1 to fight.")
            while (level1) {
                var fight = readLine()
                if (fight == "1") {
                    zombie.takeDamage(player.weapon.damageInflicted)
                    if (zombie.lives < 1) {
                        println("Zombie is defeated by $username.")
                        println(ANSI_GREEN + "Hmmm what is this " + ANSI_CYAN + "$username" + ANSI_GREEN + " picked up an 'Iron Sword'" + ANSI_RESET)
                        player.weapon = ironSword
                        player.inventory.add(ironSwordItem)
                        println("Press enter to leave the room")
                        readLine()
                        level1 = false
                    } else {
                        player.takeDamage(zombie.damageInflicted)
                    }
                    } else {
                        println("Sorry I didn't quite catch that, type in 1 to hit the enemy")
                }
            }
        }

            fun level2() {
                println(ANSI_YELLOW + "The room is filled with sand, also there is a small pyramid in the middle of the room." + ANSI_RESET + "\n$username" + ANSI_YELLOW + " touched the pyramid, suddenly a mummy appeared he doesn't look happy ")
                while (mummyBoss) {
                    println(ANSI_YELLOW + "To defeat the mummy, you have to solve a puzzle,")
                    println(ANSI_VIBRANT_YELLOW + "what is the answer to: 56+14+31")
                    var choosemummy = readLine()
                    if (choosemummy == "101") {
                        println(ANSI_GREEN + "That's correct, the mummy is defeated!")
                        println(ANSI_RESET + "You picked up a key, try it on the door in another room")
                        mummyBoss = false
                        player.inventory.add(key1)
                        key1Data = true
                        println("Press enter to leave the room")
                        readLine()
                    } else {
                        println(ANSI_RED + "Oh no! That's the wrong answer, try again")
                        println(ANSI_VIBRANT_YELLOW + "before the mummy can beat you!\n")
                    }

                }


            }

            fun level3() {
                if (key1Data != true) {
                    println("The door is closed.")
                    println("Choose another option!")
                } else {
                    println("You're entering the basement.")
                    world = 2
                }
            }

            fun repeatText1() {
                println("\nThere are 3 doors one on your left, one on the right and one at the end of the hallway.")
                println("Type 1 for the door on the left")
                println("Type 2 for the door on the right")
                println("Type 3 for the door at the end of the hallway")
            }


            val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

            when (userInput.first()) {
                "QUIT", "EXIT", "Q" -> System.exit(0)
                "1" -> level1()
                "2" -> level2()
                "3" -> level3()
                "HELP" -> showHelp()
                "INVENTORY", "INV" -> player.showInventory()
                "AGAIN" -> repeatText1()
                else -> {
                    println("You can type in 'help' to see a list of commands")
                }
            }
        }
//    /////////
//    world 2!
//    /////////
        println("There is a foul smell down here in the basement, this time there are three rooms.\nOne in front of you which reeks of blood.\nOne right of you, it looks like a torture chamber.")
        println("And one left of you, it smells like hell.") // fix text
        println("\nType 1 for the door on the left.\nType 2 for the door on the right. \nType 3 for the door in front of you.")
        while (world == 2) {

            fun level12() {
                println("You see an skeleton, prepare to fight.")
                println("Type in 1 to fight.")
                while (level12) {
                    var fight = readLine()
                    if (fight == "1") {
                        skeleton.takeDamage(player.weapon.damageInflicted)
                        if (skeleton.lives < 1) {
                            println("The skeleton is defeated by $username.")
                            println(ANSI_GREEN + "Hmmm what is this " + ANSI_CYAN + "$username" + ANSI_GREEN + " took the red glowing sword " + ANSI_RED + "'Blood of darkness'" + ANSI_RESET)
                            println(ANSI_CYAN + "An demon weapon against demons this might work." + ANSI_RESET)
                            player.weapon = bloodOfdarkness
                            player.inventory.add(bloodOfdarknessItem)
                            println("Press enter to leave the room")
                            readLine()

                            level12 = false
                        } else {
                            player.takeDamage(skeleton.damageInflicted)
                        }
                    } else {
                        println("The player typed something that doesn't work maybe type in 1 to hit the enemy.")
                    }

                }
            }

            fun level22() {
                println(
                    "There is an human in the room $username looked closer " +
                            ANSI_CYAN + "'By the gods what has " + ANSI_PURPLE + "Bladimir" + ANSI_CYAN + " done to him.'" + ANSI_RESET +
                            "\nSuddenly the mutilated corpse woke up and came towards $username"
                )
                while (level22) {
                    var fight = readLine()
                    if (fight == "1") {
                        abomination.takeDamage(player.weapon.damageInflicted)
                        if (abomination.lives < 1) {
                            println("The abomination is defeated by $username.")
                            println(ANSI_CYAN + "$username" + ANSI_GREEN + " took the health potion'" + ANSI_RESET)
                            println(ANSI_CYAN + "Dammit this can't be allowed to exist may the gods look over him, BLADMIR YOUR NEXT!!!!" + ANSI_RESET)
                            println("$username left the room in anger")
                            player.inventory.add(redPotion)
                            println("Press enter to leave the room")
                            readLine()

                            level22 = false
                        } else {
                            player.takeDamage(abomination.damageInflicted)
                        }
                    } else {
                        println("MMMMmmm it seems this doesn't work maybe type in 1 to hit the enemy.")
                    }

                }

            }

            fun level32() {
                println("It reeks of blood but somehow you feel a holy presence in the room. \nThere are two pedestals, one with Holy Water and one with Holy Blood.")
                println("$username grabbed the Holy Blood.")
                player.inventory.add(holyBlood)
                println("Press enter to continue text")
                readLine()
                println("Suddenly an angel appeared 'You dare take the Holy Blood of Hesus, are you worthy to take on evil?'\n'I SHALL TEST YOU MORTAL!!!'")
                while (level32) {
                    var fight = readLine()
                    if (fight == "1") {
                        azreal.takeDamage(player.weapon.damageInflicted)
                        if (azreal.lives < 1) {
                            println("Angel is defeated by $username")
                            println("Very well mortal I shall let you take the Holy water and the Holy blood but if you fail I will make you feel my wrath!")
                            println("$username got the Holy Water")
                            player.inventory.add(holyWater)
                            println("\n$username found an key in the room he picked it up.\nSuddenly a trap door opened from below and he fell trough it.")
                            player.inventory.add(key2)
                            println("You're entering the 2nd floor.")
                            println("Press enter to continue")
                            readLine()

                            level32 = false
                            world = 3
                        } else {
                            player.takeDamage(azreal.damageInflicted)
                        }
                    } else {
                        println("Hey player that command doesn't work try typing in 1 to fight")
                    }

                }

            }

            fun repeatText2() {
                println("\nType 1 for the door on the left.\nType 2 for the door on the right\nType 3 for the door in front of you")
            }


            val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

            when (userInput.first()) {
                "QUIT", "EXIT", "Q" -> System.exit(0)
                "1" -> level12()
                "2" -> level22()
                "3" -> level32()
                "HELP" -> showHelp()
                "INVENTORY", "INV" -> player.showInventory()
                "AGAIN" -> repeatText2()
                else -> {
                    println("You can type in 'help' to see a list of commands")
                }
            }
        }
//////////// World 3 ////////////
        while (world == 3) {
            println("END OF DEMO")

            fun repeatText3() {
                println("Oeps no spoilers here (¬‿¬)")
            }

            val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

            when (userInput.first()) {
                "QUIT", "EXIT", "Q" -> System.exit(0)
//            "1" -> level12()
//            "2" -> level22()
//            "3" -> level32()
                "HELP" -> showHelp()
                "INVENTORY", "INV" -> player.showInventory()
                "AGAIN" -> repeatText3()
                else -> {
                    println("You can type in 'help' to see a list of commands")
                }
            }
        }



}

// Fun out of main

fun showHelp() {
    println("-------------------------------------------")
    println("Type q, exit or quit to quit the game.")
    println("\nYou can right click and clear all text.")
    println("\nType in inventory or inv to see your inventory.")
    println("\nType in again to repeat the room guide text.")
    println("--------------------TIPS-------------------")
    println("\nYou automatically use the best weapon in your inventory.")
    println("-------------------------------------------")
}

fun playerInput(): String {
    var input: String? = null
    while (input == null) {
        print("> ")
        input = readLine()
    }
    return input.toLowerCase()
}


///////////////// Archive /////////////////
//val mummyBoss = Mummy("Mummy", 30, 2)

//fun level1() {
//    var world1 = false
//    println("Fucking ghost's I hate ghost's")
//}

//    println("Enter a string :")
//    val userInputString = readLine()
//
//    println("You have entered : $userInputString")