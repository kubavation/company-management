package com.durys.jakub.companymanagement.domain.contracts.employment.trail;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.ContractNumber;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


public class TrailEmployeeContract extends Contract implements EmploymentContract {

    public TrailEmployeeContract(ContractId contractId, EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        super(contractId, employeeId, contractNumber, contractData);
    }


}
