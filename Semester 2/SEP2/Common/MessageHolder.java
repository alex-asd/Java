package Common;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Palle Sohn Christensen
 */

public class MessageHolder implements Holder {
    public final String messageText;
    public String createdBy;
    public LocalDateTime createdAt;

    public MessageHolder(String messageText) {
        this.messageText = messageText;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return (this.createdBy+": "+this.messageText);
    }
}
