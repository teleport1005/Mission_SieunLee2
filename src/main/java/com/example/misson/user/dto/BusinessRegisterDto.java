package com.example.misson.user.dto;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRegisterDto {
    private Long id;

    @Setter
    private Long userId;
    @Setter
    private String businessNum;

    public static BusinessRegisterDto fromEntity(BusinessRegisterDto entity) {
        return BusinessRegisterDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .businessNum(entity.getBusinessNum())
                .build();
    }

}
