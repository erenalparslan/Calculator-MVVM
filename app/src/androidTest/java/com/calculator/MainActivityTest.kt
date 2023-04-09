package com.calculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.anything
import org.junit.Before
import org.junit.Test

class MainActivityTest {



    @Before
    fun setup(){
       ActivityScenario.launch(MainActivity::class.java)
    }


    val buttonIds = listOf(R.id.n0, R.id.n1, R.id.n2, R.id.n3, R.id.n4, R.id.n5, R.id.n6, R.id.n7, R.id.n8, R.id.n9,
        R.id.clear, R.id.equal, R.id.delete, R.id.divide, R.id.multiply, R.id.plus, R.id.minus, R.id.bClose, R.id.bOpen,
        R.id.dot, R.id.result, R.id.expression, R.id.my_toolbar)


        @Test
        fun displayButton() {
            for (buttonId in buttonIds) {
            Espresso.onView(ViewMatchers.withId(buttonId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))}
        }


    @Test
    fun display0Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n0)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display1Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display2Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display3Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display4Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n4)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display5Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n5)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display6Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n6)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display7Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n7)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display8Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n8)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun display9Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayClearButton(){
        Espresso.onView(ViewMatchers.withId(R.id.clear)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayEqualButton(){
        Espresso.onView(ViewMatchers.withId(R.id.equal)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayDeleteButton(){
        Espresso.onView(ViewMatchers.withId(R.id.delete)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayDivideButton(){
        Espresso.onView(ViewMatchers.withId(R.id.divide)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayMultiplyButton(){
        Espresso.onView(ViewMatchers.withId(R.id.multiply)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayPlusButton(){
        Espresso.onView(ViewMatchers.withId(R.id.plus)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayMinusButton(){
        Espresso.onView(ViewMatchers.withId(R.id.minus)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayBCloseButton(){
        Espresso.onView(ViewMatchers.withId(R.id.bClose)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayBOpenButton(){
        Espresso.onView(ViewMatchers.withId(R.id.bOpen)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayDotButton(){
        Espresso.onView(ViewMatchers.withId(R.id.dot)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayResult(){
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayExpression(){
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayToolbar(){
        Espresso.onView(ViewMatchers.withId(R.id.my_toolbar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun displayMenu(){
        Espresso.onView(isRoot()).perform(ViewActions.pressMenuKey())
        Espresso.onView(ViewMatchers.withText("Not Al")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun displayStart0(){
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }
    @Test
    fun displayResult0(){
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }

    @Test
    fun press0Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n0)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }
    @Test
    fun press1Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n1)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }
    @Test
    fun press2Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n2)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }
    @Test
    fun press3Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n3)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("3")))
    }
    @Test
    fun press4Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n4)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("4")))
    }
    @Test
    fun press5Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n5)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("5")))
    }
    @Test
    fun press6Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n6)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("6")))
    }
    @Test
    fun press7Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n7)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("7")))
    }
    @Test
    fun press8Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n8)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("8")))
    }
    @Test
    fun press9Button(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9")))
    }


    @Test
    fun pressClearButton(){
        Espresso.onView(ViewMatchers.withId(R.id.clear)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }

    @Test
    fun pressEqualsButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.equal)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9.0")))
    }

    @Test
    fun pressDeleteButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.delete)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }

    @Test
    fun pressDivideButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.divide)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9/")))
    }
    @Test
    fun pressMultiplyButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.multiply)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9*")))
    }
    @Test
    fun pressMinusButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9-")))
    }
    @Test
    fun pressPlusButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9+")))
    }
    @Test
    fun pressBOpenButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bOpen)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9(")))
    }
    @Test
    fun pressBCloseButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bOpen)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bClose)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9(9)")))
    }
    @Test
    fun pressDotButton(){
        Espresso.onView(ViewMatchers.withId(R.id.n9)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.dot)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.expression)).check(ViewAssertions.matches(ViewMatchers.withText("9.")))
    }
    @Test
    fun pressNotAl(){
        Espresso.onView(isRoot()).perform(ViewActions.pressMenuKey())
        Espresso.onView(ViewMatchers.withText("Not Al")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withText("Not Al")).perform(click())
    }

    }









