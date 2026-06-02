package emu.grasscutter.game.dungeons;

import emu.grasscutter.net.proto.GrantReason;
import emu.grasscutter.net.proto.TrialAvatarGrantRecord;
import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
public class DungeonTrialTeam {
    List<Integer> trialAvatarIds;
    GrantReason grantReason;
}
