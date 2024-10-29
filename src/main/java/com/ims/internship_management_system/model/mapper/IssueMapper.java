package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.IssueEntity;
import com.ims.internship_management_system.model.dto.IssueDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IssueMapper {
    IssueDto toDTO(IssueEntity issueEntity);
    IssueEntity toEntity(IssueDto issueDto);
}
