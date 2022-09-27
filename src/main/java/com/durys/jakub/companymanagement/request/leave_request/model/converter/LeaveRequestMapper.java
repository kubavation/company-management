package com.durys.jakub.companymanagement.request.leave_request.model.converter;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {

    LeaveRequestMapper INSTANCE = Mappers.getMapper(LeaveRequestMapper.class);

    LeaveRequest toEntity(LeaveRequestDTO dto);
    List<LeaveRequest> toEntity(List<LeaveRequestDTO> dto);
    LeaveRequestDTO toDTO(LeaveRequest entity);
    List<LeaveRequestDTO> toDTO(List<LeaveRequest> entity);
}
