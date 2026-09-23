CREATE TABLE messages
(
    id           UUID                           NOT NULL,
    message      VARCHAR(255)                   NOT NULL,
    sender_id    UUID                           NOT NULL,
    recipient_id UUID                           NOT NULL,
    created_at   TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_messages PRIMARY KEY (id)
);

ALTER TABLE messages
    ADD CONSTRAINT FK_MESSAGES_ON_RECIPIENT FOREIGN KEY (recipient_id) REFERENCES users (id);

ALTER TABLE messages
    ADD CONSTRAINT FK_MESSAGES_ON_SENDER FOREIGN KEY (sender_id) REFERENCES users (id);