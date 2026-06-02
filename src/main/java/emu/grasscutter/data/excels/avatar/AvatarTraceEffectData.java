package emu.grasscutter.data.excels.avatar;

import emu.grasscutter.data.*;
import lombok.*;

@ResourceType(name = "AvatarTraceEffectExcelConfigData.json")
public class AvatarTraceEffectData extends GameResource {
    private int avatarId;
    private int itemId;

    @Override
    public int getId() {
        return this.itemId;
    }

    @Override
    public void onLoad() {
        GameData.getAvatarTraceEffectDataMap().put(this.getId(), this);
    }
}
