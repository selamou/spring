package com.formation.formation.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
@Column
    private String avatar;
    @Column
    private String telephone;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
