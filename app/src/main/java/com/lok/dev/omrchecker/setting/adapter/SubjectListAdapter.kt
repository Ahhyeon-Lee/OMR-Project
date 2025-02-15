package com.lok.dev.omrchecker.setting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lok.dev.commonbase.BaseAdapter
import com.lok.dev.commonbase.BaseViewHolder
import com.lok.dev.coredatabase.entity.SubjectTable
import com.lok.dev.omrchecker.databinding.ItemSubjectBinding

class SubjectListAdapter(
    val context: Context,
    val clickCallback: (SubjectTable) -> Unit
) : BaseAdapter<ItemSubjectBinding, SubjectTable>() {

    override fun getBinding(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemSubjectBinding> =
        ItemSubjectListViewHolder(
            ItemSubjectBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    inner class ItemSubjectListViewHolder(
        binding: ItemSubjectBinding
    ) : BaseViewHolder<ItemSubjectBinding>(binding) {
        override fun bind(position: Int): Unit = with(binding) {
            val data = adapterList[position]
            tvSubjectTitle.text = data.name
            rootLayout.setOnClickListener {
                clickCallback.invoke(data)
            }
        }
    }
}