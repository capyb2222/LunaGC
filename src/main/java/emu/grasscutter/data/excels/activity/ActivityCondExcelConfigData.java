package emu.grasscutter.data.excels.activity;

import emu.grasscutter.data.*;
import emu.grasscutter.game.activity.condition.ActivityConditions;
import emu.grasscutter.game.quest.enums.LogicType;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ResourceType(name = "NewActivityCondExcelConfigData.json")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivityCondExcelConfigData extends GameResource {
    int condId;
    LogicType condComb;
    List<ActivityConfigCondition> cond;

    public static class ActivityConfigCondition {
        @Getter private ActivityConditions type;
        @Getter private List<String> param;
    
        public int[] paramArray() {
            return param.stream()
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
    }

    @Override
    public int getId() {
        return condId;
    }

    @Override
    public void onLoad() {
        cond.removeIf(c -> c.type == null);
    }
}
