package com.example.bookmarket

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookmarket.cart.CartActivity
import com.example.bookmarket.model.Book
import com.example.bookmarket.model.CartRepository.addCartItems
import com.example.bookmarket.model.CartRepository.countCartItems

class BookActivity : AppCompatActivity() {

    lateinit var imgObj: ImageView
    lateinit var bookidObj: TextView
    lateinit var nameObj: TextView
    lateinit var priceObj: TextView
    lateinit var dateObj: TextView
    lateinit var writerObj: TextView
    lateinit var descriptionObj: TextView
    lateinit var categoryObj: TextView

    lateinit var cartplusObj: Button
    var cartCount: TextView? = null //수정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.book)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgObj = findViewById(R.id.imageView1)
        bookidObj = findViewById(R.id.book_tv01)
        nameObj = findViewById(R.id.book_tv02)
        priceObj = findViewById(R.id.book_tv03)
        dateObj = findViewById(R.id.book_tv04)
        writerObj = findViewById(R.id.book_tv05)
        descriptionObj = findViewById(R.id.book_tv06)
        categoryObj = findViewById(R.id.book_tv07)

        var intent = getIntent()
        bookidObj.text = intent.getStringExtra("bookid")
        nameObj.text = intent.getStringExtra("name")
        priceObj.text = intent.getStringExtra("price")
        dateObj.text = intent.getStringExtra("date")
        writerObj.text = intent.getStringExtra("writer")
        descriptionObj.text = intent.getStringExtra("description")
        categoryObj.text = intent.getStringExtra("category")



        when (bookidObj.text) {
            "BOOK1234" -> {
                imgObj.setImageResource(R.drawable.books_book1)

            }

            "BOOK1235" -> {
                imgObj.setImageResource(R.drawable.books_book2)
            }

            "BOOK1236" -> {
                imgObj.setImageResource(R.drawable.books_book3)
            }

            "BOOK1237" -> {
                imgObj.setImageResource(R.drawable.books_book4)
            }

        }

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val mBook: Book = Book()

        mBook.bookid = bookidObj.text.toString()
        mBook.name = nameObj.text.toString()
        mBook.price = Integer.parseInt(priceObj.text.toString())
        mBook.date = dateObj.text.toString()
        mBook.writer = writerObj.text.toString()
        mBook.description = descriptionObj.text.toString()
        mBook.category = categoryObj.text.toString()
        mBook.quantity = 0;


        //cartCount = findViewById(R.id.hotlist_hot)
        cartplusObj = findViewById(R.id.book_bt01)
        cartplusObj.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.icon_dialog)
            alertDialog.setTitle("장바구니 담기")
            alertDialog.setMessage("도서를 장바구니에 추가하겠습니까?")
            // alertDialog.setIcon(R.drawable.dialog_cat)

            val listener = DialogInterface.OnClickListener { dialogInterface, i ->
                when (i) {
                    DialogInterface.BUTTON_POSITIVE -> {

                        //    var count = Integer.parseInt(cartCount.text.toString()) + 1
                        //    cartCount.text = count.toString()
                        addCartItems(mBook)
                        cartCount?.text = countCartItems().toString()
                        dialogInterface.dismiss()
                    }

                    DialogInterface.BUTTON_NEGATIVE -> {

                        dialogInterface.cancel()
                    }
                }
            }
            alertDialog.setPositiveButton("예", listener)
            alertDialog.setNegativeButton("아니요", listener)
            alertDialog.show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_book, menu)
        // menuInflater.inflate(R.menu.menu_book,menu)

        val item = menu?.findItem(R.id.menu_cart)
        item?.setActionView(R.layout.cart_count_layout )

        val oklayout  = item?.actionView
        if (oklayout != null) {
            cartCount = oklayout.findViewById(R.id.cart_count)
            val view : View = oklayout.findViewById(R.id.cart_image) //장바구니 액션버튼

            cartCount?.text = countCartItems().toString()

            view.setOnClickListener {  //장바구니 액션버튼 클릭 이벤트 처리
                val myIntent = Intent(this, CartActivity::class.java)
                startActivity(myIntent)
            }

        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            android.R.id.home->{
                onBackPressed()

            }
            R.id.menu_home -> {
                Toast.makeText(applicationContext,"홈으로 메뉴를 클릭하였습니다", Toast.LENGTH_LONG).show()
                finish()
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_list -> {
                Toast.makeText(applicationContext,"도서목록 메뉴를 클릭하였습니다",Toast.LENGTH_LONG).show()
                finish()
                val intent: Intent = Intent(this, BooksActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_cart -> {
                Toast.makeText(applicationContext,"장바구니 메뉴를 클릭하였습니다",Toast.LENGTH_LONG).show()

                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }


}