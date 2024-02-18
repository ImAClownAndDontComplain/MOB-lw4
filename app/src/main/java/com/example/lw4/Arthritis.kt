package com.example.lw4

class Arthritis (name_ar: String, index: Int) {
    val name: String
    var score = 0.0
    val self_ind: Int
    init{
        name = name_ar
        self_ind = index
    }
}

class Symptom(name_sym: String, coef_sym: Array<Double>, group_sym: String, artr_num: Array<Int>){
    val name: String
    val group: String
    val coef: Array<Double>
    val arth_ind: Array<Int>

    init{
        name = name_sym
        group = group_sym
        coef = coef_sym
        arth_ind = artr_num
    }
}

class Prop(symptom: Symptom, answer: Boolean){
    val sym = symptom
    val ans = answer
}