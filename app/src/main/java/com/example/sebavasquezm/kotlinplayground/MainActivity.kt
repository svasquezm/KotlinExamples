package com.example.sebavasquezm.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sebavasquezm.kotlinplayground.exampleclasses.Examples

class MainActivity : AppCompatActivity() {

    val TAG = "Examples"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val examples = Examples()
        val fakePerson = Examples.Person("Alberto", "Kast", 0)
        val fakePersonName = Examples.PersonName("Alberto", "Kast")

        Log.i(TAG, "getSpeakingLanguage(france): ${examples.getSpeakingLanguage("france")}")
        Log.i(TAG, "tryCatchExample() ${examples.tryCatchExample()}")
        Log.i(TAG, "Count x ${"This is the best example of this".countAmountOfX()}")
        Log.i(TAG, "getNameFromPerson(person) ${examples.getNameFromPerson(fakePerson)}")
        Log.i(TAG, "getNameFromPerson(null) ${examples.getNameFromPerson(null)}")
        Log.i(TAG, "checkPerson(person) ${examples.checkPerson(fakePerson).getFullDetails()}")
        Log.i(TAG, "checkPerson(null) ${examples.checkPerson(null).getFullDetails()}")
        Log.i(TAG, "getNameFromPersonUsingLet(person) ${examples.getNameFromPersonUsingLet(fakePerson)}")
        Log.i(TAG, "getNameFromPersonUsingLet(null) ${examples.getNameFromPersonUsingLet(null)}")
        Log.i(TAG, "sendEmail('alaska@alaska.cl') ${examples.sendEmail(Examples.EmailAddress("alaska@alaska.cl"))}")
        Log.i(TAG, "mapToPerson(person) ${examples.mapToPerson(fakePersonName).getFullDetails()}")
        Log.i(TAG, "destructuringUsingMaps() ${examples.destructuringUsingMaps()}")
        Log.i(TAG, "useMapToCreateAJSONObject() ${examples.useMapToCreateAJSONObject()}")
    }

    /**
     * We can extend class functions as well
     */
    fun String.countAmountOfX(): Int {
        return length - replace("x", "").length
    }


}
