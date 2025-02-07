package com.lok.dev.omrchecker.subject.omr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lok.dev.commonbase.BaseFragment
import com.lok.dev.commonutil.getChangeTextStyle
import com.lok.dev.commonutil.onResult
import com.lok.dev.omrchecker.R
import com.lok.dev.omrchecker.databinding.FragmentOmrInputBinding
import com.lok.dev.omrchecker.subject.OmrViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OmrInputFragment @Inject constructor() : BaseFragment<FragmentOmrInputBinding>() {

    private var adapter: OmrInputAdapter? = null

    private val viewModel: OmrInputViewModel by viewModels()
    private val omrViewModel: OmrViewModel by activityViewModels()

    override fun createFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentOmrInputBinding.inflate(inflater, container, false)

    override fun initFragment() {

        collectViewModel()
        initAdapter()
        setBody()

    }

    private fun collectViewModel() {
        omrViewModel.progressState.onResult(viewLifecycleOwner.lifecycleScope) { progress ->
            val text = String.format(getString(R.string.omr_input_cnt), progress, omrViewModel.tableData.problemNum)
            binding.omrInputCnt.text = requireActivity().getChangeTextStyle(text, progress.toString(), R.color.theme_blue_primary)
        }

        omrViewModel.saveInputData.onResult(viewLifecycleOwner.lifecycleScope) {
            viewModel.addProblemTable(adapter?.adapterList ?: mutableListOf())
        }

    }

    private fun initAdapter() {
        adapter = OmrInputAdapter(requireContext()) { pair ->
            omrViewModel.updateProgress(pair)
        }
        binding.omrInputList.adapter = adapter
        adapter?.set(omrViewModel.omrInput.value)
    }

    private fun setBody() = with(binding) {
        val text = String.format(getString(R.string.omr_input_cnt), 0, omrViewModel.tableData.problemNum)
        omrInputCnt.text = requireActivity().getChangeTextStyle(text, "0", R.color.theme_blue_primary)
    }

}