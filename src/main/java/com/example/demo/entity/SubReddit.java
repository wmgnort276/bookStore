package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubReddit extends BaseEntity{
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private LocalDateTime create_time;
    private LocalDateTime modified_time;
    @OneToMany
    private List<Post> posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser user;
}
