package models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.NotNull;
import io.ebean.annotation.UpdatedTimestamp;

/**
 * Article
 */
@Entity
public class Event extends Model {
    @Id
    public Long id;
    @NotNull
    /** イベント名. */
    public String name;
    @NotNull
    /** 内容. */
    public String article;
    @OneToMany
    public List<Participant> participants;
    /** 作成日. */
    @CreatedTimestamp
    public LocalDateTime createdAt;
    /** 更新日. */
    @UpdatedTimestamp
    public LocalDateTime updatedAt;
    /** DBアクセス. */
    public static Finder<Long, Event> finder = new Finder<>(Event.class);

    /** 内容表示 */
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", message=" + article + "]";
    }

    // public static Event findById(String input) {
    //     return Event.finder.byId(Long.parseLong(input));
    // }
}