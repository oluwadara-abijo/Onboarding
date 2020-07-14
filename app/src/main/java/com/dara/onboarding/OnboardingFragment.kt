package com.dara.onboarding

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_onboarding.*

private const val NUM_SCREENS = 3

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private lateinit var viewPager: ViewPager
    private lateinit var onboardingAdapter: OnboardingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = onboarding_view_pager
        onboardingAdapter = OnboardingAdapter(childFragmentManager)
        viewPager.adapter = onboardingAdapter
        indicator.attachToPager(viewPager)

        // Handle the back button event
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (viewPager.currentItem == 0) {
                requireActivity().finish()
            } else {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

    }

    private inner class OnboardingAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                1 -> OnboardingObjectFragment().newInstance(
                    R.drawable.img_meditate,
                    R.string.mindfulness,
                    R.string.the_mind_is_powerful
                )
                2 -> OnboardingObjectFragment().newInstance(
                    R.drawable.img_focus,
                    R.string.stay_focused,
                    R.string.maintain_focus
                )
                else -> OnboardingObjectFragment()
            }
        }

        override fun getCount(): Int = NUM_SCREENS

    }

}

