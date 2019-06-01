package com.example.avengers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Main2Activity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = arrayOf("IRON MAN" , "CAPTAIN AMERICA" , "THOR" ,"HULK" , "BLACK WIDOW" , "BARTON" , "ANT MAN" , "CAPTAIN MARVEL")
        var real = arrayOf("Robert Downey Jr. " , "Chris Evans" , "Chris Hensforth" , "Mark Ruffalow" , "Scarlet johnson" ,"Hawk eye" , "Scott lang" , "Elizabeth")
        val image = arrayOf(R.drawable.iron_man,R.drawable.captain_america,R.drawable.thor,R.drawable.hulk,R.drawable.black_widow,R.drawable.barton,R.drawable.ant_man,R.drawable.captain_marvel)

        val desc=arrayOf("Baby","janu","sona"," rona" , "mona" , "lona" , "chona" , "dhona")

        val img=findViewById<ImageView>(R.id.image)
        val nm=findViewById<TextView>(R.id.name)
        val rl=findViewById<TextView>(R.id.real)
        val ds=findViewById<TextView>(R.id.desc)
        val btn=findViewById<Button>(R.id.button)
        val i=intent
        val index:Int=i.getIntExtra("index",0)



        img.setImageResource(image[index])
        nm.text = name[index]
        rl.text = real[index]
        ds.text = desc[index]




        btn.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
