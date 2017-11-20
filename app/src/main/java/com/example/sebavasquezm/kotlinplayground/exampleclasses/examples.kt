package com.example.sebavasquezm.kotlinplayground.exampleclasses

import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * Created by seba.vasquez.m on 11/19/17.
 * Switch case example use
 */
class Examples {

    /**
     * This function returns a Locale value for each case.
     * Notice that the function does not contain a body {}
     * (This is called a Single Expression Function)
     */
    fun getSpeakingLanguage(localizationName: String) = when(localizationName.toLowerCase()){
        "germany", "austria", "switzerland" -> "Speaks german!"
        "usa", "england"                    -> "Speaks english!"
        "france", "haiti"                   -> "Speaks french!"
        else                                -> "Speaks english! (by default)"
    }

    /**
     * Try catch example. Here we reach a value from the object
     * itself
     */
    fun tryCatchExample(): String{
        val json = """
            {
                "message" : "y que pasa?"
            }
        """.trimIndent()

        val message = try {
            JSONObject(json).getString("message")
        } catch (ex: JSONException){
            "could not be retrieved due an exception"
        }

        return message
    }

    /**
     * Lets define a custom class to see how use a nice
     * way to initialize an object with and without
     * parameters
     */
    class Person(val name: String,
                 val surname: String,
                 val id: Int,
                 val home: Home? = null,
                 val isMarried: Boolean =  false){
        fun getFullDetails(): String {
            return "$name $surname id: $id isMarried: $isMarried"
        }
    }

    /**
     * Another example class for following examples
     */
    class Home(val name: String,
               val location: String = "nowhere",
               val isInUse: Boolean = false)

    /**
     * This method returns person's name if it is not null
     */
    fun getNameFromPerson(person: Person?): String {
        return person?.name ?: "Could not retrieve person's name"
    }

    /**
     * Check if the person passed in parameters is a Person object. If
     * it is not, then return an evil Person
     */
    fun checkPerson(person: Any?): Person {
        return person as? Person ?: Person("José", "Antonio", 666)
    }

    fun getNameFromPersonUsingLet(person: Person?): String {
        var name = "could not retrieve name"
        person?.let{ name = person.name }
        return name
    }

    /**
     * Data classes allow us to create classes that its only
     * purpose is to hold data
     */
    data class EmailAddress(val value: String)
    data class PersonName(val name: String,
                          val surname: String)

    /**
     * Example for data classes
     */
    fun sendEmail(email: EmailAddress): String {
        return "Sending email to ${email.value}"
    }

    fun mapToPerson(personName : PersonName) = Person(
            name = personName.name,
            surname = personName.surname,
            id = 0,
            home = Home("house's name"),
            isMarried = false
    )

    /**
     * Destructuring is a way to returning multiple values in one single
     * return sentence. For this purpose we need a Data class
     */
    fun destructuringUsingMaps(): Map<String, Int> {
        return mapOf("app.frogmi.com" to 8091,
                "neo.frogmi.com" to 9000,
                "www.frogmi.com" to 80)
    }

    /**
     * Destructuring example using a data class
     */
    fun destructuringUsingDataClass(): PersonName {
        return PersonName("Jose", "Kast")
    }

    /**
     * This example shows that is possible to create a JSON Object
     * from a Map implementation
     */
    fun useMapToCreateAJSONObject(): JSONObject {
        val person = mapOf(
                "name"      to "Jose",
                        "surname"   to "Kast",
                        "id"        to 666,
                        "home"      to mapOf(
                              "name" to  "KastsHouse",
                                     "location" to "Highway to hell"
                        ),
                        "isMarried" to true
        )
        return JSONObject(person)
    }




}