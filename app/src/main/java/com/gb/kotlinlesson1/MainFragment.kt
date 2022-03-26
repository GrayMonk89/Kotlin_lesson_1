package com.gb.kotlinlesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val client: Client = Client()
        initContent(view, client, true)
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.copyButton).setOnClickListener {
            initContent(view, client.copy(20, "Gray", Order(1, true, 2)), false)
        }
    }


    private fun initContent(view: View, client: Client, firstInit: Boolean) {
        if (firstInit) {
            view.findViewById<TextView>(R.id.sourceId).text = client.id.toString()
            view.findViewById<TextView>(R.id.sourceName).text = client.name
            view.findViewById<TextView>(R.id.sourceOrder).text = client.order.number.toString()
        }
        view.findViewById<TextView>(R.id.newId).text = client.id.toString()
        view.findViewById<TextView>(R.id.newName).text = client.name
        view.findViewById<TextView>(R.id.newOrder).text = client.order.number.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }
}
