package models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.NotNull;
import io.ebean.annotation.UpdatedTimestamp;

/**
 * Participant
 */
@Entity
public class Participant extends Model {
    @Id
    public Long id;
    /** 参加者名. */
    @NotNull
    public String name;
    /** メッセージ. */
    @NotNull
    public String message;
    /** 紐づくイベント. */
    @ManyToOne(cascade = CascadeType.ALL)    
    public Event event;
    /** 作成日. */
    @CreatedTimestamp
    public LocalDateTime createdAt;
    /** 更新日. */
    @UpdatedTimestamp
    public LocalDateTime updatedAt;
    /** DBアクセス. */
    public static Finder<Long, Participant> finder = new Finder<>(Participant.class);
    /** 内容表示 */
    public String toString() {
        return "Participant [id=" + id + ", name=" + name + ", message=" + message + ", event=" + event + "]";
    }
}