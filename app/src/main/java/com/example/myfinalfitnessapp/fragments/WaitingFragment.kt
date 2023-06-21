package com.example.myfinalfitnessapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfinalfitnessapp.R
import com.example.myfinalfitnessapp.adapters.ExerciseAdapter
import com.example.myfinalfitnessapp.databinding.ExercisesListFragmentBinding
import com.example.myfinalfitnessapp.databinding.FragmentDaysBinding
import com.example.myfinalfitnessapp.databinding.WaitingFragmentBinding
import com.example.myfinalfitnessapp.utils.FragmentManager
import com.example.myfinalfitnessapp.utils.MainViewModel
import com.example.myfinalfitnessapp.utils.TimeUtils

const val COUNT_DOWN_TIME = 11000L
class WaitingFragment : Fragment() {
    private var ab: ActionBar? = null
    private lateinit var binding: WaitingFragmentBinding
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ab = (activity as AppCompatActivity).supportActionBar
        ab?.title = getString(R.string.waiting)
        binding.pBar.max = COUNT_DOWN_TIME.toInt()
        startTimer()

    }

    private fun startTimer() = with(binding) {
        timer = object : CountDownTimer(COUNT_DOWN_TIME, 1) {
            override fun onTick(restTime: Long) {
                tvTimer.text = TimeUtils.getTime(restTime)
                pBar.progress = restTime.toInt()
            }

            override fun onFinish() {
                FragmentManager.setFragment(ExercisesFragment.newInstance(), activity as AppCompatActivity)
            }

        } .start()
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance() = WaitingFragment()
    }
}