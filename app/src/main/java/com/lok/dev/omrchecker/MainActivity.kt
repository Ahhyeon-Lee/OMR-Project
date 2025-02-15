package com.lok.dev.omrchecker

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import com.lok.dev.commonbase.BaseActivity
import com.lok.dev.commonutil.addFragment
import com.lok.dev.omrchecker.databinding.ActivityMainBinding
import com.lok.dev.omrchecker.home.fragment.OmrListFragment
import com.lok.dev.omrchecker.subject.OmrActivity
import com.lok.dev.omrchecker.test.TestFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    @Inject lateinit var omrListFragment: OmrListFragment
    @Inject lateinit var testFragment: TestFragment

    override fun createBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initActivity(savedInstanceState: Bundle?) {
        addOmrListFragment()
        //startOmrActivity()
        //addTestFragment()
    }

    private fun addOmrListFragment() {
        addFragment(R.id.fragment, omrListFragment)
    }

    private fun addTestFragment() {
        addFragment(R.id.fragment, testFragment)
    }

    private fun startOmrActivity() {
        val intent = Intent(this, OmrActivity::class.java)
        intent.putExtras(bundleOf("type" to "omr"))
        startActivity(intent)
    }
}