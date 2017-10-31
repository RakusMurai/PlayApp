package controllers.forms;

import models.Event;

/** 参加者を受け取るフォーム. */
public class ParticipantForm {
    /** 参加者名. */
    public String name;
    /** メッセージ. */
    public String message;
    /** 紐づくイベント. */
    public Event event;
}