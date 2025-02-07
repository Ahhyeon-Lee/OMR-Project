package com.lok.dev.commonmodel.state

sealed class SubjectState {
    object None: SubjectState()
    object Select: SubjectState()
    object Add: SubjectState()
    object Edit: SubjectState()
    object Exit: SubjectState()
}