package com.durys.jakub.companymanagement.shared.logs.service;

import com.durys.jakub.companymanagement.shared.logs.model.CmLog;
import com.durys.jakub.companymanagement.shared.logs.repository.CmLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CmLogService {

    private final CmLogRepository cmLogRepository;

    public void log(CmLog log) {
        cmLogRepository.save(log);
    }
}
