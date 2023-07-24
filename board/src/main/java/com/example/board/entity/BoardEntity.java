package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Board")
@Table(name = "Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int boardNumber;

    @Column(length = 200, nullable = false)
    private String boardTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String boardContent;

    @Column(columnDefinition = "TEXT")
    private String boardImage;

    @Column(columnDefinition = "TEXT")
    private String boardVideo;

    @Column(columnDefinition = "TEXT")
    private String boardFile;

    @Column(length = 50, nullable = false)
    private String boardWriterEmail;

    @Column(columnDefinition = "TEXT")
    private String boardWriterProfile;

    @Column(length = 30, nullable = false)
    private String boardWriterNickname;

    @Column(nullable = false)
    private LocalDate boardWriteDate;

    @Column
    private int boardClickCount;

    @Column
    private int boardLikeCount;

    @Column
    private int boardCommentCount;
}
