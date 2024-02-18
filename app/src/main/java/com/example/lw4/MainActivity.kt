package com.example.lw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import com.example.lw4.Arthritis.*
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private var reum_art = Arthritis("Ревматоидный артрит", 1)
    private var podagr_art = Arthritis("Подагрический артрит", 2)
    private var react_art = Arthritis("Реактивный артрит", 3)

    private var num_sym_1 = 10
    private var num_sym_2 = 3
    private var num_sym_3 = 3
    private var num_sym_4 = 3
    private var num_sym_5 = 13

    private var symptom1 = Symptom(
        name_sym = "Один крупный сустав (покраснение)",
        coef_sym = arrayOf(7.69),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(2)
    )
    private var symptom2 = Symptom(
        name_sym = "От 2 до 10 крупных суставов",
        coef_sym = arrayOf(5.43),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(1)
    )
    private var symptom3 = Symptom(
        name_sym = "От 1 до 3 мелких суставов (без учета крупных)",
        coef_sym = arrayOf(10.87),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(1)
    )
    private var symptom4 = Symptom(
        name_sym = "От 4 до 10 мелких суставов (без учета крупных)",
        coef_sym = arrayOf(16.30),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(1)
    )
    private var symptom5 = Symptom(
        name_sym = "Более 10 суставов (как минимум один мелкий сустав)",
        coef_sym = arrayOf(27.17),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(1)
    )
    private var symptom6 = Symptom(
        name_sym = "Вовлечение первого плюснефалангового сустава",
        coef_sym = arrayOf(19.23),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(2)
    )
    private var symptom7 = Symptom(
        name_sym = "Энтезопатии (боль в пятке, боль в проекции большеберцового бугра)",
        coef_sym = arrayOf(8.89),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(3)
    )
    private var symptom8 = Symptom(
        name_sym = "Воспалительная боль в нижнем отделе спины: сакроилеит",
        coef_sym = arrayOf(9.33),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(3)
    )
    private var symptom9 = Symptom(
        name_sym = "Воспалительная боль в нижнем отделе спины: спондилит",
        coef_sym = arrayOf(5.63),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(3)
    )
    private var symptom10 = Symptom(
        name_sym = "Воспаление связок и сухожилий в месте их прикрепления к седалищному бугру",
        coef_sym = arrayOf(6.52),
        group_sym = "Клинические признаки поражения суставов (припухлость, воспаление)",
        artr_num = arrayOf(3)
    )
    private var symptom11 = Symptom(
        name_sym = "Достижение максимальных проявлений артрита во время атаки за один день",
        coef_sym = arrayOf(0.54, 3.85),
        group_sym = "Атака артрита",
        artr_num = arrayOf(1,2)
    )
    private var symptom12 = Symptom(
        name_sym = "Одна или более атак артрита в анамнезе",
        coef_sym = arrayOf(1.63, 15.38),
        group_sym = "Атака артрита",
        artr_num = arrayOf(1,2)
    )
    private var symptom13 = Symptom(
        name_sym = "Периферический артрит (несимметричный, олигоартрит)",
        coef_sym = arrayOf(6.52),
        group_sym = "Атака артрита",
        artr_num = arrayOf(3)
    )
    private var symptom14 = Symptom(
        name_sym = "Отрицательны",
        coef_sym = arrayOf(),
        group_sym = "Тесты на РФ и АЦЦП",
        artr_num = arrayOf()
    )
    private var symptom15 = Symptom(
        name_sym = "Слабо позитивны для РФ или АЦЦП (превысили границу нормы, но менее, чем в 3 раза)",
        coef_sym = arrayOf(10.87),
        group_sym = "Тесты на РФ и АЦЦП",
        artr_num = arrayOf(1)
    )
    private var symptom16 = Symptom(
        name_sym = "Высоко позитивны для РФ или АЦЦП (более, чем в 3 раза превысили границу нормы)",
        coef_sym = arrayOf(16.30),
        group_sym = "Тесты на РФ и АЦЦП",
        artr_num = arrayOf(1)
    )
    private var symptom17 = Symptom(
        name_sym = "Норма по СОЭ (Скорость оседания эритроцитов) и СРБ (С-реактивный белок)",
        coef_sym = arrayOf(),
        group_sym = "Показательные анализы",
        artr_num = arrayOf()
    )
    private var symptom18 = Symptom(
        name_sym = "Повышение СОЭ (Скорость оседания эритроцитов) или уровня СРБ (С-реактивный белок)",
        coef_sym = arrayOf(5.43),
        group_sym = "Показательные анализы",
        artr_num = arrayOf(1)
    )
    private var symptom19 = Symptom(
        name_sym = "Мочевая кислота >6,0 мг/дл (360 мкмоль/л)",
        coef_sym = arrayOf(26.92),
        group_sym = "Показательные анализы",
        artr_num = arrayOf(2)
    )
    private var symptom20 = Symptom(
        name_sym = "Синовит до 6 недель",
        coef_sym = arrayOf(),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf()
    )
    private var symptom21 = Symptom(
        name_sym = "Синовит от 6 недель",
        coef_sym = arrayOf(5.43),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(1)
    )
    private var symptom22 = Symptom(
        name_sym = "Гипертензия и/или одна или более кардиоваскулярных болезней",
        coef_sym = arrayOf(11.54),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(2)
    )
    private var symptom23 = Symptom(
        name_sym = "Конъюнктивит",
        coef_sym = arrayOf(8.89),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom24 = Symptom(
        name_sym = "Уретрит, простатит",
        coef_sym = arrayOf(23.70),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom25 = Symptom(
        name_sym = "Эндоскопические признаки поражения кишечника",
        coef_sym = arrayOf(14.07),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom26 = Symptom(
        name_sym = "Бленнорагическая кератодермия",
        coef_sym = arrayOf(5.19),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom27 = Symptom(
        name_sym = "Эрозивный круговидный баланит (4–20%)",
        coef_sym = arrayOf(3.56),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom28 = Symptom(
        name_sym = "Язвы слизистой оболочки полости рта",
        coef_sym = arrayOf(2.22),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom29 = Symptom(
        name_sym = "Гиперкератоз ногтей",
        coef_sym = arrayOf(2.67),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom30 = Symptom(
        name_sym = "Нарушения проводимости по данным ЭКГ",
        coef_sym = arrayOf(2.81),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(3)
    )
    private var symptom31 = Symptom(
        name_sym = "Мужской пол",
        coef_sym = arrayOf(15.38),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf(2)
    )
    private var symptom32 = Symptom(
        name_sym = "Женский пол",
        coef_sym = arrayOf(),
        group_sym = "Переносимые процессы и/или болезни",
        artr_num = arrayOf()
    )
    private lateinit var text_group: TextView
    private lateinit var text_symptom: TextView
    private lateinit var num_symptom: TextView

    private lateinit var btn_yes: Button
    private lateinit var btn_no: Button
    private lateinit var btn_start: Button
    private lateinit var btn_back: Button
    private lateinit var btn_end: Button
    private lateinit var btn_next: Button

    private var arts = arrayOf(reum_art, podagr_art, react_art)
    private var symptoms = arrayOf(symptom1,
        symptom2,
        symptom3,
        symptom4,
        symptom5,
        symptom6,
        symptom7,
        symptom8,
        symptom9,
        symptom10,
        symptom11,
        symptom12,
        symptom13,
        symptom14,
        symptom15,
        symptom16,
        symptom17,
        symptom18,
        symptom19,
        symptom20,
        symptom21,
        symptom22,
        symptom23,
        symptom24,
        symptom25,
        symptom26,
        symptom27,
        symptom28,
        symptom29,
        symptom30,
        symptom31,
        symptom32)

    private lateinit var res_list: ListView
    private lateinit var coef_list: ListView
    private lateinit var DB: ArrayList<Prop>
    private lateinit var res_adapter: ArrayAdapter<*>
    private lateinit var coef_adapter: ArrayAdapter<*>

    private var i = 0
    private var ans = false

    var coefs = arrayListOf<String>()
    var names = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_group = findViewById<View>(R.id.text_group) as TextView
//        text_group.text = "this app has to blablabla"
        text_symptom = findViewById<View>(R.id.text_symptom) as TextView
        num_symptom = findViewById<View>(R.id.num_symptom) as TextView
        num_symptom.isVisible = false
        text_symptom.isVisible = false
        btn_yes = findViewById<View>(R.id.button_yes) as Button
        btn_no = findViewById<View>(R.id.button_no) as Button
        btn_back = findViewById<View>(R.id.button_back) as Button
        btn_end = findViewById<View>(R.id.button_end) as Button
        btn_next = findViewById<View>(R.id.button_next) as Button
        btn_yes.isVisible = false
        btn_no.isVisible = false
        btn_back.isVisible = false
        btn_end.isVisible = false
        btn_next.isVisible = false

        btn_start = findViewById<View>(R.id.button_start) as Button

        btn_start.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (btn_start.text == "Начать") {
                    text_symptom.isVisible=true
                    num_symptom.isVisible=true
                    btn_back.isVisible = false
                    btn_no.isVisible = true
                    btn_yes.isVisible = true
                    btn_next.isVisible=true
                    btn_start.text = "Заново"
                } else {
                    text_symptom.isVisible = true
                    text_group.isVisible = true
                    num_symptom.isVisible = true
                    res_list.isVisible = false
                    coef_list.isVisible = false
                    reset_scores()
                    DB.clear()
                    i = 0
                    btn_yes.isVisible = true
                    btn_no.isVisible = true
                    btn_next.isVisible=true
                    btn_back.isVisible = false
                }
                update()
            }
        })
        btn_yes.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                ans = true
                DB.add(Prop(symptom = symptoms[i], answer = ans))
                update()
            }
        })
        btn_no.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                ans = false
                DB.add(Prop(symptom = symptoms[i], answer = ans))
                update()
            }
        })
        btn_back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                DB.removeLast()
                i-=2
                update()
            }
        })
        btn_end.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                showres()
            }
        })
        btn_next.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                next_group()
            }
        })
        DB = arrayListOf()
        res_list = findViewById<View>(R.id.res_list) as ListView
        coef_list = findViewById<View>(R.id.coef_list) as ListView
        res_adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, names)
        res_list.adapter = res_adapter
        res_list.isVisible = false
        coef_list.isVisible = false
    }

    private fun update() {
        if(DB.size > 0){
            btn_next.isVisible = true
            btn_back.isVisible = true
            btn_end.isVisible = true
        }
        if (DB.isEmpty()) {
            i=0
            btn_next.isVisible = true
            btn_back.isVisible = false
            text_symptom.text = symptoms[i].name
            text_group.text = symptoms[i].group
        }
        else if (DB.size < symptoms.size) {
            i++
            text_symptom.text = symptoms[i].name
            text_group.text = symptoms[i].group
        }
        else if (DB.size == symptoms.size) {
            showres()
        }
        if(DB.size >= 19){
            btn_next.isVisible = false
        }
        num_symptom.text = get_num_symptom()
    }

    private fun showres() {
        text_symptom.isVisible = false
        text_group.text = "Результаты диагностики:"
        num_symptom.isVisible = false
        btn_yes.isVisible = false
        btn_no.isVisible = false
        btn_back.isVisible = false
        btn_end.isVisible = false
        btn_next.isVisible = false
        coefs.clear()
        names.clear()
        coefs.add("Диагностический индекс")
        names.add("Форма заболевания")
        for (prop in DB) {
            if (prop.ans == true) {
                val symptom = prop.sym
                var j = 0
                while (j < symptom.arth_ind.size) {
                    val ind = symptom.arth_ind[j]
                    for (art in arts) {
                        if (art.self_ind == ind) {
                            art.score += symptom.coef[j]
                        }
                    }
                    j++
                }
            }
        }
        for (art in arts) {
            coefs.add(String.format("%.2f", art.score))
//            coefs.add(art.score.toString().format())
            names.add(art.name)
        }
        res_list.isVisible = true
        coef_adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, coefs)

        coef_list.adapter = coef_adapter
        coef_list.isVisible = true
    }
