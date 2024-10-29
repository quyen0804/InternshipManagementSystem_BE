package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.IssueReceiverEntity;
import com.ims.internship_management_system.model.dto.IssueReceiverDto;
import org.mapstruct.Mapper;

@Mapper
public interface IssueReceiverMapper {
    IssueReceiverDto toDTO(IssueReceiverEntity issueReceiverEntity);
    IssueReceiverEntity toEntity(IssueReceiverDto issueReceiverDto);
}
