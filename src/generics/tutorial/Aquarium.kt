package generics.tutorial

open class WaterSupply(var needsProcessing:Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("itemadded")

fun genericsExample(){
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium.addWater(cleaner)
    addItemTo(aquarium)
    isWaterClean(aquarium)
    println(aquarium.hasWaterSupplyOfType<FishStoreWater>())
    println(aquarium.waterSupply.isOfType<FishStoreWater>())
}

interface Cleaner<in T:WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T:WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun main() {
    genericsExample()
}