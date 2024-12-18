package com.dailycodework.universalpetcare.model.product;

import com.dailycodework.universalpetcare.enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "tool_id")
public class Tool extends Product{
    private Long id;

    @Column(name = "type_tool")
    private String typeTool;

    @Column(name = "material")
    private String material; // Chất liệu

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size; // Kích thước (S, M, L)
}
