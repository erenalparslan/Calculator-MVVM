package com.calculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    lateinit var exp: TextView
    lateinit var result: TextView
    lateinit var scrollView: HorizontalScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        exp = findViewById(R.id.expression)
        result = findViewById(R.id.result)
        scrollView = findViewById(R.id.scrollView)

        setSupportActionBar(my_toolbar)


        n0.setOnClickListener { clickedN(0) }
        n1.setOnClickListener { clickedN(1) }
        n2.setOnClickListener { clickedN(2) }
        n3.setOnClickListener { clickedN(3) }
        n4.setOnClickListener { clickedN(4) }
        n5.setOnClickListener { clickedN(5) }
        n6.setOnClickListener { clickedN(6) }
        n7.setOnClickListener { clickedN(7) }
        n8.setOnClickListener { clickedN(8) }
        n9.setOnClickListener { clickedN(9) }
        dot.setOnClickListener { clickedN(-1) }

        bOpen.setOnClickListener { clickedB('o') }
        bClose.setOnClickListener { clickedB('c') }

        plus.setOnClickListener { clickedO('+') }
        minus.setOnClickListener { clickedO('-') }
        divide.setOnClickListener { clickedO('/') }
        multiply.setOnClickListener { clickedO('*') }

        delete.setOnClickListener { clickedA(it) }
        clear.setOnClickListener { clickedA(it) }
        equal.setOnClickListener { clickedA(it) }

        //Denklemi ve sonucu sürekli olarak gözlüyoruz.

        viewModel.exp.observe(this, {
            exp.text = it
        })

        viewModel.answer.observe(this, {
            result.text = it
        })
    }

    //Hangi tuşa basıldığını gruplandırıp gerekli fonksiyonlara yolluyoruz.Her clickte scrollView sağa doğru kayıyor.

    private fun clickedA(it: View) {
        when (it.id) {
            R.id.delete -> viewModel.delete()
            R.id.equal -> viewModel.equate()
            R.id.clear -> viewModel.reset()
        }
        scrollView.postDelayed({
            kotlin.run {
                scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
        }, 100L)
    }

    private fun clickedO(o: Char) {
        viewModel.addOperator(o)
        scrollView.postDelayed({
            kotlin.run {
                scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
        }, 100L)
    }

    private fun clickedB(c: Char) {
        if (c == 'o')

            viewModel.bOpen()
        else
            viewModel.bClose()
        scrollView.postDelayed({
            kotlin.run {
                scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
        }, 100L)
    }

    private fun clickedN(n: Int) {
        if (n != -1)
            viewModel.addNumber(n.toString())
        else
            viewModel.addNumber(".")
        scrollView.postDelayed({
            kotlin.run {
                scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
        }, 100L)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_art_item) {
            val intent = Intent(this@MainActivity, extra::class.java)
            intent.putExtra("result", result.text.toString())
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}