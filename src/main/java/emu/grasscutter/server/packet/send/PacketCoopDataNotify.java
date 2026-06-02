package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CoopChapter;
import emu.grasscutter.net.proto.CoopDataNotify;
import emu.grasscutter.net.proto.CoopPoint;

public class PacketCoopDataNotify extends BasePacket {

    public PacketCoopDataNotify() {
        super(PacketOpcodes.CoopDataNotify);

        var proto = CoopDataNotify.newBuilder();
        proto.setIsHaveProgress(false);

        // TODO: implement: determine the actual current progress point.
        // Add every chapter and add the start point to each chapter regardless of actual progress.
        GameData.getCoopChapterDataMap()
                .values()
                .forEach(
                        i -> {
                            var chapter = CoopChapter.newBuilder();
                            chapter.setId(i.getId());

                            // TODO: implement: look at unlockCond to determine what state each chapter should be
                            // in.
                            // Set every chapter to "Accept" regardless of accept conditions.
                            chapter.setStateValue(3); // 3 == STATE_ACCEPT

                            var point = CoopPoint.newBuilder();
                            var pointList =
                                    GameData.getCoopPointDataMap().values().stream()
                                            .filter(
                                                    j -> j.getChapterId() == i.getId() && j.getType().equals("POINT_START"))
                                            .toList();

                            if (!pointList.isEmpty()) {
                                int pointId = pointList.get(0).getId();
                                point.setId(pointId);
                                chapter.addCoopPointList(point);
                            }

                            proto.addChapterList(chapter);
                        });

        this.setData(proto);
    }
}
