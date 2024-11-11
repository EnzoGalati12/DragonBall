package com.example.dragonballgs.presentation.all

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dragonballgs.R
import com.example.dragonballgs.databinding.ActivityDragonBallAllBinding
import com.example.dragonballgs.databinding.ActivityDragonBallHistoryBinding
import com.example.dragonballgs.presentation.history.DragonBallHistoryListAdapter
import com.example.dragonballgs.presentation.history.DragonBallViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DragonBallAllActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragonBallAllBinding
    private val viewModel: DragonBallAllViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragonBallAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAll()

        viewModel.dragonAllHistory.observe(this) {
            val adapter = DragonBallAllListAdapter()
            binding.rvAll.adapter = adapter
            binding.rvAll.layoutManager = LinearLayoutManager(this)
            adapter.setDragons(it)
        }
    }
}
