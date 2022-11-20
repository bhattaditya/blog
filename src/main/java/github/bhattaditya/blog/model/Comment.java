package github.bhattaditya.blog.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_comment")
@Data
public class Comment extends baseObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Post post;

    @OneToOne
    private User user;
}
