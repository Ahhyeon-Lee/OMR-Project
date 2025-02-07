package com.lok.dev.omrchecker.setting.subject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.lok.dev.commonbase.BaseFragment
import com.lok.dev.commonmodel.state.SubjectState
import com.lok.dev.commonutil.throttleFirstClick
import com.lok.dev.omrchecker.databinding.FragmentSubjectAddBinding
import com.lok.dev.omrchecker.setting.viewmodel.SettingViewModel
import javax.inject.Inject

class SubjectAddFragment @Inject constructor() : BaseFragment<FragmentSubjectAddBinding>() {

    private val viewModel by activityViewModels<SettingViewModel>()

    override val enableBackPressed = true

    override fun createFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSubjectAddBinding.inflate(inflater, container, false)

    override fun initFragment() {
        addListeners()
    }

    private fun addListeners() = with(binding) {
        throttleFirstClick(tvSave) {
            if(etSubjectTitle.text.isNotEmpty()) {
                viewModel.addSubject(etSubjectTitle.text.toString())
                viewModel.setSubjectState(SubjectState.Select)
            }
            else {
                Toast.makeText(requireContext(), "과목명을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}