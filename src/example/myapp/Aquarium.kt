package example.myapp

import kotlin.math.PI

open class Aquarium(length:Int=100,width:Int=20,height:Int=40) {
    init {
        println("aquarium initializing")
    }
    constructor(numberOfFish:Int): this(){
        val tank = numberOfFish * 2000 * 1.1
        height = (tank/(length*width)).toInt()
    }
    var width: Int = width
    open var height:Int = height
    var length: Int = length
    open var volumn: Int
        get() = width*height*length/1000
        set(value){
            height = (value*1000)/(width*length)
        }
    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volumn * 0.9
    fun printSize(){
        println(shape)
        println("Width: $width cm" + "Length: $length cm" + "Height: $height cm")
        println("Volumn: $volumn l Water: $water l (${water/volumn*100}% full)")
    }
}

class TowerTank(override  var height: Int, var diameter:Int): Aquarium(height=height, width = diameter, length = diameter){
    override var volumn: Int
        get() = (width/2 * length/2 * height/1000* PI).toInt()
        set(value) {
            height = ((value*1000/ PI)/(width/2*length/2)).toInt()
        }
    override var water = volumn * 0.8
    override val shape = "cylindar"
}