package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.FeedbackEntity;
import com.ims.internship_management_system.model.dto.FeedbackDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackDto toDTO(FeedbackEntity feedbackEntity);
    FeedbackEntity toEntity(FeedbackDto feedbackDto);
}
