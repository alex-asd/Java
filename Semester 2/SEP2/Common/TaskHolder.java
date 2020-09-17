package Common;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Palle Sohn Christensen
 */

public class TaskHolder implements Holder {
    public int taskID = -1;
    public String TASK_TYPE = "TODO";
    public String createdBy;
    public LocalDateTime createdAt;
    public String taskText;

    public TaskHolder(String TASK_TYPE, String taskText) {
        this.TASK_TYPE = TASK_TYPE;
        this.taskText = taskText;
    }

    @Override
    public String toString() {
        return taskText;
    }

    @Override
    public boolean equals(Object obj) {
        if ((TaskHolder)obj != null) {
            if (((TaskHolder) obj).taskID != -1
                    && ((TaskHolder) obj).taskID == this.taskID) {
                return true;
            }

        }
        return false;
    }
}
