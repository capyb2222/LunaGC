package emu.grasscutter.game.home;

import dev.morphia.annotations.*;
import emu.grasscutter.net.proto.FurnitureMakeData;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(builderMethodName = "of")
public class FurnitureMakeSlotItem {
    @Id int index;
    int makeId;
    int avatarId;
    int beginTime;
    int durTime;

    public FurnitureMakeData toProto() {
        return FurnitureMakeData.newBuilder()
                .setIndex(index)
                .setAvatarId(avatarId)
                .setMakeId(makeId)
                .setBeginTime(beginTime)
                .setDurTime(durTime)
                .build();
    }
}
