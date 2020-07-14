package com.dara.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding_object.*

class OnboardingObjectFragment : Fragment(R.layout.fragment_onboarding_object) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve arguments
        val image = arguments?.getInt("image") ?: R.drawable.img_clock
        val primaryText = arguments?.getInt("primaryText") ?: R.string.keep_calm
        val secondaryText = arguments?.getInt("secondaryText") ?: R.string.feel_less_stressed

        // Populate UI
        img_illustration.setImageResource(image)
        tv_main_text.text = getString(primaryText)
        tv_secondary_text.text = getString(secondaryText)

    }

    fun newInstance(image: Int, primaryText: Int, secondaryText: Int): OnboardingObjectFragment {
        val args = Bundle().apply {
            putInt("image", image)
            putInt("primaryText", primaryText)
            putInt("secondaryText", secondaryText)
        }

        val fragment = OnboardingObjectFragment()
        fragment.arguments = args
        return fragment
    }


}