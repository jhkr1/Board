package com.example.board.entity;

import lombok.*;
import org.springframework.web.bind.annotation.Mapping;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    @Id
    @Column(length = 50)
    private String userEmail;

    @Column(length = 20, nullable = false)
    private String userPassword;

    @Column(length = 30, nullable = false)
    private String userNickname;

    @Column(length = 15, nullable = false)
    private String userPhoneNumber;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userAddress;

    @Column(columnDefinition = "TEXT")
    private String userProfile;


}
