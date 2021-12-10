package com.workmanw.java17.lombok.bug;

import lombok.Builder;

import java.util.List;

@Builder
class MyTestDto {
    @Builder.Default
    private List<@Length String> footer = List.of();
}
