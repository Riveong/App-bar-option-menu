# APPBar  
![hi!](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtTlbpE1nfZCnirmdelRbDVtNWYDUF3sbekxol_mnMDw&s)  
Hi hi! in this repo I'm going to implement APP Bar in a simple android app.  
the final app will look like:  
![](https://media.discordapp.net/attachments/1023598916857499680/1151743124813643828/image.png?width=266&height=541)
first thing first the holy project criteria: 

|Criteria   |value  |
|-----------|-------|
|minimum SDK| 24 API|  
first of all, allow the binding feature in gradle build file  

```kotlin
buildFeatures{
        viewBinding = true
    }
```  
to create the option menu we have to make a new resource file. right click on the resource file and make a new android resource file and define the resource type to Menu. After that a new option menu will be generated in menu folder inside the res.  
to make a new menu item we have first make an item group, This can be done in the xml file.  
open the xml file and add these lines  
```xml
<group android:menuCategory="container">
    <item
    android:id="@+id/menu1"
    android:icon="@drawable/[ur path]"
    android:title="@string/menu_1"
    app:showAsAction="ifRoom" />
        
    <item
    android:id="@+id/menu2"
    android:title="@string/menu_2"
    app:showAsAction="never" />
</group>
```  
this will create 2 menu items :  
1. the item with icon thingy.
2. an item inside the 3 dots menu.  
  
don't forget to define the bar in your activity_main.xml  
```xml
    <com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    <com.google.android.material.appbar.MaterialToolbar
        android:id="@+id/topAppBar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        app:menu="@menu/option_menu"
        app:title="@string/app_name"/>
```  
after that you want to make pages for those menu yes?  
make a fragment and activity. Then of course fill it as menancing as you want. and in the MainActivity class don't forget to bind those abominations you created.  

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)


        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId){
                R.id.menu1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentcon, MenuFragment())
                        .addToBackStack(null)
                        .commit()
                        true


                }

                R.id.menu2 -> {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false

            }
        }
```  

there you have it!

