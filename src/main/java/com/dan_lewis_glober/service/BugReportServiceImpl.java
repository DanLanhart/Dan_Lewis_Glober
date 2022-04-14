package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.BugReport;
import com.dan_lewis_glober.repository.BugReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugReportServiceImpl implements BugReportService {

    @Autowired
    private BugReportRepository bugReportRepository;

    @Override
    public List<BugReport> getAllBugReports() {
        return bugReportRepository.findAll();
    }

    @Override
    public void saveBugReport(BugReport bugReport) {
        this.bugReportRepository.save(bugReport);
    }

    @Override
    public void deleteBugReportById(long id) {
        this.bugReportRepository.deleteById(id);
    }
}
