package emu.grasscutter.game.achievement;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.Achievement.Status;
import lombok.*;

@Entity
@Getter
public class Achievement {
    @Setter private Status status;
    private int id;
    private int totalProgress;
    @Setter private int curProgress;
    @Setter private int finishTimestampSec;

    public Achievement(
            Status status, int id, int totalProgress, int curProgress, int finishTimestampSec) {
        this.status = status;
        this.id = id;
        this.totalProgress = totalProgress;
        this.curProgress = curProgress;
        this.finishTimestampSec = finishTimestampSec;
    }

    public emu.grasscutter.net.proto.Achievement toProto() {
        return emu.grasscutter.net.proto.Achievement.newBuilder()
                .setStatus(this.getStatus())
                .setId(this.getId())
                .setTotalProgress(this.getTotalProgress())
                .setCurProgress(this.getCurProgress())
                .setFinishTimestamp(this.getFinishTimestampSec())
                .build();
    }
}
