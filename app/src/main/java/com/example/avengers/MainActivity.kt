package com.example.avengers

import android.content.Context
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // var data = arrayOf("hulk" , "iron man" , "india" , "laptop")


        val listView = findViewById<ListView>(R.id.listview)


        val names = arrayOf("IRON MAN" , "CAPTAIN AMERICA" , "THOR" ,"HULK" , "BLACK WIDOW" , "BARTON" , "ANT MAN" , "CAPTAIN MARVEL")
        var real_name = arrayOf("Robert Downey Jr. " , "Chris Evans" , "Chris Hensforth" , "Mark Ruffalow" , "Scarlet johnson" ,"Hawk eye" , "Scott lang" , "Elizabeth")
        val images = arrayOf(R.drawable.iron_man,R.drawable.captain_america,R.drawable.thor,R.drawable.hulk,R.drawable.black_widow,R.drawable.barton,R.drawable.ant_man,R.drawable.captain_marvel)
        //  val adp = ArrayAdapter<String>(this,
        //  android.R.layout.simple_list_item_1,data)

        listView.adapter = MyAdapter(this,names,real_name,images)

        listView.setOnItemClickListener{ parent, view, position, id ->
            val s: String = parent.getItemAtPosition(position).toString()

            val intent = Intent(applicationContext,Main2Activity::class.java)

            intent.putExtra("index",position)
            startActivity(intent)


        }



    }

    class MyAdapter(context:Context,names:Array<String>,real_name:Array<String>,images:Array<Int>):BaseAdapter()  {
        private val mContex:Context
        private val names:Array<String>
        private val real_name:Array<String>
        private val images:Array<Int>


        init {
            mContex = context
            this.names = names
            this.real_name = real_name
            this.images = images
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layout:LayoutInflater =
                mContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            val rootView = layout.inflate(R.layout.album,null,true)
            val im = rootView.findViewById<ImageView>(R.id.icon)
            val txt = rootView.findViewById<TextView>(R.id.title)
            val subtext = rootView.findViewById<TextView>(R.id.subtitle)







            im.setImageResource(images[position])
            txt.text = names[position]
            subtext.text = real_name[position]

            im.setOnClickListener{
                Toast.makeText(mContex, names[position] ,Toast.LENGTH_LONG).show()
            }

            return rootView

        }

        override fun getItem(position: Int): Any {
            return "anything"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }
    }
}
