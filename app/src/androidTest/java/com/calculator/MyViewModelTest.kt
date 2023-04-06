package com.calculator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyViewModelTest {

    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        viewModel = MyViewModel()
    }

    @get:Rule
    var instantTaskExecute= InstantTaskExecutorRule()

    @Test
    fun addNumber_shouldAddCorrectly() {
        viewModel.addNumber("1")
        viewModel.addNumber("2")
        viewModel.addNumber(".")
        viewModel.addNumber("3")
        assertEquals("12.3", viewModel.exp.value)
    }

    @Test
    fun addNumber_shouldNotAllowMultipleDots() {
        viewModel.addNumber("1")
        viewModel.addNumber(".")
        viewModel.addNumber("2")
        viewModel.addNumber(".")
        viewModel.addNumber("3")
        assertEquals("1.23", viewModel.exp.value)
    }

    @Test
    fun addNumber_shouldHandleLeadingZeros() {
        viewModel.addNumber("0")
        viewModel.addNumber(".")
        viewModel.addNumber("5")
        viewModel.addNumber("2")
        assertEquals("0.52", viewModel.exp.value)
    }

    @Test
    fun bOpen_shouldAddOpeningBracket() {
        viewModel.addNumber("5")
        viewModel.bOpen()
        viewModel.addNumber("3")
        viewModel.bClose()
        assertEquals("5(3)", viewModel.exp.value)
    }

    @Test
    fun bOpen_shouldNotAllowOperatorBeforeOpeningBracket() {
        viewModel.addNumber("5")
        viewModel.addOperator('+')
        viewModel.bOpen()
        assertEquals("5+(", viewModel.exp.value)
    }

    @Test
    fun bClose_shouldAddClosingBracket() {
        viewModel.addNumber("5")
        viewModel.bOpen()
        viewModel.addNumber("3")
        viewModel.bClose()
        viewModel.bClose()
        assertNotEquals("5(3))", viewModel.exp.value)
    }

    @Test
    fun bClose_shouldNotAllowClosingBracketBeforeOpeningBracket() {
        viewModel.bClose()
        assertEquals("0", viewModel.exp.value)
    }

    @Test
    fun addOperator_shouldAddCorrectly() {
        viewModel.addNumber("5")
        viewModel.addOperator('+')
        viewModel.addNumber("3")
        assertEquals("5+3", viewModel.exp.value)
    }

    @Test
    fun addOperator_shouldNotAllowMultipleOperators() {
        viewModel.addNumber("5")
        viewModel.addOperator('+')
        viewModel.addOperator('-')
        viewModel.addOperator('*')
        viewModel.addOperator('/')
        assertEquals("5+", viewModel.exp.value)
    }

    @Test
    fun addOperator_shouldAllowMinusAsFirstCharacter() {
        viewModel.addOperator('-')
        viewModel.addNumber("3")
        assertEquals("-3", viewModel.exp.value)
    }

    @Test
    fun reset_shouldResetValues() {
        viewModel.addNumber("5")
        viewModel.addOperator('+')
        viewModel.addNumber("3")
        viewModel.reset()
        assertEquals("0", viewModel.exp.value)
        assertEquals("0", viewModel.answer.value)
    }

    @Test
    fun delete_shouldRemoveLastCharacter() {
        viewModel.addNumber("5")
        viewModel.addOperator('+')
        viewModel.addNumber("3")
        viewModel.delete()
        assertEquals("5+", viewModel.exp.value)
    }

    @Test
    fun delete_shouldResetValuesIfOnlyOneCharacterLeft() {
        viewModel.addNumber("5")
        viewModel.delete()
        assertEquals("0", viewModel.exp.value)
        assertEquals("0", viewModel.answer.value)
    }
}