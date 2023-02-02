package com.durys.jakub.companymanagement.shared.interfaces;

import com.durys.jakub.companymanagement.shared.enums.CmStatus;

public interface CmEntity<T> {
   T getId();
   CmStatus getStatus();
   void setStatus(CmStatus cmStatus);
}
