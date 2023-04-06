package example.myapp

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor: FishColor{
    override val color = "gold"
}

object GrayColor: FishColor{
    override val color = "gray"
}

class PrintFishAction(val food:String): FishAction{
    override fun eat() {
        println(food)
    }
}

class Shark(fishColor: FishColor = GrayColor): FishAction by PrintFishAction("hunt and eat fish"),FishColor by fishColor

class Plecostomus(fishColor:FishColor = GoldColor): FishAction by PrintFishAction("eat algae"),FishColor by fishColor

sealed class Seal
class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal:Seal):String{
    return when(seal){
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}