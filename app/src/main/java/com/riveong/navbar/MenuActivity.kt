package com.riveong.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.search.SearchBar
import com.riveong.navbar.databinding.ActivityMainBinding
import com.riveong.navbar.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMenuBinding
    private lateinit var searchBar: SearchBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)


        setContentView(binding.root)





        with(binding){//logic when clicked
            searchView.setupWithSearchBar(searchBar) //bind them
            searchView.editText.setOnEditorActionListener{ textView, actionId, event ->
                searchBar.text = searchView.text
                searchView.hide()
                Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show() //some logic example here
                false


            }
        }

    }
}