package com.lok.dev.coredata.repository

import com.lok.dev.coredatabase.dao.OMRDao
import com.lok.dev.coredatabase.entity.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OMRDatabaseRepositoryImpl @Inject constructor(
    private val omrDao: OMRDao
) : OMRDatabaseRepository {
    override fun getOMRTable(): Flow<List<OMRTable>> = omrDao.selectAllOMRTable()
    override fun addOMRTable(omrTable: OMRTable): Long = omrDao.addOMRTable(omrTable)
    override fun updateOMRTable(omrTable: OMRTable) = omrDao.updateOMRTable(omrTable)
    override fun getSubjectTable(): Flow<SubjectTable> = omrDao.selectAllSubjectTable()
    override fun getTagTable(): Flow<TagTable> = omrDao.selectAllTagTable()
    override fun getProblemTable(): Flow<ProblemTable> = omrDao.selectAllProblemTable()
    override fun getAnswerTable(): Flow<AnswerTable> = omrDao.selectAllAnswerTable()
    override fun getHistoryTable(): Flow<HistoryTable> = omrDao.selectAllHistoryTable()

}