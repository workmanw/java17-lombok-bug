package com.workmanw.java17.lombok.bug;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class MyTestDto {
    @Builder.Default
    private List<@Length String> footer = List.of();
}
