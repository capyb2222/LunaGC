package emu.grasscutter.data.excels.scene;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.*;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ResourceType(name = "MapLayerFloorExcelConfigData.json")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class MapLayerFloorData extends GameResource {
    @Getter
    int id;

    int IHIJBINKPAI;
    int COOJGPKCJIK;

    @SerializedName(
            value = "floorNameTextMapHash",
            alternate = {"COFPPGFELDJ"})
    long floorNameTextMapHash;

    BAGNDMMEMCN BAGNDMMEMCN;
    long JNCGDCNCHOE;

    public static class BAGNDMMEMCN {
        Unk_Type type;
        List<Integer> paramList;

        public enum Unk_Type {
            MAP_FLOOR_NAME_CHANGE_QUEST
        }
    }
}
