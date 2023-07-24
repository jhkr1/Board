package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")
public class LikyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int likeId;

    @Column(nullable = false)
    private int boardNumber;

    @Column(length = 50, nullable = false)
    private String userEmail;

    @Column(columnDefinition = "TEXT")
    private String likeUserProfile;

    @Column(length = 30, nullable = false)
    private String likeUserNickname;
}
