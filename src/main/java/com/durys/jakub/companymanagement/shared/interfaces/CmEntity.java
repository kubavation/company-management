package com.durys.jakub.companymanagement.shared.interfaces;

import com.durys.jakub.companymanagement.shared.enums.Status;

public interface CmEntity<T> {
   T getId();
   Status getStatus();
   void setStatus(Status status);
}
