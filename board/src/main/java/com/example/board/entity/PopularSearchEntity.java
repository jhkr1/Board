package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PopularSearch")
@Table(name = "PopularSearch")
public class PopularSearchEntity {
    @Id
    @Column(length = 200)
    private String popularTerm;

    @Column
    private int popularSearchCount;

}
