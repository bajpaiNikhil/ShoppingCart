package com.example.shoppinglist.ui.shoppinglist


import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingcart.R
import com.example.shoppingcart.data.db.entities.ShoppingItem
import com.example.shoppingcart.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, private val addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    private var _binding : DialogAddShoppingItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        //setContentView(R.layout.dialog_add_shopping_item)
        _binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString().toInt()

            if(name.isEmpty()){
                binding.etName.error = "Name is required"
                binding.etAmount.error = "Amount is required"
            }

            val item = ShoppingItem(name , amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}