package com.dara.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_keep_calm.*

class KeepCalmFragment : Fragment(R.layout.fragment_keep_calm),
    OnboardingFragment.ButtonClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btn_next.setOnClickListener { OnboardingFragment().goToNextScreen(2) }
    }

    override fun onButtonClick(pageNumber: Int) {
        TODO("Not yet implemented")
    }

}