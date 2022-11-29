package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import java.util.List;

public interface AcceptantRepository {

    Acceptant load(AcceptantId id);

    List<Acceptant> findAvailable();

}
