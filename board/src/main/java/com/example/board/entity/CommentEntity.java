package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Comment")
@Table(name = "Comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int commentId;

    @Column(nullable = false)
    private int boardNumber;

    @Column(length = 50, nullable = false)
    private String userEmail;

    @Column(columnDefinition = "TEXT")
    private String commentUserProfile;

    @Column(length = 30, nullable = false)
    private String commentUserNickname;

    @Column(nullable = false)
    private LocalDate commentWriteDate;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentContent;
}
