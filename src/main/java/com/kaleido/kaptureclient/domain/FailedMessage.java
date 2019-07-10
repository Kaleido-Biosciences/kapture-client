/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Messages from SNS that fail to marshall to another object
 */
public class FailedMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The ID of the Message
     */
    @NotNull
    private String messageId;

    /**
     * ARN of the topic message came from
     */
    @NotNull
    private String topicARN;

    /**
     * Content of message that failed
     */
    @NotNull
    private String content;

    /**
     * Error Message
     */
    @NotNull
    private String errorMessage;

    /**
     * Time message failed
     */
    private ZonedDateTime timestamp;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public FailedMessage messageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTopicARN() {
        return topicARN;
    }

    public FailedMessage topicARN(String topicARN) {
        this.topicARN = topicARN;
        return this;
    }

    public void setTopicARN(String topicARN) {
        this.topicARN = topicARN;
    }

    public String getContent() {
        return content;
    }

    public FailedMessage content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public FailedMessage errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public FailedMessage timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FailedMessage failedMessage = (FailedMessage) o;
        if (failedMessage.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), failedMessage.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FailedMessage{" +
            "id=" + getId() +
            ", messageId='" + getMessageId() + "'" +
            ", topicARN='" + getTopicARN() + "'" +
            ", content='" + getContent() + "'" +
            ", errorMessage='" + getErrorMessage() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
}