//        text_group.text = "ревматоидный артрит - " + reum_art.score.toString()
//        text_symptom.text = "подагрический артрит - " + podagr_art.score.toString()


    private fun reset_scores(){
        for (art in arts){
            art.score = 0.0
        }
    }

    private fun get_num_symptom(): String{
        var cur_num = "Признак "
        if(i < 10){
            cur_num += (i+1).toString() + "/"+num_sym_1.toString()
        }
        else if(i < 13){
            cur_num += (i+1 - 10).toString() + "/"+num_sym_2.toString()
        }
        else if(i < 16){
            cur_num += (i+1 - 13).toString() + "/"+num_sym_3.toString()
        }
        else if(i < 19){
            cur_num += (i+1 - 16).toString() + "/"+num_sym_4.toString()
        }
        else if(i < 32){
            cur_num += (i+1 - 19).toString() + "/"+num_sym_5.toString()
        }
        return cur_num
    }

    private fun next_group(){
        if(i < 10){
            while (i < 10){
                DB.add(Prop(symptoms[i], false))
                i++
            }
        }
        else if(i < 13){
            while (i < 13){
                DB.add(Prop(symptoms[i], false))
                i++
            }
        }
        else if(i < 16){
            while (i < 16){
                DB.add(Prop(symptoms[i], false))
                i++
            }
        }
        else if(i < 19){
            while (i < 19){
                DB.add(Prop(symptoms[i], false))
                i++
            }
        }
        i--
        update()
    }
}