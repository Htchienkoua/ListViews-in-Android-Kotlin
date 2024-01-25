package com.example.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //a listview displays a list of items in an array in a vertical manner
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        //the datasource object defined
        var countryList = resources.getStringArray(R.array.countries)

        //an adapter links a datasource(in this case the countries list) to an android view (in this case the listview previously created)
        //first we define the adapter object and link it to the datasource
        //the adapter takes 3 parameters: the context, the layout items display view and the datasource object name
        var arrayAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, countryList)

        //and we now link the previously created adapter object to the listview (our view) in this case
        listView.adapter = arrayAdapter

        //the onclick listener for the listView items to give it an action when items are clicked
        listView.setOnItemClickListener { parent, view, position , id ->

            //this returns the item integer array position which clicked, and returns it to a string since its originally an integer
            val countryName: String = parent.getItemAtPosition(position).toString()

            //to toast the country selected as a string to the user
            Toast.makeText(applicationContext, "You selected " + countryName , Toast.LENGTH_LONG).show()
        }
    }
}

