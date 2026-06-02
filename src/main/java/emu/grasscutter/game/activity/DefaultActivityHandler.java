package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.net.proto.ActivityInfo;

@GameActivity(ActivityType.NONE)
public class DefaultActivityHandler extends ActivityHandler {
    @Override
    public void onProtoBuild(
            PlayerActivityData playerActivityData,
            ActivityInfo.Builder activityInfo) {}

    @Override
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {}
}
